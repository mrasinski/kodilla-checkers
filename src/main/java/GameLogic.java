import figures.Figure;
import figures.None;

public class GameLogic {

    private Board board;

    public GameLogic(Board board) {
        this.board = board;
    }

    public void move(int x1, int y1, int x2, int y2) {
        Figure figure = board.getFigure(x1, y1);
        board.setFigure(x2, y2, figure);
        board.setFigure(x1, y1, new None());
    }
}
