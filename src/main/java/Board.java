import figures.Figure;

import java.util.*;

public class Board {

    private List<BoardRow> bR;

    public Board(List<BoardRow> bR) {
        this.bR = bR;
    }

    public Figure getFigure(int row, int col) {
        return bR.get(row).getFigure().get(col);
    }

    public void setFigure(int row, int col, Figure figure) {
        bR.get(row).setFigure(col, figure);
    }

    @Override
    public String toString() {
        String temp = "";
        Iterator<BoardRow> iBR = bR.iterator();
        while(iBR.hasNext()) {
            temp += iBR.next().toString();
        }
        return temp;
    }
}
