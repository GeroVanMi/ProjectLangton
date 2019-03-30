package langton.views.settings;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import langton.controllers.SettingsController;
import langton.data.Settings;

/**
 * @author Gerome Wiss
 * @version 28_03_2019
 *
 * TODO: Update JavaDoc
 */
public class SettingsView {
    private Stage stage;
    private BorderPane root;
    private GridPane contentPane;
    private CheckBox torusCheckBox, antRenderingCheckBox;
    private Settings settings;
    private SettingsController controller;

    /**
     *
     * @param settings
     */
    public SettingsView(Settings settings, SettingsController controller) {
        this.settings = settings;
        this.controller = controller;

        contentPane = new GridPane();
        contentPane.getStyleClass().add("contentPane");
        contentPane.setVgap(10);

        root = new BorderPane(contentPane);

        this.createCheckBoxes();
        this.createButtons();

        root.getStyleClass().add("root");
        root.setPrefSize(300, 500);
        root.getStylesheets().add("stylesheets/settingsViewStyles.css");
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(onExitEvent -> controller.handleOnCloseRequest());
    }

    /**
     *
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
     *
     */
    private void createButtons() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER_RIGHT);
        footer.setSpacing(10);
        root.setBottom(footer);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> controller.handleSubmitButtonClick());
        Button applyButton = new Button("Apply");
        applyButton.setOnAction(event -> controller.handleApplyButtonClick());
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> controller.handleCancelButtonClick());

        footer.getChildren().addAll(cancelButton, applyButton, submitButton);
    }

    /**
     * Closes the settings window.
     */
    public void close() {
        this.stage.close();
    }

    /**
     *
     */
    public void show() {
        stage.show();
    }

    public CheckBox getTorusCheckBox() {
        return torusCheckBox;
    }

    public CheckBox getAntRenderingCheckBox() {
        return antRenderingCheckBox;
    }
}
