package langton.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import langton.data.Settings;
import langton.views.SettingsAntView;
import langton.views.settings.ConfirmationBox;
import langton.views.settings.SettingBox;

/**
 * @author Natalie Breu
 * @version 22_04_2019
 */
public class SettingsAntController {

    private SettingsAntView settingsAntView;
    private SettingBox settingBox;
    private Settings settings;

    /**
     * Created SettingsAntController
     */
    public SettingsAntController() {
        settingsAntView = new SettingsAntView(this);
        settingsAntView.showAndWait();
    }

    /**
     * Make sure the value of the TextFields isn't above 256 and below 0
     *
     * @param event
     */
    public void handleSettingsAnt(ActionEvent event) {
        if (settingsAntView.getRedTextField().getText().isEmpty() ||
                settingsAntView.getBlueTextField().getText().isEmpty() ||
                settingsAntView.getGreenTextField().getText().isEmpty()) {
            // Inform the user that one of the fields is empty
            displayConfirmationBox();
        } else {
            String textRed = settingsAntView.getRedTextField().getText();
            String textGreen = settingsAntView.getGreenTextField().getText();
            String textBlue = settingsAntView.getBlueTextField().getText();

            double doubleRed = Double.parseDouble(textRed);
            double doubleGreen = Double.parseDouble(textGreen);
            double doubleBlue = Double.parseDouble(textBlue);

            if (doubleRed > 255.0 || doubleGreen > 255.0 || doubleBlue > 255.0) {
                displayConfirmationBox();
            }
        }

    }

    /**
     * Display error information until User clicks DiscardButton
     */
    private void displayConfirmationBox() {
        settingBox = new SettingBox(this);
        settingBox.showAndWait();
    }

    /**
     * Handle DiscardButton
     */
    public void handleDiscardButtonClick() {
        settingBox.close();

    }


   /* private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Results:");
        alert.setContentText("Connect to the database successfully!");

        alert.showAndWait();
    }*/
}
