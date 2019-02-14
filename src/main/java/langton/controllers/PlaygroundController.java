package langton.controllers;

import langton.views.Playground;

/**
 * @author Gerome Wiss
 * @version 14_02_2019
 *
 * This class controls all changes that happen on the corresponding playground object.
 */
public class PlaygroundController {
    private Playground playground;

    public PlaygroundController(double width, double height, int rows, int columns) {
        this.playground = new Playground(width, height);
        this.playground.drawGrid(rows, columns);
    }

    public void viewDidLoad(double width, double height, int rows, int columns) {
        playground.updateCanvasSize(width, height);
        playground.drawGrid(rows, columns);
    }

    public Playground getPlayground() {
        return playground;
    }
}
