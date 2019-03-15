package langton;

import javafx.application.Application;
import javafx.stage.Stage;
import langton.controllers.PlaygroundController;
import langton.controllers.ScreensController;
import langton.data.Algorithm;
import langton.helpers.Direction;


/**
 * @author Gerome Wiss
 * @version 16_02_2019
 *
 * This class is called when a user starts the application. It acts as an initiator for many values.
 */
public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        // Create Data Objects
        Algorithm algorithm = new Algorithm(500, 500);
        // Add some example ants.
        algorithm.addAnt(150, 140, Direction.DOWN);
        algorithm.addAnt(140, 160, Direction.RIGHT);
        algorithm.addAnt(160, 160, Direction.LEFT);
        algorithm.addAnt(150, 140, Direction.DOWN);

        /* Very interesting setup, ant catches another fleeing ant.
        Algorithm algorithm = new Algorithm(300, 300);
        algorithm.addAnt(150, 140, Direction.DOWN);
        algorithm.addAnt(140, 160, Direction.RIGHT);
        algorithm.addAnt(160, 160, Direction.LEFT);
        */

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
    }
}