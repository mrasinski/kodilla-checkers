package com.checkers.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.checkers.figures.Figure.ColorType.*;
import static com.checkers.figures.Figure.FigureType.PAWN;

public class Pawn extends Figure {

    private ImageView figure;
    private static Image bluePawn = new Image("file/bluePawn.png");
    private static Image redPawn = new Image("file/redPawn.png");
    private static Image bluePawnClicked = new Image("file/bluePawnClicked.png");
    private static Image redPawnClicked = new Image("file/redPawnClicked.png");

    public Pawn(ColorType colorType) {
        super(PAWN, colorType);
        if(colorType.equals(RED)) {
            this.figure = new ImageView(redPawn);
        } else if(colorType.equals(BLUE)) {
            this.figure = new ImageView(bluePawn);
        }
    }

    @Override
    public ImageView getImage(boolean en) {
        if (isMarked()) {
            figure = (getColorType() == RED) ? new ImageView(redPawnClicked) : new ImageView(bluePawnClicked);
        } else {
            figure = (getColorType() == RED) ? new ImageView(redPawn) : new ImageView(bluePawn);
        }
        return figure;
    }
}
