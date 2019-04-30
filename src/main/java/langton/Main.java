package langton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import langton.controllers.PlaygroundController;
import langton.controllers.ScreensController;
import langton.data.Algorithm;
import langton.helpers.ResizeListener;
import java.util.ArrayList;
import javafx.scene.control.Label;


/**
 * @author Gerome Wiss
 * @version 30_02_2019
 *
 * This class is called when a user starts the application. It acts as an initiator for many values.
 */
public class Main extends Application {

    private ArrayList<ResizeListener> resizeListeners;

    public void start(Stage primaryStage) {
        try {

            resizeListeners = new ArrayList<>();
            // Create Data Objects
            Algorithm algorithm = new Algorithm(150, 150, 5, true, true);

            PlaygroundController playgroundController =
                    new PlaygroundController(primaryStage.getWidth(), primaryStage.getHeight(), algorithm);

        // SettingsAntView for the window / primary stage
        primaryStage.setScene(playgroundController.getPlayground().getScene());
        primaryStage.setMaximized(true);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        // SettingsView for the window / primary stage
        ScreensController screensController = new ScreensController(primaryStage, playgroundController);

            primaryStage.show();

            // Is executed after the view has been loaded. Necessary to access certain attributes like height.
            playgroundController.updateCanvasSize(primaryStage.getWidth(), primaryStage.getHeight());
            playgroundController.updateFullPlayground();

            // Start the algorithm.
            algorithm.play();

            primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
                for (ResizeListener resizeListener : resizeListeners) {
                    resizeListener.update();
                }
            });
        } catch (Exception exception) {
            exception.printStackTrace();
            Label infoLabel = new Label("Something went wrong. Try restarting the program. If this error " +
                    "persists please contact the developer. (gerome.wiss@kbw.ch)");
            Label errorLabel = new Label(exception.getMessage());
            VBox contentBox = new VBox(infoLabel, errorLabel);

            ScrollPane errorRoot = new ScrollPane(contentBox);
            Scene errorScene = new Scene(errorRoot);
            Stage errorStage = new Stage();
            errorStage.setScene(errorScene);
            errorStage.showAndWait();
        }
    }
}