package langton.data;

/**
 * @author Gerome Wiss
 * @version 26_03_2019
 *
 * TODO: Update JavaDoc
 */
public class Settings {
    private boolean useTorus, renderAnts;
    private double ticksPerSecond;
    private Algorithm algorithm;

    /**
     *
     * @param useTorus
     * @param renderAnts
     */
    public Settings(boolean useTorus, boolean renderAnts, double ticksPerSecond, Algorithm algorithm) {
        this.useTorus = useTorus;
        this.renderAnts = renderAnts;
        this.ticksPerSecond = ticksPerSecond;
        this.algorithm = algorithm;
    }

    /**
     *
     * @param useTorus
     */
    public void setUseTorus(boolean useTorus) {
        this.useTorus = useTorus;
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
    public boolean useTorus() {
        return useTorus;
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
    }
}
