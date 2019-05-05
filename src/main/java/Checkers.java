import figures.ColorType;
import figures.Pawn;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static figures.Pawn.*;

public class Checkers extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = refreshScene();

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
