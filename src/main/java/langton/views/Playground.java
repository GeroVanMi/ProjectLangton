package langton.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import langton.data.Ant;
import langton.data.Map;
import langton.helpers.Point;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
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
     * This constructor instantiates a border pane and adds two style sheets to it.
     * Additionally it instantiates the canvas with the given width and height. and a title label.
     * It then derives the graphicsContext from the newly created canvas and stores the border pane in the scene.
     * @param width The initial width of the canvas.
     * @param height The initial height of the canvas.
     */
    public Playground(double width, double height) {
        fieldHeight = 0;
        fieldWidth = 0;

        canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();
        pane = new BorderPane(canvas);
        pane.getStylesheets().add("/stylesheets/defaultStyles.css");
        pane.getStylesheets().add("/stylesheets/playgroundStyles.css");

        Label titleLabel = new Label("Langton's Ant");
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        titleLabel.getStyleClass().add("titleLabel");
        HBox topBox = new HBox(titleLabel);
        topBox.getStyleClass().add("topBox");
        topBox.setAlignment(Pos.CENTER);

        pane.setTop(topBox);

        scene = new Scene(pane);
    }

    /**
     * This method draws a rectangular grid onto the canvas.
     * @param rows The amount of rows that are to be drawn.
     * @param columns The amount of columns that are to be drawn.
     */
    public void drawGrid(int rows, int columns, Map map) {
        // The width of a single rectangle.
        fieldWidth = canvas.getWidth() / columns;
        // The height of a single rectangle.
        fieldHeight = canvas.getHeight() / rows;

        for(int i = 0; i < map.getFields().length; i++) {
            for(int j = 0; j < map.getFields()[i].length; j++) {
                // Draw the field background.
                graphicsContext.setFill(map.getFields()[i][j].getColor());
                graphicsContext.fillRect(i * fieldWidth, j * fieldHeight, fieldWidth, fieldHeight);
                // Draw the borders
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
        double degrees;
        switch (ant.getDirection()) {
            case UP:
                degrees = 0;
                break;
            case RIGHT:
                degrees = 90;
                break;
            case DOWN:
                degrees = 180;
                break;
            case LEFT:
                degrees = 270;
                break;
            default:
                degrees = 0;
                break;
        }

        String antIconUrl = "/images/ant_icon.png";
        Image antIcon = new Image(antIconUrl);
        Point pos = ant.getPosition();

        // --------------------------------------------------------------------------
        // Credit to Jewelsea from StackOverflow
        // https://stackoverflow.com/questions/33613664/javafx-drawimage-rotated?rq=1
        // --------------------------------------------------------------------------
        // Create an Image view
        ImageView iv = new ImageView(antIcon);
        // Rotate the image in the Image view
        iv.setRotate(degrees);
        // Set parameters for the snapshot
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        // Take a snapshot of the image view and store it in an image.
        Image rotatedImage = iv.snapshot(params, null);
        // Draw the newly rotated image.
        graphicsContext.drawImage(rotatedImage, pos.getX() * fieldWidth, pos.getY() * fieldHeight, fieldWidth, fieldHeight);
        // -----------------------------------------------------------------------------------------------------------------------
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
