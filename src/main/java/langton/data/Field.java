package langton.data;


import javafx.scene.paint.Color;

/**
 * @author Natalie Breu
 * @version 14_02_2019
 *
 * TODO: Add JavaDoc
 */
public class Field {

    private Color color;

    public Field(Color color) {
        this.color = color;
    }

    public void swapColor(Color color){
        this.color = color;

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
