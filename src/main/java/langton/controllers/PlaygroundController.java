package langton.controllers;

import langton.data.Map;
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
    private Map map;

    /**
     * This constructor creates a Map and initialises the values needed for the playground.
     * @param width The initial width of the window.
     * @param height The initial height of the window.
     * @param rows The initial amount of rows that are to be displayed.
     * @param columns The initial amount of columns that are to be displayed.
     */
    public PlaygroundController(double width, double height, int rows, int columns) {
        this.map = new Map(rows, columns);
        this.playground = new Playground(width, height);
        this.playground.drawGrid(map.getRowsCount(), map.getColumnsCount());
    }

    /**
     * Updates the grid on the playground.
     */
    public void updateGrid() {
        playground.drawGrid(map.getRowsCount(), map.getColumnsCount());
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
