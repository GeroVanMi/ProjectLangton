package langton.views;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Gerome Wiss
 * @version 26_03_2019
 */
public class SettingsView {
    private Stage stage;
    private VBox root;

    public SettingsView() {
        root = new VBox();
        root.getStylesheets().add("stylesheets/settingsViewStyles.css");

        // Do setup here -->

        // <--

        Scene scene = new Scene(root);

        stage = new Stage();
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }
}
