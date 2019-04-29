package langton.data;

import javafx.scene.paint.Color;
import langton.helpers.Point;

/**
 * @author Gerome Wiss
 * @version 26_04_2019
 *
 * This class holds all information about a single ant on the field.
 * It provides methods to move the ant around and to change the direction it's facing.
 */
public class Ant {

    private Point position, lastPosition;
    private int turnDegreesOnEmpty, turnDegreesOnFilled;
    private Color trailColor;
    private int direction;

    /**
     * Initialises an ant.
     * @param position The inital position of the ant.
     * @param direction The inital direction the ant is facing.
     */
    public Ant(Point position, int direction, Color color) {
        this.position = position;
        this.lastPosition = new Point(position.getX(), position.getY());
        this.direction = direction;
        this.trailColor = color;
    }

    /**
     * Changes the direction of the ant, based on the color of the Field.
     * @param field The field that the ant currently stands on.
     */
    public void changeDirection(Field field) {
        Color color = field.getColor();
        if(color.getRed() < 0.3 && color.getGreen() < 0.3 && color.getBlue() < 0.3) {
            this.turn(90);
        } else {
            this.turn(-90);
        }
    }

    /**
     * Turns the ant by a certain degree.
     * @param degree The amount in degrees that the ant should be rotate with. This can be negative.
     */
    private void turn(int degree) {
        /* Check to avoid degree numbers that aren't divisible by 90
         * If ever any other map-mode (e.g. hexagons instead of squares) is implemented this check would have to be
         * altered or removed as it only allows for 90 or 180 degree turns.
         */
        if (degree % 90 == 0) {
            this.direction += degree;
            if (this.direction < 0) {
                this.direction += 360;
            } else if (this.direction >= 360) {
                this.direction -= 360;
            }
        }
    }

    /**
     * This method changes the position of the ant based on the direction it is facing.
     */
    public void move() {
        lastPosition.setX(position.getX());
        lastPosition.setY(position.getY());
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
     * @return Returns the last position of the ant.
     */
    public Point getLastPosition() {
        return lastPosition;
    }

    /**
     * @return Returns the direction the ant is facing.
     */
    public int getDirection() {
        return direction;
    }

    public Color getTrailColor() {
        return trailColor;
    }
}
