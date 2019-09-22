package com.checkers;

import com.checkers.figures.Figure;
import com.checkers.figures.None;

import java.util.*;

public class BoardRow {

    private List<Figure> figure;

    public BoardRow() {
        figure = new ArrayList<>();
        for(int i = 0; i < Board.getBoardSize(); i++) {
            figure.add(new None());
        }
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
        for (Figure value : figure) {
            temp += value.toString() + "|";
        }
        return "|" + temp + "\n";
    }
}
