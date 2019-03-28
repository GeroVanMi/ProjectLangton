package langton.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import langton.data.Settings;

/**
 * @author Gerome Wiss
 * @version 26_03_2019
 *
 * TODO: Update JavaDoc
 */
public class SettingsView {
    private Stage stage;
    private BorderPane root;
    private GridPane contentPane;
    private CheckBox torusCheckBox, antRenderingCheckBox;
    private Settings settings;

    /**
     *
     * @param settings
     */
    public SettingsView(Settings settings) {
        this.settings = settings;

        contentPane = new GridPane();
        contentPane.getStyleClass().add("contentPane");
        contentPane.setVgap(10);

        root = new BorderPane(contentPane);

        this.createCheckBoxes();
        this.createButtons();

        root.getStyleClass().add("root");
        root.setPrefSize(300, 500);
        root.getStylesheets().add("stylesheets/settingsViewStyles.css");
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(onExitEvent -> {
            // TODO: Check for unsaved changes. Skip this part if there are none.
            this.createConfirmationBox();
        });
    }

    /**
     *
     */
    private void createCheckBoxes() {
        // Checkbox to ask the user, whether he wants to use a torus as the map.
        torusCheckBox = new CheckBox();
        if(settings.useTorus()) {
            torusCheckBox.setSelected(true);
        }
        Label torusLabel = new Label("Use Torus");
        contentPane.addRow(0, torusCheckBox, torusLabel);

        // Checkbox for drawing ant or not
        antRenderingCheckBox = new CheckBox();
        if(settings.renderAnts()) {
            antRenderingCheckBox.setSelected(true);
        }
        Label antRenderingLabel = new Label("Render ants");
        contentPane.addRow(1, antRenderingCheckBox, antRenderingLabel);
    }

    /**
     *
     */
    private void createButtons() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER_RIGHT);
        footer.setSpacing(10);
        root.setBottom(footer);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            this.applyChanges();
            this.close();
        });
        Button applyButton = new Button("Apply");
        applyButton.setOnAction(event -> {
            this.applyChanges();
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> {
            this.close();
        });

        footer.getChildren().addAll(cancelButton, submitButton, applyButton);
    }

    private void createConfirmationBox() {
        Stage confirmationStage = new Stage();
        confirmationStage.initStyle(StageStyle.UNDECORATED);

        BorderPane confirmationRoot = new BorderPane();
        confirmationRoot.getStylesheets().add("stylesheets/settingsViewStyles.css");
        confirmationRoot.getStyleClass().add("root");

        String confirmationQuestion = "You have unsaved changes, do you want to save them?";
        Label confirmationQuestionLabel = new Label(confirmationQuestion);
        confirmationRoot.setCenter(confirmationQuestionLabel);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(onClickEvent -> {
            applyChanges();
            confirmationStage.close();
        });
        Button discardButton = new Button("Discard");
        discardButton.setOnAction(onClickEvent -> {
            confirmationStage.close();
        });
        HBox confirmButtonsHBox = new HBox(saveButton, discardButton);
        confirmButtonsHBox.setSpacing(10);
        confirmationRoot.setBottom(confirmButtonsHBox);

        Scene confirmationScene = new Scene(confirmationRoot);
        confirmationStage.setScene(confirmationScene);

        confirmationStage.showAndWait();
    }

    /**
     * Applies the changes made in the settings menu.
     */
    private void applyChanges() {
        this.settings.setRenderAnts(antRenderingCheckBox.isSelected());
        this.settings.setUseTorus(torusCheckBox.isSelected());
    }

    /**
     * Closes the settings window.
     */
    private void close() {
        this.stage.close();
    }

    /**
     *
     */
    public void show() {
        stage.show();
    }
}
