package langton.data;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import langton.helpers.Direction;
import langton.helpers.Point;
import java.util.ArrayList;

/**
 * @author Gerome Wiss
 * @version 15_02_2019
 *
 * This class manages all the data about the ants and the map.
 */
public class Algorithm {
    private ArrayList<Ant> ants;
    private Map map;
    private Timeline timeline;

    /**
     *
     * @param rows The initial amount of rows that are to be displayed.
     * @param columns The initial amount of columns that are to be displayed.
     */
    public Algorithm(int rows, int columns) {
        this.map = new Map(rows, columns);
        map.generateMap();
        ants = new ArrayList<>();
        this.createTimeline(1000);
    }

    /**
     * This method instantiates a new timeline object.
     * @param intervalMillis The amount of time that passes between two cycles in milliseconds.
     */
    public void createTimeline(int intervalMillis) {
        this.timeline = new Timeline(new KeyFrame(Duration.millis(intervalMillis), e -> {
            for(Ant ant : ants) {
                ant.tick();
            }
        }));
    }

    /**
     * Starts or restarts the timeline. Can't be executed after the timeline has been stopped.
     * @see Timeline
     */
    public void play() {
        timeline.play();
    }

    /**
     * Stops the timeline. Prevents the timeline from being executed again.
     * @see Timeline
     */
    public void stop() {
        timeline.stop();
    }

    /**
     * Pauses the timeline. It can be restarted with the play() method.
     * @see Timeline
     */
    public void pause() {
        timeline.pause();
    }

    /**
     * Adds an ant to the ants array list.
     * @param x The starting x coordinate of the new ant.
     * @param y The starting y coordinate of the new ant.
     * @param direction The direction the ant is initially facing.
     */
    public void addAnt(int x, int y, Direction direction) {
        ants.add(new Ant(new Point(x, y), direction));
    }

    /**
     * @return Returns all the ants in an array list.
     */
    public ArrayList<Ant> getAnts() {
        return ants;
    }

    /**
     * @return Returns the map object.
     */
    public Map getMap() {
        return map;
    }


}
