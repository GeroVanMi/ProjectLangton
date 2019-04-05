package langton.views.settings;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import langton.controllers.SettingsController;

/**
 * @author Gerome Wiss
 * @version 05_04_2019
 */
public class ConfirmationBox {

    private Stage stage;
    private SettingsController controller;

    public ConfirmationBox(SettingsController controller) {
        this.controller = controller;
        stage = new Stage();

        // --------------------------------------------------------------------------
        // Credit to Shardendu from StackOverflow
        // https://stackoverflow.com/questions/8341305/how-to-remove-javafx-stage-buttons-minimize-maximize-close
        // --------------------------------------------------------------------------
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);

        BorderPane confirmationRoot = new BorderPane();
        confirmationRoot.getStylesheets().add("stylesheets/settingsViewStyles.css");
        confirmationRoot.getStyleClass().add("root");

        String confirmationQuestion = "You have unsaved changes, do you want to save them?";
        Label confirmationQuestionLabel = new Label(confirmationQuestion);
        confirmationRoot.setCenter(confirmationQuestionLabel);

        confirmationRoot.setBottom(this.createButtons());

        Scene confirmationScene = new Scene(confirmationRoot);
        stage.setScene(confirmationScene);
    }

    private HBox createButtons() {
        Button saveButton = new Button("Save");
        saveButton.setOnAction(controller::handleBoxSaveButtonClick);

        Button discardButton = new Button("Discard");
        discardButton.setOnAction(controller::handleBoxDiscardButtonClick);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(controller::handleBoxCancelButtonClick);

        HBox confirmButtonsHBox = new HBox(cancelButton, discardButton, saveButton);
        confirmButtonsHBox.setSpacing(10);
        confirmButtonsHBox.setAlignment(Pos.CENTER_RIGHT);

        return confirmButtonsHBox;
    }

    public void showAndWait() {
        if(!stage.isShowing()) {
            stage.showAndWait();
        }
    }

    public void close() {
        stage.close();
    }
}
