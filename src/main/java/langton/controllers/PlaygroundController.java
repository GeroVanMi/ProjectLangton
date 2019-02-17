package langton.controllers;

import langton.data.Algorithm;
import langton.data.Ant;
import langton.helpers.Point;
import langton.helpers.TickListener;
import langton.views.Playground;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
 *
 * This class controls all changes that happen on the corresponding playground object.
 * It handles inputs from the user and changes the view according to the changes in the data.
 */
public class PlaygroundController extends ViewController implements TickListener {
    private Playground playground;
    private Algorithm algorithm;

    /**
     * This constructor creates a Map and initialises the values needed for the playground.
     * @param width The initial width of the window.
     * @param height The initial height of the window.
     */
    public PlaygroundController(double width, double height, Algorithm algorithm) {
        this.playground = new Playground(width, height);
        super.createView(playground);
        this.algorithm = algorithm;
        algorithm.addTickListener(this);
        this.updateFullPlayground();
    }

    /**
     * Updates the grid on the playground.
     */
    public void updateFullPlayground() {
        playground.clearCanvas();
        playground.drawGrid(algorithm.getMap().getRowsCount(), algorithm.getMap().getColumnsCount(), algorithm.getMap());
        for(Ant ant : algorithm.getAnts()) {
            //playground.drawAnt(ant);
        }
    }

    /**
     *
     */
    public void updatePlayground() {
        for(Ant ant : algorithm.getAnts()) {
            Point pos = ant.getPosition();

            for(int i = -1; i < 2; i++) {
                for(int j = -1; j < 2; j++) {
                    playground.clearField(pos.getX() + i, pos.getY() + j);
                    playground.drawField(pos.getX() + i, pos.getY() + j, algorithm.getMap().getFields()[pos.getX() + i][pos.getY() + j]);
                }
            }

            //playground.drawAnt(ant);
        }
    }

    /**
     * In- or decreases the size of the canvas on the playground.
     * @param width The new width.
     * @param height The new height.
     */
    public void updateCanvasSize(double width, double height) {
        playground.updateCanvasSize(width, height);
    }

    /**
     * @return Returns the playground.
     */
    public Playground getPlayground() {
        return playground;
    }

    /**
     * This method is called whenever the data in the algorithm changed in a significant way.
     * @see TickListener
     */
    @Override
    public void update() {
        this.updatePlayground();
    }
}
