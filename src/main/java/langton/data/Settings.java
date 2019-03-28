package langton.data;

/**
 * @author Gerome Wiss
 * @version 26_03_2019
 *
 * TODO: Update JavaDoc
 */
public class Settings {
    private boolean useTorus, renderAnts;

    /**
     *
     * @param useTorus
     * @param renderAnts
     */
    public Settings(boolean useTorus, boolean renderAnts) {
        this.useTorus = useTorus;
        this.renderAnts = renderAnts;
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
}
