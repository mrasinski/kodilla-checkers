package com.checkers.figures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.checkers.figures.Figure.ColorType.*;
import static com.checkers.figures.Figure.FigureType.QUEEN;

public class Queen extends Figure{

    private static Image blueQueen = new Image("file/blueQueen.png");
    private static Image redQueen = new Image("file/redQueen.png");
    private static Image blueQueenClicked = new Image("file/blueQueenClicked.png");
    private static Image redQueenClicked = new Image("file/redQueenClicked.png");
    private ImageView figure;

    public Queen(ColorType colorType) {
        super(QUEEN, colorType);
        if(colorType.equals(RED)) {
            this.figure = new ImageView(redQueen);
        } else if(colorType.equals(BLUE)) {
            this.figure = new ImageView(blueQueen);
        }
    }

    @Override
    public ImageView getImage(boolean en) {
        setMarked(en);
        if (isMarked()) {
            figure = (getColorType() == RED) ?
                new ImageView(redQueenClicked) : new ImageView(blueQueenClicked);
        } else {
            figure = (getColorType() == RED) ?
                new ImageView(redQueen) : new ImageView(blueQueen);
        }
        return figure;
    }
}
