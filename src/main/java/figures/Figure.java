package figures;

import javafx.scene.image.Image;

public class Figure {

    private ColorType colorType;
    private static Image bluePawn = new Image("file/bluePawn.png");
    private static Image redPawn = new Image("file/redPawn.png");
    private static Image blueQueen = new Image("file/blueQueen.png");
    private static Image redQueen = new Image("file/redQueen.png");
    private static Image none = new Image("file/none.png");
    private boolean marked;

    public Figure(ColorType colorType) {
        this.colorType = colorType;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public static Image getBluePawn() {
        return bluePawn;
    }

    public static Image getRedPawn() {
        return redPawn;
    }

    public static Image getBlueQueen() {
        return blueQueen;
    }

    public static Image getRedQueen() {
        return redQueen;
    }

    public static Image getNone() {
        return none;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
