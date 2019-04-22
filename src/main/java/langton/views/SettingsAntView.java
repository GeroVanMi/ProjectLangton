package langton.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import langton.controllers.SettingsAntController;

/**
 * @author Natalie Breu
 * @version 22_04_2019
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

    /**
     * Creates all Items of the Scene
     *
     * @param settingsAntController
     */
    public SettingsAntView(SettingsAntController settingsAntController) {
        this.controller = settingsAntController;
        VBox content = new VBox();
        fieldsGridPane = new GridPane();
        stage = new Stage();

        comboBox = new ComboBox();
        GridPane colorsGridPane = new GridPane();

        redTextField = new TextField();
        greenTextField = new TextField();
        blueTextField = new TextField();

        //Titel
        Label titleLabel = new Label("Ant-Settings");
        titleLabel.getStyleClass().add("titelStyle");
        HBox header = new HBox(titleLabel);
        header.setAlignment(Pos.CENTER);

        // TextField for the amount of the RGB value of the ant
        Label redLabel = new Label("Red");
        redLabel.getStyleClass().add("textStyle");
        Label greenLabel = new Label("Green");
        greenLabel.getStyleClass().add("textStyle");
        Label blueLabel = new Label("Blue");
        blueLabel.getStyleClass().add("textStyle");

        //Subtitles
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

        // Combobox to choose the directions of the ant
        MenuItem menuItemUp = new MenuItem("Up");
        MenuItem menuItemDown = new MenuItem("Down");
        MenuItem menuItemLeft = new MenuItem("Left");
        MenuItem menuItemRight = new MenuItem("Right");

        //Squares to visualise the fields
        Label emptyField = new Label();
        emptyField.getStyleClass().add("label-border");
        emptyField.setMinSize(35.0, 35.0);
        Label filledField = new Label();
        filledField.getStyleClass().add("label-background");
        filledField.setMinSize(35.0, 35.0);

        //Put all Items into the Comboboxes
        ComboBox comboBoxEmptyFields = new ComboBox();
        comboBoxEmptyFields.getItems().addAll(menuItemUp.getText(), menuItemDown.getText(), menuItemLeft.getText(), menuItemRight.getText());
        comboBoxEmptyFields.setPromptText("Empty Fields");
        ComboBox comboBoxFilledFields = new ComboBox();
        comboBoxFilledFields.getItems().addAll("Up", "Down", "Left", "Right");
        comboBoxFilledFields.setPromptText("Filled Fields");

        //Button to save the settings
        Button buttonSaveSettingsField = new Button("Save");
        //Das zwüschet de {} isch Funktion, wo de Parameter (event) vorne mitgeh wird
        buttonSaveSettingsField.setOnAction(event -> {
            controller.handleSettingsAnt(event);
        });
        HBox footer = new HBox(buttonSaveSettingsField);
        footer.setAlignment(Pos.CENTER_RIGHT);

        // Stylesheets for the design
        VBox root = new VBox();
        root.getStylesheets().add("/stylesheets/defaultStyles.css");
        root.getStylesheets().add("/stylesheets/settingsAntStyles.css");
        root.getStyleClass().add("backgroundcolor");

        //Put the Items into the Gridpane
        fieldsGridPane.addRow(0, emptyField, comboBoxEmptyFields);
        fieldsGridPane.addRow(1, filledField, comboBoxFilledFields);

        fieldsGridPane.setHgap(60);
        fieldsGridPane.setVgap(10);

        //Put the Gridpane into the final  VBox
        scene = new Scene(root);
        content.getChildren().addAll(header, colorsGridPane, fieldsGridPane, footer);
        content.setPadding(new Insets(10));
        root.getChildren().addAll(content);

        // Put VBox into the final Scene
        stage.setScene(scene);
    }

    /**
     * Show Antsettings until User clicks SaveButton
     */
    public void showAndWait() {
        stage.showAndWait();
    }

    /**
     * Getter of RedTextField
     * @return
     */
    public TextField getRedTextField() {
        return redTextField;
    }

    /**
     * Getter of green TextField
     * @return
     */
    public TextField getGreenTextField() {
        return greenTextField;
    }

    /**
     * Getter of blue TextField
     * @return
     */
    public TextField getBlueTextField() {
        return blueTextField;
    }
}
