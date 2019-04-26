package langton.views.antSettings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * @version 24_04_2019
 * <p>
 * TODO: Update JavaDoc
 */

public class SettingsAntView {

    private Stage stage;
    private TextField redTextField, greenTextField, blueTextField;
    private SettingsAntController controller;

    private VBox content;

    /**
     * Creates all Items of the Scene
     *
     * @param settingsAntController
     */
    public SettingsAntView(SettingsAntController settingsAntController) {
        this.controller = settingsAntController;

        this.content = new VBox();
        content.setPadding(new Insets(10));

        // Initialize the stage
        this.stage = new Stage();
        this.stage.setOnCloseRequest(onExitEvent -> settingsAntController.handleOnCloseRequest());

        this.createHeader();
        this.createColorTextFields();
        this.createCustomRulesetMenu();
        this.createFooter();

        VBox root = new VBox();

        // Stylesheets for the design
        root.getStylesheets().add("/stylesheets/defaultStyles.css");
        root.getStylesheets().add("/stylesheets/settingsAntStyles.css");
        root.getStyleClass().add("backgroundcolor");

        Scene scene = new Scene(root);

        root.getChildren().add(content);

        // Put VBox into the final Scene
        stage.setScene(scene);
    }

    /**
     *
     */
    private void createHeader() {
        // Title
        Label titleLabel = new Label("Ant-Settings");
        titleLabel.getStyleClass().add("titelStyle");

        HBox header = new HBox(titleLabel);
        header.setAlignment(Pos.CENTER);

        this.content.getChildren().add(header);
    }

    /**
     * Creates the TextFields for the RGB value that defines the color of the field whenever the ant enters it.
     */
    private void createColorTextFields() {
        // Red
        redTextField = new TextField();
        Label redLabel = new Label("Red");
        redLabel.getStyleClass().add("textStyle");

        // Green
        greenTextField = new TextField();
        Label greenLabel = new Label("Green");
        greenLabel.getStyleClass().add("textStyle");

        // Blue
        Label blueLabel = new Label("Blue");
        blueLabel.getStyleClass().add("textStyle");
        blueTextField = new TextField();

        //Subtitles
        Label settingsColorLabel = new Label("Color:");
        settingsColorLabel.getStyleClass().add("subtitleStyle");
        Label settingsDirectionLabel = new Label("Direction:");
        settingsDirectionLabel.getStyleClass().add("subtitleStyle");

        GridPane colorsGridPane = new GridPane();
        // Horizontal Gap (Left to Right)
        colorsGridPane.setHgap(25);
        // Vertical Gap (Up to Down)
        colorsGridPane.setVgap(10);

        // Add the Labels and TextFields to the GridPane
        colorsGridPane.addRow(0, settingsColorLabel);
        colorsGridPane.addRow(1, redLabel, redTextField);
        colorsGridPane.addRow(2, greenLabel, greenTextField);
        colorsGridPane.addRow(3, blueLabel, blueTextField);
        colorsGridPane.addRow(4);
        colorsGridPane.addRow(5, settingsDirectionLabel);

        // Add the colorsGridPane to the content node to display it.
        this.content.getChildren().add(colorsGridPane);
    }

    /**
     * Creates ComboBoxes where the user can select a custom ruleset for the new Ant.
     */
    private void createCustomRulesetMenu() {
        // Visualization of an empty Field
        Label emptyField = new Label();
        emptyField.getStyleClass().add("label-border");
        emptyField.setMinSize(35.0, 35.0);

        // Visualization of a filled Field
        Label filledField = new Label();
        filledField.getStyleClass().add("label-background");
        filledField.setMinSize(35.0, 35.0);

        ObservableList<String> moveOptions = FXCollections.observableArrayList(
                        "Stay Straight",
                        "Turn Left",
                        "Turn Right",
                        "Turn Around"
                );

        ComboBox comboBoxEmptyFields = new ComboBox(moveOptions);
        comboBoxEmptyFields.setPromptText("Empty Fields");

        ComboBox comboBoxFilledFields = new ComboBox(moveOptions);
        comboBoxFilledFields.setPromptText("Filled Fields");

        GridPane fieldsGridPane = new GridPane();
        // Add the nodes to the GridPane
        fieldsGridPane.addRow(0, emptyField, comboBoxEmptyFields);
        fieldsGridPane.addRow(1, filledField, comboBoxFilledFields);

        fieldsGridPane.setHgap(60);
        fieldsGridPane.setVgap(10);

        this.content.getChildren().add(fieldsGridPane);
    }

    /**
     * Creates the Button at the bottom of the
     */
    private void createFooter() {
        //Button to save the settings
        Button buttonSaveSettingsField = new Button("Save");
        //Das zwüschet de {} isch Funktion, wo de Parameter (event) vorne mitgeh wird
        buttonSaveSettingsField.setOnAction(event -> {
            controller.handleSettingsAnt(event);
        });

        HBox footer = new HBox(buttonSaveSettingsField);
        footer.setAlignment(Pos.CENTER_RIGHT);

        this.content.getChildren().add(footer);
    }

    /**
     * Show the View and block all other views from being interacted with.
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
