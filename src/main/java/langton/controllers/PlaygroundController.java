package langton.controllers;

import langton.views.Playground;

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
