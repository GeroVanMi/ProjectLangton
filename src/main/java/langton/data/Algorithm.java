package langton.data;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import langton.helpers.Direction;
import langton.helpers.Point;
import langton.helpers.TickListener;

import java.util.ArrayList;

/**
 * @author Gerome Wiss
 * @version 16_02_2019
 *
 * This class manages all the data about the ants and the map.
 */
public class Algorithm {
    private ArrayList<Ant> ants;
    private Map map;
    private Timeline timeline;
    private ArrayList<TickListener> tickListeners;

    /**
     *
     * @param rows The initial amount of rows that are to be displayed.
     * @param columns The initial amount of columns that are to be displayed.
     */
    public Algorithm(int rows, int columns) {
        this.map = new Map(rows, columns);
        map.generateMap();
        ants = new ArrayList<>();
        tickListeners = new ArrayList<>();
        this.createTimeline(5);
    }

    /**
     * This method causes all the ants to move and the fields to change color when an ant moves onto them.
     * It also notifies all tick listeners, so that they can update their GUI.
     */
    public void tick() {
        for(Ant ant : ants) {
            try {
                ant.move();
                Field newField = map.getFields()[ant.getPosition().getX()][ant.getPosition().getY()];
                newField.brightenUp();
                ant.changeDirection(newField);
            } catch (ArrayIndexOutOfBoundsException exception) {
                // TODO: Increase Map size
                ants.remove(ant);
            }
        }
        for(TickListener tickListener : tickListeners) {
            tickListener.update();
        }
    }

    /**
     * This method instantiates a new timeline object.
     * @param intervalMillis The amount of time that passes between two cycles in milliseconds.
     */
    public void createTimeline(int intervalMillis) {
        this.timeline = new Timeline(new KeyFrame(Duration.millis(intervalMillis), e -> this.tick()));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
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

    /**
     * Adds a tick listener. Used whenever a new view controller wants to access the data of the algorithm.
     * @param tickListener The tick listener that is to be added.
     */
    public void addTickListener(TickListener tickListener) {
        tickListeners.add(tickListener);
    }

    /**
     * Removes a tick listener. Used whenever a view controller is deleted.
     * @param tickListener The tick listener to be removed.
     */
    public void removeTickListener(TickListener tickListener) {
        tickListeners.remove(tickListener);
    }

    /**
     * Removes all tick listeners.
     */
    public void clearTickListners() {
        tickListeners.clear();
    }
}
