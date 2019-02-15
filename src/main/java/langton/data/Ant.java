package langton.data;

import langton.helpers.Direction;
import langton.helpers.Point;

/**
 * @author Gerome Wiss
 * @version 15_02_2019
 *
 * This class holds all information about a single ant on the field.
 * It provides methods to move the ant around and to change the direction it's facing.
 */
public class Ant {

    private Point position;
    private Direction direction;

    /**
     * @param position The inital position of the ant.
     * @param direction The inital direction the ant is facing.
     */
    public Ant(Point position, Direction direction) {
        this.position = position;
        this.direction = direction;
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
