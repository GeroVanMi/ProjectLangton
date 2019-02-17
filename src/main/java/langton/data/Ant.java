package langton.data;

import javafx.scene.paint.Color;
import langton.helpers.Direction;
import langton.helpers.Point;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
 *
 * This class holds all information about a single ant on the field.
 * It provides methods to move the ant around and to change the direction it's facing.
 */
public class Ant {

    private Point position;
    private Direction direction;

    /**
     * Initialises an ant.
     * @param position The inital position of the ant.
     * @param direction The inital direction the ant is facing.
     */
    public Ant(Point position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    /**
     * Changes the direction of the ant, based on the color of the Field.
     * @param field The field that the ant stands on.
     */
    public void changeDirection(Field field) {
        if(field.wasVisited()) {
            this.turnRight();
        } else {
            this.turnLeft();
        }
    }

    /**
     * Temporary solution! To be replaced with degrees.
     */
    public void turnRight() {
        // TODO: Replace with degrees.
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
        }
    }


    /**
     * Temporary solution! To be replaced by degrees.
     */
    public void turnLeft() {
        // TODO: Replace with degrees.
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
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
            case UP:
                position.decreaseY();
                break;
            case RIGHT:
                position.increaseX();
                break;
            case DOWN:
                position.increaseY();
                break;
            case LEFT:
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
    public Direction getDirection() {
        return direction;
    }
}
