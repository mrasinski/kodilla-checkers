package figures;

import javafx.scene.image.Image;

public class Queen extends Figure{

    private Image blueQueen = new Image("file/blueQueen.png");
    private Image redQueen = new Image("file/redQueen.png");

    public Queen(ColorType colorType) {
        super(FigureType.QUEEN, colorType);
    }

    public Image getBlueQueen() {
        return blueQueen;
    }

    public Image getRedQueen() {
        return redQueen;
    }
}
