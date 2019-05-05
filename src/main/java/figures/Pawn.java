package figures;

import javafx.scene.image.ImageView;

public class Pawn extends Figure {

    private ImageView figure;

    public Pawn(ColorType colorType) {
        super(colorType);
        if(colorType.equals(ColorType.RED)) {
            this.figure = new ImageView(Figure.getRedPawn());
        } else if(colorType.equals(ColorType.BLUE)) {
            this.figure = new ImageView(Figure.getBluePawn());
        }
    }

    public ImageView getFigure() {
        return figure;
    }

    /*private static Image bluePawn = new Image("file/bluePawn.png");
    private static Image redPawn = new Image("file/redPawn.png");

    public Pawn(ColorType colorType) {
        super(FigureType.PAWN, colorType);
    }

    public static Image getBluePawn() {
        return bluePawn;
    }

    public static Image getRedPawn() {
        return redPawn;
    }*/
}
