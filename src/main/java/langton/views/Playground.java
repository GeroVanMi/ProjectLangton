package langton.views;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

/**
 * @author Gerome Wiss
 * @version 15_02_2019
 *
 * This class holds all the information related to the visual representation of the fields and ants on it.
 * It displays the playground in a borderpane.
 */
public class Playground {
    private Scene scene;
    private BorderPane pane;
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    public Playground(double width, double height) {
        canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();
        pane = new BorderPane(canvas);

        Label titleLabel = new Label("Langton's Ant");
        titleLabel.setTextAlignment(TextAlignment.CENTER);

        pane.setTop(titleLabel);

        scene = new Scene(pane);
    }

    public void drawGrid(int rows, int columns) {
        double width = canvas.getWidth() / columns;
        double height = canvas.getHeight() / rows;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                graphicsContext.setFill(new Color(0.2, 0.2, 0.2, 1));
                graphicsContext.fillRect(i * width, j * height, width, height);
                graphicsContext.setStroke(new Color(0.1, 0.1, 0.1, 1));
                graphicsContext.strokeRect(i * width, j * height, width, height);
            }
        }
    }

    public void updateCanvasSize(double width, double height) {
        canvas.setWidth(width);
        canvas.setHeight(height);
    }

    public Scene getScene() {
        return scene;
    }
}
