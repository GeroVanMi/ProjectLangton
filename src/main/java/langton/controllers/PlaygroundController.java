package langton.controllers;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import langton.data.Algorithm;
import langton.data.Ant;
import langton.helpers.TickListener;
import langton.views.Playground;

/**
 * @author Gerome Wiss
 * @version 24_04_2019
 * This class controls all changes that happen on the corresponding playground object.
 * It handles inputs from the user and changes the view according to the changes in the data.
 */
public class PlaygroundController extends ViewController implements TickListener {
    private Playground playground;
    private Algorithm algorithm;
    private SettingsController settingsController;

    /**
     * This constructor creates a Map and initialises the values needed for the playground.
     *
     * @param width  The initial width of the window.
     * @param height The initial height of the window.
     */
    public PlaygroundController(double width, double height, Algorithm algorithm) {
        this.playground = new Playground(width, height, this);
        super.createView(playground);
        this.algorithm = algorithm;
        algorithm.addTickListener(this);
        this.updateFullPlayground();
    }

    /**
     * Updates the grid on the playground.
     */
    public void updateFullPlayground() {
        playground.clearCanvas();
        playground.drawGrid(algorithm.getMap().getRowsCount(), algorithm.getMap().getColumnsCount(), algorithm.getMap());
        for (Ant ant : algorithm.getAnts()) {
            playground.drawAnt(ant);
        }
    }

    /**
     *
     */
    private void updatePlayground() {
        for (Ant ant : algorithm.getAnts()) {
            int lastX = ant.getLastPosition().getX(), lastY = ant.getLastPosition().getY();
            int currentX = ant.getPosition().getX(), currentY = ant.getPosition().getY();

            playground.clearField(lastX, lastY);
            playground.drawField(lastX, lastY, algorithm.getMap().getFields()[lastX][lastY]);

            playground.clearField(currentX, currentY);
            playground.drawField(currentX, currentY, algorithm.getMap().getFields()[currentX][currentY]);
            if (algorithm.getSettings().renderAnts()) {
                playground.drawAnt(ant);
            }
        }
    }

    /**
     *
     */
    public void handleCanvasClick(double x, double y) {
        SettingsAntController settingsAntController = new SettingsAntController(algorithm, (int) x, (int) y);
    }

    public void handlePauseButtonClick() {
        algorithm.pause();
    }

    public void handlePlayButtonClick() {
        algorithm.play();
    }

    /**
     *
     */
    public void handleButtonSettingsClick(ActionEvent event) {
        if(settingsController == null) {
            settingsController = new SettingsController(algorithm.getSettings());
        }
        if(!settingsController.isShowing()) {
            algorithm.pause();
            settingsController.showAndWait();
            algorithm.play();
        }
    }

    /**
     * In- or decreases the size of the canvas on the playground.
     *
     * @param width  The new width.
     * @param height The new height.
     */
    public void updateCanvasSize(double width, double height) {
        playground.updateCanvasSize(width, height);
    }

    /**
     * @return Returns the playground.
     */
    public Playground getPlayground() {
        return playground;
    }

    /**
     *
     * @return
     */
    public Algorithm getAlgorithm() {
        return algorithm;
    }

    /**
     * This method is called whenever the data in the algorithm changed in a significant way.
     *
     * @see TickListener
     */
    @Override
    public void update() {
        this.updatePlayground();
    }
}
