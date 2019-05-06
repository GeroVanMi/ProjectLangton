package langton.data;

/**
 * @author Gerome Wiss
 * @version 06_05_2019
 *
 * TODO: Update JavaDoc
 */
public class Settings {
    private boolean renderAnts;
    private double ticksPerSecond;
    private Algorithm algorithm;

    /**
     *
     * @param renderAnts
     */
    public Settings(boolean renderAnts, double ticksPerSecond, Algorithm algorithm) {
        this.renderAnts = renderAnts;
        this.ticksPerSecond = ticksPerSecond;
        this.algorithm = algorithm;
    }

    /**
     *
     * @param renderAnts
     */
    public void setRenderAnts(boolean renderAnts) {
        this.renderAnts = renderAnts;
    }

    /**
     *
     * @return
     */
    public boolean renderAnts() {
        return renderAnts;
    }

    /**
     *
     * @return
     */
    public double getTicksPerSecond() {
        return ticksPerSecond;
    }

    /**
     *
     * @param ticksPerSecond
     */
    public void setTicksPerSecond(double ticksPerSecond) {
        this.ticksPerSecond = ticksPerSecond;
        algorithm.updateTicks();
    }
}
