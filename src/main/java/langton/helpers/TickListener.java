package langton.helpers;

/**
 * @author Gerome Wiss
 */
public interface TickListener {
    /**
     * This method is called whenever the data in the algorithm changed in a significant way.
     */
    void update();
}
