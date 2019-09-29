package com.checkers;

import javafx.scene.Scene;
import javafx.stage.Stage;

class CheckersGame {
    private Stage primaryStage;
    private Board board = new Board();

    CheckersGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void invoke() {
        board.initBoard();
        Scene scene = GUI.createScene();
        scene.setOnMouseClicked(event -> {
            int row = (int)event.getY() / 64;
            int col = (int)event.getX() / 64;
            board.doClick(col, row);
        });
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        GUI.refreshBoard(board, Board.NOT_SELECTED, Board.NOT_SELECTED);
    }
}
