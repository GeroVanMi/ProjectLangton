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
 * @version 07_04_2019
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
    private GridPane fieldsGridPane;

    public SettingsAntView(SettingsAntController settingsAntController) {
        this.controller = settingsAntController;
        fieldsGridPane = new GridPane();
        width = 400.0;
        heigth = 400.0;
        stage = new Stage();

        stage.setWidth(width);
        stage.setHeight(heigth);

        comboBox = new ComboBox();
        GridPane colorsGridPane = new GridPane();

        redTextField = new TextField();
        greenTextField = new TextField();
        blueTextField = new TextField();

        Label titleLabel = new Label("Ant-Settings");
        titleLabel.getStyleClass().add("titelStyle");
        titleLabel.setTextAlignment(TextAlignment.CENTER);


        Label redLabel = new Label("Red");
        redLabel.getStyleClass().add("textStyle");
        Label greenLabel = new Label("Green");
        greenLabel.getStyleClass().add("textStyle");
        Label blueLabel = new Label("Blue");
        blueLabel.getStyleClass().add("textStyle");

        Label settingsColorLabel = new Label("Color:");
        settingsColorLabel.getStyleClass().add("subtitleStyle");

        Label settingsDirectionLabel = new Label("Direction:");
        settingsDirectionLabel.getStyleClass().add("subtitleStyle");

        colorsGridPane.addRow(0, settingsColorLabel);
        colorsGridPane.addRow(1, redLabel, redTextField);
        colorsGridPane.addRow(2, greenLabel, greenTextField);
        colorsGridPane.addRow(3, blueLabel, blueTextField);
        colorsGridPane.addRow(4);
        colorsGridPane.addRow(5, settingsDirectionLabel);

        //Abstand nebeneinander
        colorsGridPane.setHgap(25);
        //Abstand untereinander
        colorsGridPane.setVgap(10);

        Label emptyField = new Label();
        emptyField.getStyleClass().add("label-border");
        emptyField.setMinSize(35.0, 35.0);
        Label fullField = new Label();
        fullField.getStyleClass().add("label-background");
        fullField.setMinSize(35.0, 35.0);
        Label uselessLabel2 = new Label("");

        ComboBox comboBoxEmptyFields = new ComboBox();
        comboBoxEmptyFields.getItems().addAll("Up", "Down", "Left", "Right");

        ComboBox comboBoxFullFields = new ComboBox();
        comboBoxFullFields.getItems().addAll("Up", "Down", "Left", "Right");

        fieldsGridPane.addRow(0, emptyField, comboBoxEmptyFields);
        fieldsGridPane.addRow(1, fullField, comboBoxFullFields);

        fieldsGridPane.setHgap(60);
        fieldsGridPane.setVgap(10);

        Button buttonSaveSettingsField = new Button("Save");
        //Das zwüschet de {} isch Funktion, wo de Parameter (event) vorne mitgeh wird
        buttonSaveSettingsField.setOnAction(event -> {
            controller.handleSettingsAnt(event);
        });

        VBox root = new VBox(titleLabel);
        root.getStylesheets().add("/stylesheets/defaultStyles.css");
        root.getStylesheets().add("/stylesheets/settingsAntStyles.css");
        root.getStyleClass().add("backgroundcolor");

        scene = new Scene(root);
        root.getChildren().addAll(colorsGridPane, fieldsGridPane, buttonSaveSettingsField);

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
