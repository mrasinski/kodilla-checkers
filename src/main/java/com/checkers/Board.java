package com.checkers;

import com.checkers.figures.*;
import javafx.scene.control.Alert;

import java.util.*;

import static com.checkers.figures.Figure.ColorType.*;
import static com.checkers.figures.Figure.FigureType.*;

class Board {

    private static final int BOARD_SIZE = 8;
    static final int NOT_SELECTED = -1;

    private List<BoardRow> bR;
    private int oldCol = NOT_SELECTED;
    private int oldRow = NOT_SELECTED;
    private Figure.ColorType player = BLUE;
    private int blueCount = 0;
    private int redCount = 0;

    Board() {
        bR = new ArrayList<>();
        for(int i = 0; i < BOARD_SIZE; i++) {
            bR.add(new BoardRow());
        }
    }

    static int getBoardSize() {
        return BOARD_SIZE;
    }

    Figure getFigure(int col, int row) {
        return bR.get(row).getFigure().get(col);
    }

    private void setFigure(int col, int row, Figure figure) {
        bR.get(row).setFigure(col, figure);
    }

    private boolean isValidMove (Figure.ColorType colorType, int oldCol, int oldRow, int col, int row) {
        if (checkBoarderValuesAndFigure(oldCol, oldRow, col, row)) return false;
        if (Math.abs(oldCol - col) != 1) return false;

        if (colorType == BLUE) {
            return !getFigure(oldCol, oldRow).getColorType().equals(colorType) || row + 1 != oldRow;
        } else {
            return !getFigure(oldCol, oldRow).getColorType().equals(colorType) || row != oldRow + 1;
        }
    }

    private boolean isValidHit (Figure.ColorType colorType, int oldCol, int oldRow, int col, int row) {
        if (checkBoarderValuesAndFigure(oldCol, oldRow, col, row)) return false;
        if (Math.abs(oldCol - col) != 2) return false;

        int enemyRow = oldRow + ((row > oldRow) ? 1 : -1);
        int enemyCol = oldCol + ((col > oldCol) ? 1 : -1);
        if (getFigure(enemyCol, enemyRow).getFigureType() == NONE || getFigure(enemyCol, enemyRow).getColorType() == colorType) return false;

        if (colorType == BLUE) {
            if (getFigure(oldCol, oldRow).getColorType().equals(colorType) && row + 2 == oldRow) {
                return false;
            }
            blueCount++;
            return true;
        } else {
            if (getFigure(oldCol, oldRow).getColorType().equals(colorType) && row == oldRow + 2) {
                return false;
            }
            redCount++;
            return true;
        }
    }

    private boolean checkBoarderValuesAndFigure(int oldCol, int oldRow, int col, int row) {
        if (col >= BOARD_SIZE || row >= BOARD_SIZE || col < 0 || row < 0 || col == oldCol || row == oldRow) {
            return true;
        }
        return getFigure(col, row).getFigureType().equals(PAWN) || getFigure(col, row).getFigureType().equals(QUEEN);
    }

    private void move(int oldCol, int oldRow, int col, int row) {
        Figure currentFigure = getFigure(oldCol, oldRow);
        Figure.ColorType currentColor = currentFigure.getColorType();

        if (isValidMove(currentColor, oldCol, oldRow, col, row)) {
            setFigure(col, row, currentFigure);
            setFigure(oldCol, oldRow, new None());
            player = getOpposite(player);
        } else if (isValidHit(currentColor, oldCol, oldRow, col, row)){
            int enemyRow = oldRow + ((row > oldRow) ? 1 : -1);
            int enemyCol = oldCol + ((col > oldCol) ? 1 : -1);
            setFigure(col, row, currentFigure);
            setFigure(oldCol, oldRow, new None());
            setFigure(enemyCol, enemyRow, new None());
            player = getOpposite(player);
        }

        if (isGameFinished()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("End of the game");
            alert.setHeaderText(null);
            alert.setContentText(getOpposite(player) + " won the game. To restart press OK");
            alert.showAndWait();
            initBoard();
        }
    }

    private boolean isGameFinished() {
        return blueCount == 12 || redCount == 12;
    }

    private Figure.ColorType getOpposite(Figure.ColorType player) {
        return player == BLUE ? RED : BLUE;
    }

    void initBoard() {
        setFigure(1,0, new Pawn(BLUE));
        setFigure(3,0, new Pawn(BLUE));
        setFigure(5,0, new Pawn(BLUE));
        setFigure(7,0, new Pawn(BLUE));
        setFigure(0,1, new Pawn(BLUE));
        setFigure(2,1, new Pawn(BLUE));
        setFigure(4,1, new Pawn(BLUE));
        setFigure(6,1, new Pawn(BLUE));
        setFigure(1,2, new Pawn(BLUE));
        setFigure(3,2, new Pawn(BLUE));
        setFigure(5,2, new Pawn(BLUE));
        setFigure(7,2, new Pawn(BLUE));

        setFigure(0,5, new Pawn(RED));
        setFigure(2,5, new Pawn(RED));
        setFigure(4,5, new Pawn(RED));
        setFigure(6,5, new Pawn(RED));
        setFigure(1,6, new Pawn(RED));
        setFigure(3,6, new Pawn(RED));
        setFigure(5,6, new Pawn(RED));
        setFigure(7,6, new Pawn(RED));
        setFigure(0,7, new Pawn(RED));
        setFigure(2,7, new Pawn(RED));
        setFigure(4,7, new Pawn(RED));
        setFigure(6,7, new Pawn(RED));
    }

    void doClick(int col, int row) {
        if (oldCol == NOT_SELECTED) {
            if (getFigure(col, row).getColorType() == player) {
                oldCol = col;
                oldRow = row;
                GUI.refreshBoard(this, oldCol, oldRow);
            }
        } else {
            move(oldCol, oldRow, col, row);
            oldCol = NOT_SELECTED;
            oldRow = NOT_SELECTED;
            GUI.refreshBoard(this, oldCol, oldRow);
        }
    }
}
