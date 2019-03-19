package figures;

import javafx.scene.image.Image;

public class Pawn extends Figure {

    private static Image bluePawn = new Image("file/bluePawn.png");
    private static Image redPawn = new Image("file/redPawn.png");

    public Pawn(ColorType colorType) {
        super(FigureType.PAWN, colorType);
    }

    public static Image getBluePawn() {
        return bluePawn;
    }

    public static Image getRedPawn() {
        return redPawn;
    }
}
