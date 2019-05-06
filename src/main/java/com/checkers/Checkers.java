package com.checkers;

import javafx.application.Application;
import javafx.stage.Stage;

public class Checkers extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new CheckersGame(primaryStage).invoke();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
