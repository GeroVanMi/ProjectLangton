package langton.views;

import javafx.scene.Scene;
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

    public SettingsView(Settings settings) {
        root = new VBox();
        root.getStylesheets().add("stylesheets/settingsViewStyles.css");

        // Do setup here -->
        GridPane contentPane = new GridPane();
        root.getChildren().add(contentPane);

        // Checkbox to ask the user, whether he wants to use a torus as the map.
        CheckBox torusCheckBox = new CheckBox();
        if(settings.useTorus()) {
            torusCheckBox.setSelected(true);
        }
        Label torusLabel = new Label("Use Torus");
        contentPane.addRow(0, torusCheckBox, torusLabel);

        // Checkbox for drawing ant or not
        CheckBox antRenderingCheckBox = new CheckBox();
        if(settings.renderAnts()) {
            antRenderingCheckBox.setSelected(true);
        }
        Label antRenderingLabel = new Label("Render ants");
        contentPane.addRow(1, antRenderingCheckBox, antRenderingLabel);
        // <--

        Scene scene = new Scene(root);

        stage = new Stage();
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
