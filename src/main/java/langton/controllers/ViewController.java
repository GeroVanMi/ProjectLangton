package langton.controllers;

import langton.views.View;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
 *
 *
 */
public abstract class ViewController {
    private View view;

    /**
     *
     * @param view
     */
    public void createView(View view) {
        this.view = view;
    }

    /**
     *
     * @return
     */
    public View getView() {
        return view;
    }
}
