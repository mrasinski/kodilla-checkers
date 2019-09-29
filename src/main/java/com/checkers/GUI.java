package com.checkers;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

class GUI {
    private static Image board = new Image("file/checkersBoardcienszalinia.png");
    private static final int SIZE_SQUARE = 64;
    private static GridPane gridPane;

    private static Image getBoard() {
        return board;
    }

    private static int getSizeSquare() {
        return SIZE_SQUARE;
    }

    static void refreshBoard(Board board, int colEn, int rowEn) {
        gridPane.getChildren().clear();
        for(int col = 0; col < Board.getBoardSize(); col++) {
            for (int row = 0; row < Board.getBoardSize(); row++) {
                boolean en = (col == colEn) && (row == rowEn);
                ImageView imageView = board.getFigure(col, row).getImage(en);
                gridPane.add(imageView, col, row);
                gridPane.setHalignment(imageView, HPos.CENTER);
                gridPane.setValignment(imageView, VPos.CENTER);
            }
        }
    }

    static Scene createScene() {
        BackgroundSize backgroundSize = new BackgroundSize(512, 512,
                false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(getBoard(), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane gridPane1 = new GridPane();

        for(int n = 0; n < Board.getBoardSize(); n++) {
            RowConstraints rowCon = new RowConstraints();
            rowCon.setMinHeight(getSizeSquare());
            rowCon.setValignment(VPos.CENTER);
            ColumnConstraints colCon = new ColumnConstraints();

            colCon.setMinWidth(getSizeSquare());
            colCon.setHalignment(HPos.CENTER);
            gridPane1.getRowConstraints().add(rowCon);
            gridPane1.getColumnConstraints().add(colCon);
        }

        gridPane1.setPrefSize(512, 512);
        gridPane1.setMinHeight(512);
        gridPane1.setMinWidth(512);

        gridPane = gridPane1;
        gridPane.setBackground(background);

        return new Scene(gridPane, 512, 512, Color.TRANSPARENT);
    }
}
