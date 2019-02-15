package langton;

import javafx.application.Application;
import javafx.stage.Stage;
import langton.controllers.PlaygroundController;
import langton.data.Algorithm;


/**
 * @author Gerome Wiss
 * @version 15_02_2019
 *
 * This class is called when a user starts the application. It acts as an initiator for many values.
 */
public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        // Create Data Objects
        Algorithm algorithm = new Algorithm(25, 25);
        PlaygroundController playgroundController =
                new PlaygroundController(primaryStage.getWidth(), primaryStage.getHeight(), algorithm);
        // Settings for the window / primary stage
        primaryStage.setScene(playgroundController.getPlayground().getScene());
        primaryStage.setMaximized(true);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();

        // Is executed after the view has been loaded. Necessary to access certain attributes like height.
        playgroundController.updateCanvasSize(primaryStage.getWidth(), primaryStage.getHeight());
        playgroundController.updateGrid();
    }
}