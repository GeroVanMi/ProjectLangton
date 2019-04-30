package langton.controllers;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import langton.data.Algorithm;
import langton.data.Settings;
import langton.views.antSettings.SettingsAntView;
import langton.views.antSettings.SettingBox;

/**
 * @author Natalie Breu
 * @version 30_04_2019
 */
public class SettingsAntController {

    private SettingsAntView settingsAntView;
    private SettingBox settingBox;
    private Settings settings;
    private Algorithm algorithm;
    private int x, y;

    /**
     * Constructor for the SettingsAntController.
     */
    public SettingsAntController(Algorithm algorithm, int x, int y) {
        this.algorithm = algorithm;
        settingsAntView = new SettingsAntView(this);
        this.x = x;
        this.y = y;
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
            } else {
                Color color = new Color(doubleRed / 255, doubleGreen / 255, doubleBlue / 255, 1);
                this.algorithm.addAnt(
                        this.x,
                        this.y,
                        0,
                        color,
                        settingsAntView.getRuleEmpty(),
                        settingsAntView.getRuleFilled()
                );

                settingsAntView.close();
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
}
