package langton.controllers;

import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import langton.data.Settings;
import langton.views.settings.ConfirmationBox;
import langton.views.settings.SettingsView;

/**
 * @author Gerome Wiss
 * @version 30_03_2019
 */
public class SettingsController {

    private SettingsView view;
    private ConfirmationBox confirmationBox;
    private Settings settings;

    /**
     * @param settings
     */
    public SettingsController(Settings settings) {
        this.settings = settings;
        this.view = new SettingsView(settings, this);
        this.view.show();
    }

    /**
     *
     */
    public void handleOnCloseRequest(WindowEvent event) {
        event.consume();
        if (hasUnsavedChanges()) {
            if (confirmationBox == null) {
                displayConfirmationBox();
                view.close();
            }
        } else {
            view.close();
        }
    }

    /**
     *
     */
    public void handleSubmitButtonClick(ActionEvent event) {
        applyChanges();
        view.close();
    }

    /**
     *
     */
    public void handleCancelButtonClick(ActionEvent event) {
        if (hasUnsavedChanges()) {
            if (confirmationBox == null) {
                displayConfirmationBox();
                view.close();
            }
        } else {
            view.close();
        }
    }

    /**
     *
     */
    public void handleApplyButtonClick(ActionEvent event) {
        applyChanges();
    }

    /**
     *
     */
    public void handleDiscardButtonClick(ActionEvent event) {
        confirmationBox.close();
    }

    /**
     *
     */
    public void handleBoxSaveButtonClick(ActionEvent event) {
        applyChanges();
        confirmationBox.close();
    }

    /**
     *
     */
    private void displayConfirmationBox() {
        confirmationBox = new ConfirmationBox(this);
        confirmationBox.showAndWait();

    }

    /**
     *
     */
    private void applyChanges() {
        settings.setUseTorus(useTorus());
        settings.setRenderAnts(renderAnts());
        settings.setTicksPerSecond(view.getTickSlider().getValue());
    }

    /**
     * @return
     */
    private boolean hasUnsavedChanges() {
        boolean hasUnsavedChanges = false;
        if (settings.useTorus() != useTorus()) {
            hasUnsavedChanges = true;
        } else if (settings.renderAnts() != renderAnts()) {
            hasUnsavedChanges = true;
        } else if (settings.getTicksPerSecond() != view.getTickSlider().getValue()) {
            hasUnsavedChanges = true;
        }
        return hasUnsavedChanges;
    }

    /**
     * @return
     */
    public SettingsView getView() {
        return view;
    }

    /**
     * @return
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * @return
     */
    private boolean useTorus() {
        return view.getTorusCheckBox().isSelected();
    }

    /**
     * @return
     */
    private boolean renderAnts() {
        return view.getAntRenderingCheckBox().isSelected();
    }
}
