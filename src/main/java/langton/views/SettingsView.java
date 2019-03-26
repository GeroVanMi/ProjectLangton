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
 */
public class SettingsView {
    private Stage stage;
    private VBox root;
    private CheckBox torusCheckBox, antRenderingCheckBox;
    private Settings settings;

    /**
     *
     * @param settings
     */
    public SettingsView(Settings settings) {
        this.settings = settings;

        root = new VBox();
        root.getStylesheets().add("stylesheets/settingsViewStyles.css");

        // Do setup here -->
        GridPane contentPane = new GridPane();
        root.getChildren().add(contentPane);

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


        // Finish setup here -->

        Scene scene = new Scene(root);

        stage = new Stage();
        stage.setScene(scene);
    }

    private void applyChanges() {
        this.settings.setRenderAnts(antRenderingCheckBox.isSelected());
        this.settings.setUseTorus(torusCheckBox.isSelected());
    }

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
