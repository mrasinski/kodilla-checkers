package com.checkers;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckersGame {
    private Stage primaryStage;
    private Board board = new Board();

    public CheckersGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void invoke() {
        board.initBoard();
        Scene scene = GUI.createScene();

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        GUI.refreshBoard(board);
    }
}
