import figures.ColorType;
import figures.Figure;
import figures.None;
import figures.Pawn;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.*;

public class Board {

    private static final int BOARD_SIZE = 8;
    private static final int SIZE_SQUARE = 64;
    private static final int NUM_PIECES = 12;
    private static Image board = new Image("file/checkersBoardcienszalinia.png");

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

    public static int getSizeSquare() {
        return SIZE_SQUARE;
    }

    public static int getNumPieces() {
        return NUM_PIECES;
    }

    public static Image getBoard() {
        return board;
    }

    public List<BoardRow> getbR() {
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

    private void refreshPawns(GridPane gridPane) {
        Pawn redPawns[] = new Pawn[Board.getNumPieces()];
        Pawn bluePawns[] = new Pawn[Board.getNumPieces()];

        for(int i = 0; i < Board.getNumPieces(); i++) {
            redPawns[i] = new Pawn(ColorType.RED);
            GridPane.setHalignment(redPawns[i].getFigure(), HPos.CENTER);
            GridPane.setValignment(redPawns[i].getFigure(), VPos.CENTER);
            gridPane.add(redPawns[i].getFigure(),i % (Board.getBoardSize() / 2) * 2 + (2 * i / Board.getBoardSize()) % 2,
                    Board.getBoardSize() - 1 - (i * 2) / Board.getBoardSize());

            bluePawns[i] = new Pawn(ColorType.BLUE);
            GridPane.setHalignment(bluePawns[i].getFigure(), HPos.CENTER);
            GridPane.setValignment(bluePawns[i].getFigure(), VPos.CENTER);
            gridPane.add(bluePawns[i].getFigure(), i % (Board.getBoardSize() / 2) * 2 + (1 + 2 * i / Board.getBoardSize()) % 2,
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

        gridPane.setOnMouseClicked(event -> {
            System.out.println(event);
        });

        return gridPane;
    }

    public Scene refreshScene() {
        BackgroundSize backgroundSize = new BackgroundSize(512, 512,
                false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(Board.getBoard(), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane gridPane = createLayout();
        gridPane.setBackground(background);

        return new Scene(gridPane, 512, 512, Color.TRANSPARENT);
    }
}
