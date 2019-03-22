package langton;

import javafx.application.Application;
import javafx.stage.Stage;
import langton.controllers.PlaygroundController;
import langton.controllers.ScreensController;
import langton.data.Algorithm;
import langton.helpers.ResizeListener;
import java.util.ArrayList;


/**
 * @author Gerome Wiss
 * @version 16_02_2019
 *
 * This class is called when a user starts the application. It acts as an initiator for many values.
 */
public class Main extends Application {

    private ArrayList<ResizeListener> resizeListeners;

    public void start(Stage primaryStage) /*throws Exception*/ {
        // Create Data Objects
        Algorithm algorithm = new Algorithm(100, 100);
        // Add some example ants.
        algorithm.addAnt(25, 25, 0);
        algorithm.addAnt(75, 25, 0);
        algorithm.addAnt(25, 75, 0);
        algorithm.addAnt(75, 75, 0);

        PlaygroundController playgroundController =
                new PlaygroundController(primaryStage.getWidth(), primaryStage.getHeight(), algorithm);

        // Settings for the window / primary stage
        ScreensController screensController = new ScreensController(primaryStage, playgroundController);

        primaryStage.show();

        // Is executed after the view has been loaded. Necessary to access certain attributes like height.
        playgroundController.updateCanvasSize(primaryStage.getWidth(), primaryStage.getHeight());
        playgroundController.updateFullPlayground();

        // Start the algorithm.
        algorithm.play();

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            for(ResizeListener resizeListener : resizeListeners) {
                resizeListener.update();
            }
        });
    }
}