package langton;

import javafx.application.Application;
import javafx.stage.Stage;
import langton.controllers.PlaygroundController;


/**
 * @author Gerome Wiss
 * @version 14_02_2019
 *
 * This class is called when a user starts the application. It acts as an initiator for many values.
 */
public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setMaximized(true);
        PlaygroundController playgroundController =
                new PlaygroundController(primaryStage.getWidth(), primaryStage.getHeight(), 10, 10);
        primaryStage.setScene(playgroundController.getPlayground().getScene());
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });
        primaryStage.show();
        playgroundController.viewDidLoad(primaryStage.getWidth(), primaryStage.getHeight(), 10, 10);
    }
}