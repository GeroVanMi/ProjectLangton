package langton.controllers;

import javafx.stage.Stage;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
 */
public class ScreensController {
    private Stage window;
    private ViewController currentViewController;

    /**
     * Instantiates the window and sets maximises it.
     * Then loads the given view into said window.
     * @param window The window from the application class.
     * @param firstViewController The first view that is to be loaded.
     */
    public ScreensController(Stage window, ViewController firstViewController) {
        this.window = window;
        this.window.setMaximized(true);
        this.window.setOnCloseRequest(e -> System.exit(0));

        this.loadScreen(firstViewController);
    }

    /**
     * Loads a new view controller and puts the corresponding scene into the view.
     * @param nextViewController The controller that is to be loaded.
     */
    public void loadScreen(ViewController nextViewController) {
        // TODO: Check if nextViewController already is in the list.
        window.setScene(nextViewController.getView().getScene());
    }
}
