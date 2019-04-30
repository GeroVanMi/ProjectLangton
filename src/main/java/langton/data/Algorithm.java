package langton.data;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import langton.helpers.Point;
import langton.helpers.TickListener;
import java.util.ArrayList;

/**
 * @author Gerome Wiss
 * @version 30_04_2019
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
    public Algorithm(int rows, int columns, int ticksPerSecond, boolean useTorus, boolean renderAnts) {
        this.settings = new Settings(useTorus, renderAnts, ticksPerSecond, this);
        this.map = new Map(rows, columns);
        map.generateMap();
        ants = new ArrayList<>();
        tickListeners = new ArrayList<>();
        this.createTimeline();
    }

    /**
     * This method causes all the ants to move and the fields to change color when an ant moves onto them.
     * It also notifies all tick listeners, so that they can update their GUI.
     */
    private void tick() {
        for(Ant ant : ants) {
            ant.move();
            //System.out.println(map.getRowsCount() + " " + map.getColumnsCount());
            if(settings.useTorus()) {
                int x = ant.getPosition().getX(), y = ant.getPosition().getY();
                if(x > map.getRowsCount() - 1) {
                    ant.getPosition().setX(x % map.getRowsCount());
                    ant.getPosition().setY(y % map.getColumnsCount());
                } else if(x < 0) {
                    ant.getPosition().setX(map.getRowsCount() - 1);
                    ant.getPosition().setY(y % map.getColumnsCount());
                }
                if(y > (map.getColumnsCount() - 1)) {
                    ant.getPosition().setY(y % (map.getColumnsCount()));
                    ant.getPosition().setX(x % map.getRowsCount());
                } else if(y < 0) {
                    ant.getPosition().setY(map.getColumnsCount() - 1);
                    ant.getPosition().setX(x % map.getRowsCount());
                }
            }

            Field fieldAntAt = map.getFields()[ant.getPosition().getX()][ant.getPosition().getY()];
            fieldAntAt.swapColor(ant.getTrailColor());
            ant.changeDirection(fieldAntAt);
        }
        for(TickListener tickListener : tickListeners) {
            tickListener.update();
        }
    }

    /**
     * This method instantiates a new timeline object.
     */
    private void createTimeline() {
        this.timeline = new Timeline(new KeyFrame(Duration.millis(1000 / settings.getTicksPerSecond()), e -> this.tick()));
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
    public void addAnt(int x, int y, int direction, Color color, int turnRuleEmpty, int turnRuleFull) {
        ants.add(new Ant(new Point(x, y), direction, color, turnRuleEmpty, turnRuleFull));
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

    /**
     *
     * @return
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     *
     */
    public void updateTicks() {
        this.stop();
        this.createTimeline();
        this.play();
    }
}
