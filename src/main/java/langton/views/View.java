package langton.views;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
 *
 * This abstract class holds the basic information that is needed to fill a window with content.
 */
public abstract class View {
    private Scene scene;
    private AnchorPane root;

    /**
     * Instantiates the scene and root.
     */
    public View() {
        root = new AnchorPane();
        scene = new Scene(root);
    }

    /**
     * Adds a single child node to the root node.
     * This is usually a top level node (i.e. a border pane) that holds additional subnodes (labels, textfields, etc.)
     * @param node
     */
    public void addNodeToRoot(Node node) {
        root.getChildren().add(node);
    }

    /**
     * @return Returns the scene of the view.
     */
    public Scene getScene() {
        return scene;
    }
}
