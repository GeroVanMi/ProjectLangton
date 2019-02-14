package langton;

import javafx.application.Application;
import javafx.stage.Stage;
import langton.controllers.PlaygroundController;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        PlaygroundController playgroundController = new PlaygroundController();
        primaryStage.setScene(playgroundController.getPlayground().getScene());
        primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });
        primaryStage.show();
    }
}
