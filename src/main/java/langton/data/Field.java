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

    /**
     * @param color
     */

    public Field(Color color) {
        this.color = color;
    }

    /**
     * This method is responsible for the change of the color of the field, when the ant touches it.
     */

    public void swapColor() {
        if (color.getRed() < 0.3 && color.getGreen() < 0.3 && color.getBlue() < 0.3) {
            color = new Color(0.5, 0.5, 0.3, 1);
        } else {
            color = new Color(0.2, 0.2, 0.2, 1);
        }
    }

    /**
     * @return Returns the color of the field.
     */
    public Color getColor() {
        return color;
    }
}
