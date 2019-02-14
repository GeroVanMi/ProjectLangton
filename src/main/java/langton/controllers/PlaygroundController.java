package langton.controllers;

import langton.views.Playground;

public class PlaygroundController {
    private Playground playground;

    public PlaygroundController(double width, double height) {
        this.playground = new Playground(width, height);
        this.playground.drawGrid(10, 10);
    }

    public Playground getPlayground() {
        return playground;
    }
}
