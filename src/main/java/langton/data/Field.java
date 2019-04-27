package langton.data;

import javafx.scene.paint.Color;

/**
 * @author Natalie Breu
 * @version 16_02_2019
 * <p>
 *  This class is responsible for the changing of the field color.
 * TODO: Add JavaDoc
 */
public class Field {

    private Color color;
    private boolean isFilled;

    /**
     * @param color
     */
    public Field(Color color) {
        this.color = color;
        this.isFilled = false;
    }

    /**
     * This method is responsible for the change of the color of the field, when the ant touches it.
     */
    public void swapColor(Color color) {
        if (isFilled) {
            this.color = color;
            this.isFilled = false;
        } else {
            this.color = new Color(0.2, 0.2, 0.2, 1);
            this.isFilled = true;
        }
    }

    /**
     * @return Returns the color of the field.
     */
    public Color getColor() {
        return color;
    }
}
