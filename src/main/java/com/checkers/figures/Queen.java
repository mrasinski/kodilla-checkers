package com.checkers.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Figure{
    private static Image blueQueen = new Image("file/blueQueen.png");
    private static Image redQueen = new Image("file/redQueen.png");
    private ImageView figure;

    public Queen(ColorType colorType) {
        super(colorType);
        if(colorType.equals(ColorType.RED)) {
            this.figure = new ImageView(redQueen);
        } else if(colorType.equals(ColorType.BLUE)) {
            this.figure = new ImageView(blueQueen);
        }
    }

    @Override
    public ImageView getImage() {
        return figure;
    }
}
