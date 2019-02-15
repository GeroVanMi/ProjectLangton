package langton.data;

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

    /**
     *
     * @param rows
     * @param columns
     */
    public Algorithm(int rows, int columns) {
        this.map = new Map(rows, columns);
        ants = new ArrayList<>();
    }

    /**
     * @return
     */
    public ArrayList<Ant> getAnts() {
        return ants;
    }

    /**
     * @return
     */
    public Map getMap() {
        return map;
    }
}
