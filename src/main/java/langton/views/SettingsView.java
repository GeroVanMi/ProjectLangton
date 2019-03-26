package langton.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import langton.data.Settings;

/**
 * @author Gerome Wiss
 * @version 26_03_2019
 *
 * TODO: Update JavaDoc
 */
public class SettingsView {
    private Stage stage;
    private GridPane contentPane;
    private CheckBox torusCheckBox, antRenderingCheckBox;
    private Settings settings;

    /**
     *
     * @param settings
     */
    public SettingsView(Settings settings) {
        this.settings = settings;

        contentPane = new GridPane();
        contentPane.getStyleClass().add("contentPane");

        this.createCheckBoxes();
        this.createButtons();

        VBox root = new VBox(contentPane);
        root.getStyleClass().add("root");
        root.setPrefSize(300, 500);
        root.getStylesheets().add("stylesheets/settingsViewStyles.css");
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
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
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            this.applyChanges();
            this.close();
        });
        Button applyButton = new Button("Apply");
        applyButton.setOnAction(event -> {
            this.applyChanges();
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> {
            this.close();
        });
        contentPane.addRow(2, cancelButton, submitButton, applyButton);
    }

    /**
     * Applies the changes made in the settings menu.
     */
    private void applyChanges() {
        this.settings.setRenderAnts(antRenderingCheckBox.isSelected());
        this.settings.setUseTorus(torusCheckBox.isSelected());
    }

    /**
     * Closes the settings window.
     */
    private void close() {
        this.stage.close();
    }

    /**
     *
     */
    public void show() {
        stage.show();
    }
}
