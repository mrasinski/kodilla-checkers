package com.checkers.figures;

import javafx.scene.image.ImageView;

public class Figure {

    private ColorType colorType;
    private boolean marked;

    Figure(ColorType colorType) {
        this.colorType = colorType;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public ImageView getImage() {
        return null;
    }
}
