package langton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        VBox pane = new VBox();
        // Insert content into pane
        Button button = new Button("Hello World");
        TextField textField = new TextField("Test");
        pane.getChildren().add(button);
        pane.getChildren().add(textField);
        // ---------

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
