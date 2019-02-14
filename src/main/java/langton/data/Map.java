package langton.data;

import javafx.scene.paint.Color;

public class Map {

    private Field[][] fields;

    public Map() {
        fields = new Field[50][50];
    }

    public void increaseMapSize(int amountX, int amountY){
        for (int x = 0; x < amountX; x++) {
            for (int y = 0; y < amountY; y++) {
                fields[x][y] = new Field(new Color(0.23,0.23,0.23,1));
            }

        }

    }

    public void generateMap(){
        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields[x].length; y++) {
                fields[x][y] = new Field(new Color(0.23,0.23,0.23,1));
            }

        }

    }

    public Field[][] getFields() {
        return fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }
}
