package langton.views;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public abstract class View {
    private Scene scene;
    private AnchorPane root;

    public View() {
        root = new AnchorPane();
        scene = new Scene(root);
    }

    public void addNodeToRoot(Node node) {
        root.getChildren().add(node);
    }

    public Scene getScene() {
        return scene;
    }
}
