package langton.views.settings;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import langton.controllers.SettingsController;

public class ConfirmationBox {

    private Stage stage;
    private SettingsController controller;

    public ConfirmationBox(SettingsController controller) {
        stage = new Stage();
        this.controller = controller;

        // --------------------------------------------------------------------------
        // Credit to Shardendu from StackOverflow
        // https://stackoverflow.com/questions/8341305/how-to-remove-javafx-stage-buttons-minimize-maximize-close
        // --------------------------------------------------------------------------
        stage.initStyle(StageStyle.UNDECORATED);

        BorderPane confirmationRoot = new BorderPane();
        confirmationRoot.getStylesheets().add("stylesheets/settingsViewStyles.css");
        confirmationRoot.getStyleClass().add("root");

        String confirmationQuestion = "You have unsaved changes, do you want to save them?";
        Label confirmationQuestionLabel = new Label(confirmationQuestion);
        confirmationRoot.setCenter(confirmationQuestionLabel);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(onClickEvent -> controller.handleBoxSaveButtonClick());

        Button discardButton = new Button("Discard");
        discardButton.setOnAction(onClickEvent -> controller.handleDiscardButtonClick());

        HBox confirmButtonsHBox = new HBox(saveButton, discardButton);
        confirmButtonsHBox.setSpacing(10);
        confirmationRoot.setBottom(confirmButtonsHBox);

        Scene confirmationScene = new Scene(confirmationRoot);
        stage.setScene(confirmationScene);
    }

    public void showAndWait() {
        stage.showAndWait();
    }

    public void close() {
        stage.close();
    }
}
