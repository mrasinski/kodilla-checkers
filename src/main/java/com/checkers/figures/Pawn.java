package com.checkers.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Figure {

    private ImageView figure;
    private static Image bluePawn = new Image("file/bluePawn.png");
    private static Image redPawn = new Image("file/redPawn.png");

    public Pawn(ColorType colorType) {
        super(colorType);
        if(colorType.equals(ColorType.RED)) {
            this.figure = new ImageView(redPawn);
        } else if(colorType.equals(ColorType.BLUE)) {
            this.figure = new ImageView(bluePawn);
        }
    }

    @Override
    public ImageView getImage() {
        return figure;
    }
}
