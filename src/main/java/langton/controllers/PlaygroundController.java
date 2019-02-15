package langton.controllers;

import langton.data.Algorithm;
import langton.data.Ant;
import langton.helpers.Direction;
import langton.helpers.Point;
import langton.views.Playground;

/**
 * @author Gerome Wiss
 * @version 15_02_2019
 *
 * This class controls all changes that happen on the corresponding playground object.
 * It handles inputs from the user and changes the view according to the changes in the data.
 */
public class PlaygroundController {
    private Playground playground;
    private Algorithm algorithm;

    /**
     * This constructor creates a Map and initialises the values needed for the playground.
     * @param width The initial width of the window.
     * @param height The initial height of the window.
     */
    public PlaygroundController(double width, double height, Algorithm algorithm) {
        this.algorithm = algorithm;
        this.playground = new Playground(width, height);
        this.playground.drawGrid(algorithm.getMap().getRowsCount(), algorithm.getMap().getColumnsCount());
    }

    /**
     * Updates the grid on the playground.
     */
    public void updateGrid() {
        playground.drawGrid(algorithm.getMap().getRowsCount(), algorithm.getMap().getColumnsCount());
        playground.drawAnt(new Ant(new Point(1, 1), Direction.UP));
        playground.drawAnt(new Ant(new Point(1, 2), Direction.RIGHT));
        playground.drawAnt(new Ant(new Point(1, 3), Direction.DOWN));
        playground.drawAnt(new Ant(new Point(1, 4), Direction.LEFT));
    }

    /**
     * In- or decreases the size of the canvas on the playground.
     * @param width The new width.
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
}
