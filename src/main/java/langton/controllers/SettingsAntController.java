package langton.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import langton.views.SettingsAntView;

/**
 * @author Natalie Breu
 * @version 29_03_2019
 */
public class SettingsAntController { //Date geh und Date neh im Controller! Alles andere chunnt id View.

    private SettingsAntView settingsAntView;

    public SettingsAntController() {
        settingsAntView = new SettingsAntView();
        settingsAntView.showAndWait();
    }

    public void handleSettingsAnt(ActionEvent event) {
        double textRed = Double.parseDouble(settingsAntView.getRedTextField().getText());
        double textGreen = Double.parseDouble(settingsAntView.getGreenTextField().getText());
        double textBlue = Double.parseDouble(settingsAntView.getBlueTextField().getText());

        if (textRed > 255.0 || textGreen > 255.0 || textBlue > 255.0) {
            showAlertWithHeaderText();
        }

    }

    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Results:");
        alert.setContentText("Connect to the database successfully!");

        //alert.showAndWait();
    }
}
