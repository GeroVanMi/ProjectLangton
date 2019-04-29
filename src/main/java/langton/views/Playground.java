package langton.views;

import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import langton.controllers.PlaygroundController;
import langton.data.Ant;
import langton.data.Field;
import langton.data.Map;
import langton.helpers.Point;

/**
 * @author Gerome Wiss
 * @version 28_03_2019
 * <p>
 * This class holds all the information related to the visual representation of the fields and ants on it.
 * It displays the playground in a border pane.
 */
public class Playground extends View {
    private HBox header;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private double fieldWidth, fieldHeight;
    private PlaygroundController controller;

    /**
     * This constructor instantiates a border pane and adds two style sheets to it.
     * Additionally it instantiates the canvas with the given width and height. and a title label.
     * It then derives the graphicsContext from the newly created canvas and stores the border pane in the scene.
     *
     * @param width      The initial width of the canvas.
     * @param height     The initial height of the canvas.
     * @param controller The viewcontroller that controls this view.
     */
    public Playground(double width, double height, PlaygroundController controller) {
        super();
        fieldHeight = 0;
        fieldWidth = 0;
        this.controller = controller;

        BorderPane pane = new BorderPane();
        pane.getStylesheets().add("/stylesheets/defaultStyles.css");
        pane.getStylesheets().add("/stylesheets/playgroundStyles.css");

        this.createHeader();
        pane.setTop(header);

        canvas = new Canvas(width, height - header.getHeight());
        graphicsContext = canvas.getGraphicsContext2D();
        pane.setCenter(canvas);

        super.addNodeToRoot(pane);

        // Add an Ant on the click of a user.
        canvas.setOnMouseClicked(event -> controller.handleCanvasClick(event.getX() / fieldWidth, event.getY() / fieldHeight));
    }

    /**
     * This method draws a rectangular grid onto the canvas.
     *
     * @param rows    The amount of rows that are to be drawn.
     * @param columns The amount of columns that are to be drawn.
     */
    public void drawGrid(int rows, int columns, Map map) {
        // The width of a single rectangle.
        fieldWidth = canvas.getWidth() / columns;
        // The height of a single rectangle.
        fieldHeight = canvas.getHeight() / rows;

        for (int x = 0; x < map.getFields().length; x++) {
            for (int y = 0; y < map.getFields()[x].length; y++) {
                // Draw the field background.
                graphicsContext.setFill(map.getFields()[x][y].getColor());
                graphicsContext.fillRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight);
                // Draw the borders
                drawBorder(x, y);
            }
        }
    }

    /**
     *
     */
    private void createHeader() {
        // Create content for the top box.
        Label titleLabel = new Label("Langton's Ant");
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        titleLabel.getStyleClass().add("titleLabel");

        Button controlButton = new Button();
        controlButton.setOnAction(event -> {
            if (controlButton.getStyleClass().get(1).equals("pauseButton")) {
                controlButton.getStyleClass().remove(1);
                controlButton.getStyleClass().add("playButton");
                controller.handlePauseButtonClick();
            } else {
                controlButton.getStyleClass().remove(1);
                controlButton.getStyleClass().add("pauseButton");
                controller.handlePlayButtonClick();
            }
        });
        controlButton.getStyleClass().add("pauseButton");


        Button settingsButton = new Button();
        settingsButton.setOnAction(controller::handleButtonSettingsClick);
        settingsButton.getStyleClass().add("settingsButton");
        settingsButton.setPrefSize(40, 40);

        // Create the top box.
        header = new HBox();
        header.getChildren().addAll(titleLabel, controlButton, settingsButton);
        header.getStyleClass().add("header");
        header.setAlignment(Pos.CENTER);
        header.setSpacing(15);
    }

    /**
     * Draws a black border around a field.
     *
     * @param x The x coordinate of the field.
     * @param y The y coordinate of the field.
     */
    private void drawBorder(int x, int y) {
        graphicsContext.setStroke(new Color(0.1, 0.1, 0.1, 1));
        graphicsContext.strokeRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight);
    }

    /**
     * This method draws an ant onto the field.
     *
     * @param ant The ant that is to be drawn.
     */
    public void drawAnt(Ant ant) {
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
        iv.setRotate(ant.getDirection());
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
     * Clears a field.
     *
     * @param x The x coordinate of the field.
     * @param y The y coordinate of the field.
     */
    public void clearField(int x, int y) {
        graphicsContext.clearRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight);
    }

    /**
     * Draws a field (including the border) onto the canvas.
     *
     * @param x     The x coordinate of the field.
     * @param y     The y coordinate of the field.
     * @param field The field object (used for the color).
     */
    public void drawField(int x, int y, Field field) {
        graphicsContext.setFill(field.getColor());
        graphicsContext.fillRect(x * fieldWidth, y * fieldHeight, fieldWidth, fieldHeight);
        drawBorder(x, y);
    }

    /**
     * Updates the canvas width and height.
     *
     * @param width  The new width.
     * @param height The new height.
     */
    public void updateCanvasSize(double width, double height) {
        canvas.setWidth(width);
        canvas.setHeight(height - (header.getHeight() + header.getPadding().getBottom() + header.getPadding().getTop() + 2));
    }
}
