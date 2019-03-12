package figures;

public class Figure {

    private FigureType figure;
    private ColorType color;

    public Figure(FigureType figure, ColorType color) {
        this.figure = figure;
        this.color = color;
    }

    @Override
    public String toString() {
        return color + String.valueOf(figure);
    }
}
