import figures.Figure;

import java.util.*;

public class BoardRow {

    private int row;
    private List<Figure> figure;

    public BoardRow(int row, List<Figure> figure) {
        this.row = row;
        this.figure = figure;
    }

    public List<Figure> getFigure() {
        return figure;
    }

    public void setFigure(int col, Figure f) {
        figure.add(col, f);
        figure.remove(col + 1);
    }

    @Override
    public String toString() {
        String temp = "";
        Iterator<Figure> iT = figure.iterator();
        while(iT.hasNext()) {
            temp += iT.next().toString() + "|";
        }
        return "|" + temp + "\n";
    }
}