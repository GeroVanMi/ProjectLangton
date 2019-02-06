package langton.helpers;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void increaseX() {
        this.x++;
    }

    public void decreaseX() {
        this.x--;
    }

    public void increaseY() {
        this.y--;
    }

    public void decreaseY() {
        this.y--;
    }
}
