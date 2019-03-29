package langton.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class SettingsAnt {
    private Scene scene;
    private BorderPane pane;
    private double width, heigth;
    private Stage stage;
    private ComboBox comboBox;
    private Color red;
    private Color blue;
    private Color yellow;

    public SettingsAnt() {
        red = new Color(1, 0,0,1);
        blue = new Color(0,0,1,1);
        yellow = new Color(0,1,0,1);

        width = 400.0;
        heigth = 400.0;
        stage = new Stage();

        stage.setWidth(width);
        stage.setHeight(heigth);

        stage.show();
        comboBox = new ComboBox();
        GridPane colorsGridPane = new GridPane();
        colorsGridPane.getStylesheets().add("/stylesheets/settingsAntStyles.css");


        TextField redTextField = new TextField();
        TextField greenTextField = new TextField();
        TextField blueTextField = new TextField();

        Label titleLabel = new Label("SettingsAnt");
        titleLabel.setTextAlignment(TextAlignment.CENTER);


        Label redLabel = new Label("Red");
        redLabel.getStyleClass().add("textStyle");
        Label greenLabel = new Label("Green");
        greenLabel.getStyleClass().add("textStyle");
        Label blueLabel = new Label("Blue");
        blueLabel.getStyleClass().add("textStyle");

        colorsGridPane.addRow(0, redLabel, redTextField);
        colorsGridPane.addRow(1, greenLabel, greenTextField);
        colorsGridPane.addRow(2, blueLabel, blueTextField);

        colorsGridPane.setHgap(25);
        colorsGridPane.setVgap(10);

        Button button2 = new Button("Accept");

        VBox root = new VBox(titleLabel);
        root.getStylesheets().add("/stylesheets/defaultStyles.css");
        root.getStyleClass().add("backgroundcolor");

        scene = new Scene(root);
        root.getChildren().add(colorsGridPane);

       // root.getChildren().add(comboBox);
        root.getChildren().add(button2);
        stage.setScene(scene);
    }

    public void addComponents() {

    }


}
