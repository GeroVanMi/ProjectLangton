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

    public void drawGrid(int rows, int columns) {
        double width = canvas.getWidth() / columns;
        double height = canvas.getHeight() / rows;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                graphicsContext.fillRect(i * width, j * height, width, height);
                graphicsContext.strokeRect(i * width, j * height, width, height);
            }
        }
    }
}
