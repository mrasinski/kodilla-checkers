package figures;

import javafx.scene.paint.Color;

public class Figure {

    Figure figure;
    Color color;

    public Figure(Figure figure, Color color) {
        if(figure.equals("PAWN") || figure.equals("QUEEN")) {
            this.figure = figure;
            this.color = color;
        } else {
            this.figure = figure;
        }
    }

    /*@Override
    public String toString() {
        if(figure.equals("NONE")) {
            return "  ";
        }
        return this.color + String.valueOf(this.figure);
    }*/
}
