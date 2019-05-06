package com.checkers.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class None extends Figure{
    private static Image none = new Image("file/none.png");
    private ImageView figure;

    public None() {
        super(ColorType.NONE);
        this.figure = new ImageView(none);
    }

    @Override
    public ImageView getImage() {
        return figure;
    }
}
