package langton.controllers;

import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
 */
public class ScreensController {
    private Stage window;
    private ViewController currentViewController;
    private ArrayList<ViewController> viewControllers;

    /**
     *
     * @param window
     * @param currentViewController
     */
    public ScreensController(Stage window, ViewController currentViewController) {
        this.window = window;
        this.currentViewController = currentViewController;
        viewControllers = new ArrayList<>();
    }

    public void loadScreen(ViewController nextViewController) {
        window.setScene(nextViewController.getView().getScene());
    }
}
