package langton.data;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
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
    private Settings settings;

    /**
     *
     * @param rows The initial amount of rows that are to be displayed.
     * @param columns The initial amount of columns that are to be displayed.
     */
    public Algorithm(int rows, int columns, int intervalMillis, boolean useTorus, boolean renderAnts) {
        this.map = new Map(rows, columns);
        map.generateMap();
        ants = new ArrayList<>();
        tickListeners = new ArrayList<>();
        this.createTimeline(intervalMillis);
        this.settings = new Settings(useTorus, renderAnts);
    }

    /**
     * This method causes all the ants to move and the fields to change color when an ant moves onto them.
     * It also notifies all tick listeners, so that they can update their GUI.
     */
    public void tick() {
        for(Ant ant : ants) {
            ant.move();
            //                      50                      100
            //System.out.println(map.getRowsCount() + " " + map.getColumnsCount());
            if(settings.useTorus()) {
                int x = ant.getPosition().getX(), y = ant.getPosition().getY();
                if(x > map.getRowsCount() - 1) {
                    ant.getPosition().setX(x % (map.getRowsCount() - 1));
                } else if(x < 0) {
                    ant.getPosition().setX(map.getRowsCount() - 1);
                }
                if(y > (map.getColumnsCount() - 1)) {
                    ant.getPosition().setY(y % (map.getColumnsCount() - 1));
                } else if(y < 0) {
                    ant.getPosition().setY(map.getColumnsCount() - 1);
                }
            }
            Field newField = null;
            try {
                newField = map.getFields()[ant.getPosition().getX()][ant.getPosition().getY()];
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ant.getPosition().getX() + " out of " + map.getRowsCount() + " / " + ant.getPosition().getY() + " out of " + map.getColumnsCount());
            }
            newField.swapColor();
            ant.changeDirection(newField);
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
    public void addAnt(int x, int y, int direction) {
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

    public Settings getSettings() {
        return settings;
    }
}
