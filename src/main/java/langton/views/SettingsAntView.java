package langton.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import langton.controllers.SettingsAntController;

/**
 * @author Natalie Breu
 * @version 29_03_2019
 * <p>
 * TODO: Update JavaDoc
 */

public class SettingsAntView {

    private Scene scene;
    private BorderPane pane;
    private double width, heigth;
    private Stage stage;
    private ComboBox comboBox;
    private Color red, blue, yellow;
    private TextField redTextField, greenTextField, blueTextField;
    private SettingsAntController controller;

    public SettingsAntView() {
        controller = new SettingsAntController();
        red = new Color(1, 0, 0, 1);
        blue = new Color(0, 0, 1, 1);
        yellow = new Color(0, 1, 0, 1);

        width = 400.0;
        heigth = 400.0;
        stage = new Stage();

        stage.setWidth(width);
        stage.setHeight(heigth);

        comboBox = new ComboBox();
        GridPane colorsGridPane = new GridPane();
        colorsGridPane.getStylesheets().add("/stylesheets/settingsAntStyles.css");


        redTextField = new TextField();
        greenTextField = new TextField();
        blueTextField = new TextField();

        Label titleLabel = new Label("SettingsAntView");
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

        Button buttonSaveSettingsField = new Button("Save");
        //Das zwüschet de {} isch Funktion, wo de Parameter (event) vorne mitgeh wird
        buttonSaveSettingsField.setOnAction(event -> {
            controller.handleSettingsAnt(event);
        });

        VBox root = new VBox(titleLabel);
        root.getStylesheets().add("/stylesheets/defaultStyles.css");
        root.getStyleClass().add("backgroundcolor");

        scene = new Scene(root);
        root.getChildren().add(colorsGridPane);

        // root.getChildren().add(comboBox);
        root.getChildren().add(buttonSaveSettingsField);
        stage.setScene(scene);
    }

    public void showAndWait() {
        stage.showAndWait();
    }

    public TextField getRedTextField() {
        return redTextField;
    }

    public TextField getGreenTextField() {
        return greenTextField;
    }

    public TextField getBlueTextField() {
        return blueTextField;
    }
}
