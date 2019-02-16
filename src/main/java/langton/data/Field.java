package langton.data;


import javafx.scene.paint.Color;

/**
 * @author Natalie Breu
 * @version 16_02_2019
 *
 * TODO: Add JavaDoc
 */
public class Field {

    private Color color;

    public Field(Color color) {
        this.color = color;
    }

    public void swapColor(){
        if(color.getRed() < 0.3 && color.getGreen() < 0.3 && color.getBlue() < 0.3) {
            color = new Color(0.5, 0.5, 0.3, 1);
        } else {
            color = new Color(0.2, 0.2, 0.2, 1);
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
