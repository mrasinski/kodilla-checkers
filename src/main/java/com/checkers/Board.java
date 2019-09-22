package com.checkers;

import com.checkers.figures.*;

import java.util.*;

import static com.checkers.figures.Figure.ColorType.*;
import static com.checkers.figures.Figure.FigureType.*;

public class Board {

    private static final int BOARD_SIZE = 8;
    static final int NOT_SELECTED = -1;

    private List<BoardRow> bR;
    private int oldCol = NOT_SELECTED;
    private int oldRow = NOT_SELECTED;

    public Board() {
        bR = new ArrayList<>();
        for(int i = 0; i < BOARD_SIZE; i++) {
            bR.add(new BoardRow());
        }
    }

    public static int getBoardSize() {
        return BOARD_SIZE;
    }

    private List<BoardRow> getbR() {
        return bR;
    }

    public Figure getFigure(int row, int col) {
        return bR.get(row).getFigure().get(col);
    }

    public void setFigure(int row, int col, Figure figure) {
        bR.get(row).setFigure(col, figure);
    }

    public boolean isValidMove (Figure.ColorType colorType, int oldCol, int oldRow, int col, int row) {
        if (col >= BOARD_SIZE || row >= BOARD_SIZE || col < 0 || row < 0 || (col == oldCol && row == oldRow)) {
            System.out.println("Not valid");
            return false;
        }
        if (getFigure(row, col).equals(PAWN) || getFigure(row, col).equals(QUEEN)) {
            System.out.println("Not valid");
            return false;
        }
        if (colorType == BLUE) {
            if (getFigure(oldRow, oldCol).getColorType().equals(colorType) && row < oldRow) {
                System.out.println("Not valid");
                return false;
            }
            return true;
        } else {
            if (getFigure(oldRow, oldCol).getColorType().equals(colorType) && row > oldRow) {
                System.out.println("Not valid");
                return false;
            }
            return true;
        }
    }

    public void move(int oldCol, int oldRow, int col, int row) {
        Figure currentFigure = getFigure(oldRow, oldCol);
        Figure.ColorType currentColor = currentFigure.getColorType();
        Figure newFigure = getFigure(row, col);
        /*newFigure.getFigureType().equals(NONE)*/

        if (isValidMove(currentColor, oldCol, oldRow, col, row)) {
            setFigure(row, col, currentFigure);
            setFigure(oldRow, oldCol, new None());
        }
    }

    public void initBoard() {
        setFigure(0,1, new Pawn(BLUE));
        setFigure(0,3, new Pawn(BLUE));
        setFigure(0,5, new Pawn(BLUE));
        setFigure(0,7, new Pawn(BLUE));
        setFigure(1,0, new Pawn(BLUE));
        setFigure(1,2, new Pawn(BLUE));
        setFigure(1,4, new Pawn(BLUE));
        setFigure(1,6, new Pawn(BLUE));
        setFigure(2,1, new Pawn(BLUE));
        setFigure(2,3, new Pawn(BLUE));
        setFigure(2,5, new Pawn(BLUE));
        setFigure(2,7, new Pawn(BLUE));

        setFigure(5,0, new Pawn(Figure.ColorType.RED));
        setFigure(5,2, new Pawn(Figure.ColorType.RED));
        setFigure(5,4, new Pawn(Figure.ColorType.RED));
        setFigure(5,6, new Pawn(Figure.ColorType.RED));
        setFigure(6,1, new Pawn(Figure.ColorType.RED));
        setFigure(6,3, new Pawn(Figure.ColorType.RED));
        setFigure(6,5, new Pawn(Figure.ColorType.RED));
        setFigure(6,7, new Pawn(Figure.ColorType.RED));
        setFigure(7,0, new Pawn(Figure.ColorType.RED));
        setFigure(7,2, new Pawn(Figure.ColorType.RED));
        setFigure(7,4, new Pawn(Figure.ColorType.RED));
        setFigure(7,6, new Pawn(Figure.ColorType.RED));
    }

    public void doClick(int col, int row) {
        if (oldCol == NOT_SELECTED) {
            oldCol = col;
            oldRow = row;
            GUI.refreshBoard(this, oldCol, oldRow);
        } else {
            move(oldCol, oldRow, col, row);
            oldCol = NOT_SELECTED;
            oldRow = NOT_SELECTED;
            GUI.refreshBoard(this, oldCol, oldRow);
        }
    }
}
