package langton.controllers;

import langton.data.Settings;
import langton.views.settings.ConfirmationBox;
import langton.views.settings.SettingsView;

/**
 * @author Gerome Wiss
 * @version 28_03_2019
 */
public class SettingsController {

    private SettingsView view;
    private ConfirmationBox confirmationBox;
    private Settings settings;

    public SettingsController(Settings settings) {
        this.settings = settings;
        this.view = new SettingsView(settings, this);
        this.view.show();
    }

    public void handleOnCloseRequest() {
        if(hasUnsavedChanges()) {
            displayConfirmationBox();
        } else {
            view.close();
        }
    }

    public void handleSubmitButtonClick() {
        applyChanges();
        view.close();
    }

    public void handleCancelButtonClick() {
        if(hasUnsavedChanges()) {
            displayConfirmationBox();
            view.close();
        } else {
            view.close();
        }
    }

    public void handleApplyButtonClick() {
        applyChanges();
    }

    public void handleDiscardButtonClick() {
        confirmationBox.close();
    }

    public void handleBoxSaveButtonClick() {
        applyChanges();
        confirmationBox.close();
    }

    public void displayConfirmationBox() {
        confirmationBox = new ConfirmationBox(this);
        confirmationBox.showAndWait();
    }

    public void applyChanges() {
        settings.setUseTorus(useTorus());
        settings.setRenderAnts(renderAnts());
    }

    public boolean hasUnsavedChanges() {
        boolean hasUnsavedChanges = false;
        if(settings.useTorus() != useTorus()) {
            hasUnsavedChanges = true;
        } else if(settings.renderAnts() != renderAnts()) {
            hasUnsavedChanges = true;
        }
        return hasUnsavedChanges;
    }

    public SettingsView getView() {
        return view;
    }

    public Settings getSettings() {
        return settings;
    }

    private boolean useTorus() {
        return view.getTorusCheckBox().isSelected();
    }

    private boolean renderAnts() {
        return view.getAntRenderingCheckBox().isSelected();
    }
}
