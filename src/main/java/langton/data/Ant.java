package langton.data;

import langton.helpers.Direction;
import langton.helpers.Point;

public class Ant {

    private Point position;
    private Direction direction;

    public Ant(Point position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void tick() {
        this.move();
    }

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

    public Point getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
