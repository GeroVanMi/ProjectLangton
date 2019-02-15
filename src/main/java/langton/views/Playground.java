package langton.views;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import langton.data.Ant;
import langton.helpers.Point;

/**
 * @author Gerome Wiss
 * @version 15_02_2019
 *
 * This class holds all the information related to the visual representation of the fields and ants on it.
 * It displays the playground in a border pane.
 */
public class Playground {
    private Scene scene;
    private BorderPane pane;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private double fieldWidth, fieldHeight;

    /**
     * This constructor initialises a canvas with the given width and height.
     * It then derives the graphicsContext from the newly created canvas.
     * Additionally it instantiates the border pane and a title label.
     * All nodes get stored in the scene.
     * @param width The initial width of the canvas.
     * @param height The initial height of the canvas.
     */
    public Playground(double width, double height) {
        fieldHeight = 0;
        fieldWidth = 0;

        canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();
        pane = new BorderPane(canvas);

        Label titleLabel = new Label("Langton's Ant");
        titleLabel.setTextAlignment(TextAlignment.CENTER);

        pane.setTop(titleLabel);

        scene = new Scene(pane);
    }

    /**
     * This method draws a rectangular grid onto the canvas.
     * @param rows The amount of rows that are to be drawn.
     * @param columns The amount of columns that are to be drawn.
     */
    public void drawGrid(int rows, int columns) {
        // The width of a single rectangle.
        fieldWidth = canvas.getWidth() / columns;
        // The height of a single rectangle.
        fieldHeight = canvas.getHeight() / rows;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                graphicsContext.setFill(new Color(0.2, 0.2, 0.2, 1));
                graphicsContext.fillRect(i * fieldWidth, j * fieldHeight, fieldWidth, fieldHeight);
                graphicsContext.setStroke(new Color(0.1, 0.1, 0.1, 1));
                graphicsContext.strokeRect(i * fieldWidth, j * fieldHeight, fieldWidth, fieldHeight);
            }
        }
    }

    /**
     * This method draws an ant onto the field.
     * @param ant The ant that is to be drawn.
     */
    public void drawAnt(Ant ant) {
        Point pos = ant.getPosition();
        String antIconUrl = "/images/ant_icon.jpg";

        switch (ant.getDirection()) {
            case UP:
                antIconUrl = "/images/ant_icon.jpg";
                break;
            case RIGHT:
                antIconUrl = "/images/ant_icon.jpg";
                break;
            case DOWN:
                antIconUrl = "/images/ant_icon.jpg";
                break;
            case LEFT:
                antIconUrl = "/images/ant_icon.jpg";
                break;
        }
        Image antIcon = new Image(antIconUrl);
        graphicsContext.drawImage(antIcon, pos.getX() * fieldWidth + 5, pos.getY() * fieldHeight + 5, fieldWidth - 10, fieldHeight - 10);
    }

    /**
     * This method clears the entire canvas.
     */
    public void clearCanvas() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    /**
     * Updates the canvas width and height.
     * @param width The new width.
     * @param height The new height.
     */
    public void updateCanvasSize(double width, double height) {
        canvas.setWidth(width);
        canvas.setHeight(height);
    }

    /**
     * @return Returns the entire scene of the view.
     */
    public Scene getScene() {
        return scene;
    }
}
