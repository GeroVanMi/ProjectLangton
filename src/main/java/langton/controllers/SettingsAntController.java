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
        settingsAntView = new SettingsAntView(this);
        settingsAntView.showAndWait();
    }

    public void handleSettingsAnt(ActionEvent event) {
        String textRed = settingsAntView.getRedTextField().getText();
        String textGreen = settingsAntView.getGreenTextField().getText();
        String textBlue = settingsAntView.getBlueTextField().getText();

        double doubleRed = Double.parseDouble(textRed);
        double doubleGreen = Double.parseDouble(textGreen);
        double doubleBlue = Double.parseDouble(textBlue);

        if (doubleRed > 255.0 || doubleGreen > 255.0 || doubleBlue > 255.0) {
            showAlert();
        }

    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Connection");
        alert.setHeaderText("Results:");
        alert.setContentText("Connect to the database successfully!");

        //alert.showAndWait();
    }
}
