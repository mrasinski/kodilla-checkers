import figures.ColorType;
import figures.Pawn;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static figures.Pawn.*;

public class Checkers extends Application {

    private void refreshPawns(GridPane gridPane) {
        ImageView redPawns[] = new ImageView[Board.getNumPieces()];
        ImageView bluePawns[] = new ImageView[Board.getNumPieces()];

        for(int i = 0; i < Board.getNumPieces(); i++) {
            redPawns[i] = new ImageView(Pawn.getRedPawn());
            GridPane.setHalignment(redPawns[i], HPos.CENTER);
            GridPane.setValignment(redPawns[i], VPos.CENTER);
            gridPane.add(redPawns[i],i % (Board.getBoardSize() / 2) * 2 + (2 * i / Board.getBoardSize()) % 2,
                    Board.getBoardSize() - 1 - (i * 2) / Board.getBoardSize());

            bluePawns[i] = new ImageView(Pawn.getBluePawn());
            GridPane.setHalignment(bluePawns[i], HPos.CENTER);
            GridPane.setValignment(bluePawns[i], VPos.CENTER);
            gridPane.add(bluePawns[i], i % (Board.getBoardSize() / 2) * 2 + (1 + 2 * i / Board.getBoardSize()) % 2,
                    (i * 2) / Board.getBoardSize());
        }
    }

    private GridPane createLayout() {
        GridPane gridPane = new GridPane();

        for(int n = 0; n < Board.getBoardSize(); n++) {
            RowConstraints rowCon = new RowConstraints();
            rowCon.setMinHeight(Board.getSizeSquare());
            rowCon.setValignment(VPos.CENTER);
            ColumnConstraints colCon = new ColumnConstraints();

            colCon.setMinWidth(Board.getSizeSquare());
            colCon.setHalignment(HPos.CENTER);
            gridPane.getRowConstraints().add(rowCon);
            gridPane.getColumnConstraints().add(colCon);
        }

        gridPane.setPrefSize(512, 512);
        gridPane.setMinHeight(512);
        gridPane.setMinWidth(512);

        Board board = new Board();

        refreshPawns(gridPane);

        return gridPane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = refreshScene();

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private Scene refreshScene() {
        BackgroundSize backgroundSize = new BackgroundSize(512, 512,
                false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(Board.getBoard(), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane gridPane = createLayout();
        gridPane.setBackground(background);

        return new Scene(gridPane, 512, 512, Color.TRANSPARENT);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
