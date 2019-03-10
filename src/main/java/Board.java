import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board extends Application {

    private Image board = new Image("file/checkersBoard23.png");
    private Image bluePawn = new Image("file/bluePawn.png");
    private Image redPawn = new Image("file/redPawn.png");
    private Image blueQueen = new Image("file/blueQueen.png");
    private Image redQueen = new Image("file/redQueen.png");

    private static final int BOARD_SIZE = 8;
    private static final int SIZE_SQUARE = 64;
    private static final int NUM_PIECES = 12;

    private Rectangle[][] createBoard() {
        Rectangle board[][] = new Rectangle[BOARD_SIZE][BOARD_SIZE];

        for(int row = 0; row < BOARD_SIZE; row++){
            for(int col = 0; col < BOARD_SIZE; col++){
                board[row][col] = new Rectangle(SIZE_SQUARE, SIZE_SQUARE, Color.TRANSPARENT);
                board[row][col].setStroke(Color.BLACK);
                board[row][col].setStrokeWidth(1);
            }
        }
        return board;
    }

    private void addPawns(GridPane gridPane) {
        ImageView redPawns[] = new ImageView[NUM_PIECES];
        ImageView bluePawns[] = new ImageView[NUM_PIECES];

        for(int i = 0; i < NUM_PIECES; i++) {
            redPawns[i] = new ImageView(redPawn);
            GridPane.setHalignment(redPawns[i], HPos.CENTER);
            GridPane.setValignment(redPawns[i], VPos.CENTER);
            gridPane.add(redPawns[i],i % (BOARD_SIZE / 2) * 2 + (2 * i / BOARD_SIZE) % 2,
                    BOARD_SIZE - 1 - (i * 2) / BOARD_SIZE);

            bluePawns[i] = new ImageView(bluePawn);
            GridPane.setHalignment(bluePawns[i], HPos.CENTER);
            GridPane.setValignment(bluePawns[i], VPos.CENTER);
            gridPane.add(bluePawns[i], i % (BOARD_SIZE / 2) * 2 + (1 + 2 * i / BOARD_SIZE) % 2,
                    (i * 2) / BOARD_SIZE);
        }
    }

    private GridPane createLayout() {
        GridPane gridPane = new GridPane();

        RowConstraints rowCon = new RowConstraints();
        rowCon.setMaxHeight(SIZE_SQUARE);
        rowCon.setPrefHeight(SIZE_SQUARE);
        rowCon.setMinHeight(SIZE_SQUARE);
        rowCon.setValignment(VPos.CENTER);
        ColumnConstraints colCon = new ColumnConstraints();
        colCon.setMaxWidth(SIZE_SQUARE);
        colCon.setPrefWidth(SIZE_SQUARE);
        colCon.setMinWidth(SIZE_SQUARE);
        colCon.setHalignment(HPos.CENTER);
        gridPane.getRowConstraints().add(rowCon);
        gridPane.getColumnConstraints().add(colCon);

        Rectangle board[][] = createBoard();

        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                gridPane.add(board[row][col], col, row);
            }
        }

        addPawns(gridPane);

        return gridPane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(board.getWidth(), board.getHeight(),
                false, false, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(board, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane gridPane = createLayout();
        gridPane.setBackground(background);

        Scene scene = new Scene(gridPane, 513, 513, Color.TRANSPARENT);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
