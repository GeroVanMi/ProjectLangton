package langton.controllers;

import langton.views.Playground;

public class PlaygroundController {
    private Playground playground;

    public PlaygroundController() {
        this.playground = new Playground(1000, 1000);
    }

    public Playground getPlayground() {
        return playground;
    }
}
