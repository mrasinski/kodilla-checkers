package com.checkers.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.checkers.figures.Figure.ColorType.BLANK;
import static com.checkers.figures.Figure.FigureType.NONE;

public class None extends Figure{
    private static Image none = new Image("file/none.png");
    private ImageView figure;

    public None() {
        super(NONE, BLANK);
        this.figure = new ImageView(none);
    }

    @Override
    public ImageView getImage(boolean en) {
        return figure;
    }
}
