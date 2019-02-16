package langton.controllers;

import langton.views.View;

public abstract class ViewController {
    private View view;

    public void createView(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
