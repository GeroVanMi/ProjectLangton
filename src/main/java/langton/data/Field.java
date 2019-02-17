package langton.data;

import javafx.scene.paint.Color;

/**
 * @author Natalie Breu
 * @version 16_02_2019
 * <p>
 *  This class is responsible for the changing of the field color.
 */
public class Field {

    private Color color;
    private boolean wasVisited;

    /**
     * @param color
     */

    public Field(Color color) {
        this.wasVisited = false;
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

    public void brightenUp() {
        if (wasVisited) {
            wasVisited = false;
        } else {
            wasVisited = true;
        }
        double red = color.getRed(), green = color.getGreen(), blue = color.getBlue();
        if(color.getGreen() < 0.95) {
            green += 0.05;
        } else if(color.getRed() < 0.95) {
            red += 0.05;
        } else if(color.getBlue() < 0.95) {
            blue += 0.05;
        }
        color = new Color(red, green, blue, 1);
    }

    /**
     * @return Returns the color of the field.
     */
    public Color getColor() {
        return color;
    }

    public boolean wasVisited() {
        return wasVisited;
    }
}
