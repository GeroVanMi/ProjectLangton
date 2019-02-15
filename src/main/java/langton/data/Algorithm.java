package langton.data;

import java.util.ArrayList;

/**
 * @author Gerome Wiss
 * @version 15_02_2019
 *
 * This class manages all the data about the ants and the map.
 */
public class Algorithm extends Thread {
    private ArrayList<Ant> ants;
    private Map map;

    /**
     *
     * @param rows The initial amount of rows that are to be displayed.
     * @param columns The initial amount of columns that are to be displayed.
     */
    public Algorithm(int rows, int columns) {
        this.map = new Map(rows, columns);
        ants = new ArrayList<>();
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            for (Ant ant : ants) {
                ant.tick();
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
