package langton.data;

import javafx.scene.paint.Color;

/**
 * @author Natalie Breu
 * @version 14_02_2019
 * <p>
 *  This class handel the creation and increment of the field, on which the ant(s) move.
 * TODO: Add JavaDoc
 */
public class Map {

    private Field[][] fields;

    /**
     * @param rows
     * @param columns
     */

    public Map(int rows, int columns) {
        fields = new Field[rows][columns];
    }

    /**
     * When the ant reaches the end of the field, this method increases the field.
     *
     * @param amountX The initial amount of fields which increases the rows.
     * @param amountY The initial amount of fields which increases the columns.
     */

    public void increaseMapSize(int amountX, int amountY) {
        for (int x = 0; x < amountX; x++) {
            for (int y = 0; y < amountY; y++) {
                fields[x][y] = new Field(new Color(0.2, 0.2, 0.2, 1));
            }
        }
    }

    /**
     * This method created the startfield with a lenght and a width of 50 grey fields.
     */

    public void generateMap() {
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields[x].length; y++) {
                fields[x][y] = new Field(new Color(0.2, 0.2, 0.2, 1));
            }
        }
    }

    /**
     * @return Returns the fields.
     */
    public Field[][] getFields() {
        return fields;
    }

    /**
     * @return Returns the amount of the rows.
     */
    public int getRowsCount() {
        return fields.length;
    }

    /**
     * @return Returns the amount of the coloms.
     */
    public int getColumnsCount() {
        return fields[0].length;
    }
}
