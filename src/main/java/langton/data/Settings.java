package langton.data;

/**
 * @author Gerome Wiss
 * @version 26_03_2019
 */
public class Settings {
    private boolean useTorus, renderAnts;

    public Settings(boolean useTorus, boolean renderAnts) {
        this.useTorus = useTorus;
        this.renderAnts = renderAnts;
    }

    public void setUseTorus(boolean useTorus) {
        this.useTorus = useTorus;
    }

    public void setRenderAnts(boolean renderAnts) {
        this.renderAnts = renderAnts;
    }

    public boolean useTorus() {
        return useTorus;
    }

    public boolean renderAnts() {
        return renderAnts;
    }
}
