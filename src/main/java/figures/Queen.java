package figures;

import javafx.scene.image.ImageView;

public class Queen extends Figure{

    private ImageView figure;

    public Queen(ColorType colorType) {
        super(colorType);
        if(colorType.equals(ColorType.RED)) {
            this.figure = new ImageView(Figure.getRedQueen());
        } else if(colorType.equals(ColorType.BLUE)) {
            this.figure = new ImageView(Figure.getBlueQueen());
        }
    }

    public ImageView getFigure() {
        return figure;
    }

    /*private Image blueQueen = new Image("file/blueQueen.png");
    private Image redQueen = new Image("file/redQueen.png");

    public Queen(ColorType colorType) {
        super(FigureType.QUEEN, colorType);
    }

    public Image getBlueQueen() {
        return blueQueen;
    }

    public Image getRedQueen() {
        return redQueen;
    }*/
}
