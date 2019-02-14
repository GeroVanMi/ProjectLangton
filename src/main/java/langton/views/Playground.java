package langton.views;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

public class Playground {
    private Scene scene;
    private BorderPane pane;
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    public Playground() {
        canvas = new Canvas(1000, 900);
        graphicsContext = canvas.getGraphicsContext2D();
        pane = new BorderPane(canvas);

        Label titleLabel = new Label("Langton's Ant");
        pane.setTop(titleLabel);

        scene = new Scene(pane);
    }
}
