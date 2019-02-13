package langton.helpers;

/**
 * This helper-class holds two values to display a Point in a coordinate system.
 */
public class Point {
    private int x, y;

    /**
     * @param x The x-value.
     * @param y The y-value.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return Returns the x-value of the point.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Returns the y-value.
     */
    public int getY() {
        return y;
    }

    /**
     * Increases the x-value by one.
     */
    public void increaseX() {
        this.x++;
    }

    /**
     * Decreases the x-value by one.
     */
    public void decreaseX() {
        this.x--;
    }

    /**
     * Increases the y-value by one.
     */
    public void increaseY() {
        this.y--;
    }

    /**
     * Decreases the y-value by one.
     */
    public void decreaseY() {
        this.y--;
    }
}
