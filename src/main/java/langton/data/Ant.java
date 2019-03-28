package langton.data;

import javafx.scene.paint.Color;
import langton.helpers.Point;

/**
 * @author Gerome Wiss
 * @version 28_03_2019
 *
 * This class holds all information about a single ant on the field.
 * It provides methods to move the ant around and to change the direction it's facing.
 */
public class Ant {

    private Point position;
    private int direction;

    /**
     * Initialises an ant.
     * @param position The inital position of the ant.
     * @param direction The inital direction the ant is facing.
     */
    public Ant(Point position, int direction) {
        this.position = position;
        this.direction = direction;
    }

    /**
     * Changes the direction of the ant, based on the color of the Field.
     * @param field The field that the ant stands on.
     */
    public void changeDirection(Field field) {
        Color color = field.getColor();
        if(color.getRed() < 0.3 && color.getGreen() < 0.3 && color.getBlue() < 0.3) {
            this.turnRight();
        } else {
            this.turnLeft();
        }
    }

    /**
     *
     */
    private void turnRight() {
        if(direction < 270) {
            direction += 90;
        } else {
            direction = 0;
        }
    }


    /**
     *
     */
    private void turnLeft() {
        if(direction > 0) {
            direction -= 90;
        } else {
            direction = 270;
        }
    }

    /**
     * This method can be called to let the ant move into a specific direction and change it's direction based on
     * the field it stands on.
     */
    public void tick() {
        this.move();
        // TODO: Change Direction based on field.
    }

    /**
     * This method changes the position of the ant based on the direction it is facing.
     */
    public void move() {
        switch (direction) {
            case 0:
                position.decreaseY();
                break;
            case 90:
                position.increaseX();
                break;
            case 180:
                position.increaseY();
                break;
            case 270:
                position.decreaseX();
                break;
        }
    }

    /**
     * @return Returns the position of the ant as a Point.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * @return Returns the direction the ant is facing.
     */
    public int getDirection() {
        return direction;
    }
}
