package com.checkers;

import com.checkers.figures.ColorType;
import com.checkers.figures.Figure;
import com.checkers.figures.None;
import com.checkers.figures.Pawn;

import java.util.*;

public class Board {

    private static final int BOARD_SIZE = 8;

    private List<BoardRow> bR;

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

    public void move(int oldX, int oldY, int newX, int newY) {
        Figure figure = this.getFigure(oldX, oldY);
        this.setFigure(newX, newY, figure);
        this.setFigure(oldX, oldY, new None());
    }

    public void initBoard() {
        setFigure(0,0, new Pawn(ColorType.BLUE));
        setFigure(1,1, new Pawn(ColorType.RED));
        setFigure(2,0, new Pawn(ColorType.BLUE));
    }
}
