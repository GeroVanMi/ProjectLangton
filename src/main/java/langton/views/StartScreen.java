package langton.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StartScreen extends View {

    public StartScreen() {
        String title = "Langton's Ant";
        String info = "";

        Label titleLabel = new Label(title);
        Label infoLabel = new Label(info);

        Button startButton = new Button("Start");
    }
}
