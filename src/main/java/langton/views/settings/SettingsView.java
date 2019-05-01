package langton.views.settings;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import langton.controllers.SettingsController;
import langton.data.Settings;

/**
 * @author Gerome Wiss
 * @version 05_04_2019
 *
 * The SettingsView class is used to give the user an interface to change the settings of the algorithm.
 */
public class SettingsView {
    private Stage stage;
    private BorderPane root;
    private GridPane contentPane;
    private CheckBox torusCheckBox, antRenderingCheckBox;
    private Settings settings;
    private SettingsController controller;
    private Slider tickSlider;

    /**
     * @param settings The current settings that are being used by the algorithm.
     */
    public SettingsView(Settings settings, SettingsController controller) {
        this.settings = settings;
        this.controller = controller;

        contentPane = new GridPane();
        contentPane.getStyleClass().add("contentPane");
        contentPane.setVgap(10);
        contentPane.setHgap(10);

        root = new BorderPane(contentPane);

        this.createCheckBoxes();
        this.createSlider();
        this.createFooter();

        root.getStyleClass().add("root");
        root.setPrefSize(350, 500);
        root.getStylesheets().add("stylesheets/settingsViewStyles.css");
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(controller::handleOnCloseRequest);
        stage.setAlwaysOnTop(true);
    }

    /**
     * Creates the checkboxes that are used for true/false inputs.
     */
    private void createCheckBoxes() {
        // Checkbox to ask the user, whether he wants to use a torus as the map.
        torusCheckBox = new CheckBox();
        if(settings.useTorus()) {
            torusCheckBox.setSelected(true);
        }
        Label torusLabel = new Label("Use Torus");
        contentPane.addRow(0, torusCheckBox, torusLabel);

        // Checkbox for drawing ant or not
        antRenderingCheckBox = new CheckBox();
        if(settings.renderAnts()) {
            antRenderingCheckBox.setSelected(true);
        }
        Label antRenderingLabel = new Label("Render ants");
        contentPane.addRow(1, antRenderingCheckBox, antRenderingLabel);
    }

    /**
     * Creates the slider that is used to regulate how many ticks pass per second.
     */
    private void createSlider() {
        tickSlider = new Slider(1, 100, settings.getTicksPerSecond());
        tickSlider.setShowTickLabels(true);

        Label tickSliderLabel = new Label("Moves per Second");

        contentPane.addRow(2, tickSlider, tickSliderLabel);
    }

    /**
     * Creates the footer section.
     */
    private void createFooter() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER_RIGHT);
        footer.setSpacing(10);
        root.setBottom(footer);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(controller::handleSubmitButtonClick);
        Button applyButton = new Button("Apply");
        applyButton.setOnAction(controller::handleApplyButtonClick);
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(controller::handleCancelButtonClick);

        footer.getChildren().addAll(cancelButton, applyButton, submitButton);
    }

    /**
     * Closes the settings window.
     */
    public void close() {
        this.stage.close();
    }

    /**
     * Shows the window and prevents the user from interacting with any other stage.
     */
    public void showAndWait() {
        if(!stage.isShowing()) {
            stage.showAndWait();
        }
    }

    /**
     * @return Returns the checkbox responsible for the torus-setting.
     */
    public CheckBox getTorusCheckBox() {
        return torusCheckBox;
    }

    /**
     * @return Returns the checkbox responsible for the rendering-setting.
     */
    public CheckBox getAntRenderingCheckBox() {
        return antRenderingCheckBox;
    }

    /**
     * @return Returns the slider responsible for the ticks-per-second-setting.
     */
    public Slider getTickSlider() {
        return tickSlider;
    }

    /**
     * @param alwaysOnTop Sets the alwaysOnTop attribute of the stage.
     */
    public void setAlwaysOnTop(boolean alwaysOnTop) {
        stage.setAlwaysOnTop(alwaysOnTop);
    }

    /**
     *
     * @return Returns true if the stage is showing and false if it is not.
     */
    public boolean isShowing() {
        return stage.isShowing();
    }
}
