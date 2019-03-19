import figures.Figure;
import javafx.scene.image.Image;

import java.util.*;

public class Board {

    private static final int BOARD_SIZE = 8;
    private static final int SIZE_SQUARE = 64;
    private static final int NUM_PIECES = 12;
    private static Image board = new Image("file/checkersBoardcienszalinia.png");

    private List<BoardRow> bR;

    public Board() {
        bR = new ArrayList<>();
        for(int i = 0; i < BOARD_SIZE; i++) {
            bR.add(new BoardRow());
        }
    }
    /*public Board(List<BoardRow> bR) {
        this.bR = bR;
    }*/

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

    public static int getSizeSquare() {
        return SIZE_SQUARE;
    }

    public static int getNumPieces() {
        return NUM_PIECES;
    }

    public static Image getBoard() {
        return board;
    }

    public List<BoardRow> getbR() {
        return bR;
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
