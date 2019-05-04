package langton.views.antSettings;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import langton.controllers.SettingsAntController;

/**
 * @author Natalie Breu
 * @version 05_04_2019
 */

public class SettingBox
{
    private Stage stage;
    private SettingsAntController controller;
    private String text;

    public SettingBox(SettingsAntController controller) {
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

        String confirmationQuestion = "Bitte geben Sie nur Zahlen zwischen 0 und 255 ein.";
        Label confirmationQuestionLabel = new Label(confirmationQuestion);
        confirmationRoot.setCenter(confirmationQuestionLabel);

        Button discardButton = new Button("Discard");
        discardButton.setOnAction(onClickEvent -> controller.handleDiscardButtonClick());

        HBox hBox = new HBox(discardButton);
        hBox.setSpacing(10);
        confirmationRoot.setBottom(hBox);

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
