package langton.controllers;

import com.sun.istack.internal.NotNull;
import langton.data.Map;
import langton.views.Playground;

/**
 * @author Gerome Wiss
 * @version 14_02_2019
 *
 * This class controls all changes that happen on the corresponding playground object.
 * It handles inputs from the user and changes the view according to the changes in the data.
 */
public class PlaygroundController {
    private Playground playground;
    private Map map;

    public PlaygroundController(double width, double height, int rows, int columns) {
        this.map = new Map(rows, columns);
        this.playground = new Playground(width, height);
        this.playground.drawGrid(map.getRowsCount(), map.getColumnsCount());
    }

    public PlaygroundController(double width, double height, Map map) {
        this.map = map;
        this.playground = new Playground(width, height);
        this.playground.drawGrid(map.getRowsCount(), map.getColumnsCount());
    }

    public void viewDidLoad(double width, double height) {
        playground.updateCanvasSize(width, height);
        playground.drawGrid(map.getRowsCount(), map.getColumnsCount());
    }

    public Playground getPlayground() {
        return playground;
    }
}
