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
     * @param firstViewController
     */
    public ScreensController(Stage window, ViewController firstViewController) {
        this.window = window;
        this.window.setMaximized(true);
        this.window.setOnCloseRequest(e -> System.exit(0));

        this.viewControllers = new ArrayList<>();
        this.loadScreen(firstViewController);
    }

    /**
     *
     * @param nextViewController
     */
    public void loadScreen(ViewController nextViewController) {
        // TODO: Check if nextViewController already is in the list.
        window.setScene(nextViewController.getView().getScene());
        viewControllers.add(nextViewController);
    }
}
