package com.checkers.figures;

import javafx.scene.image.ImageView;

public class Figure {

    public enum FigureType {
        PAWN, QUEEN, NONE
    }
    private FigureType figureType;
    public enum ColorType {
        RED, BLUE, BLANK
    }
    private ColorType colorType;
    private boolean marked;

    Figure(FigureType figureType, ColorType colorType) {
        this.figureType = figureType;
        this.colorType = colorType;
        marked = false;
    }

    public FigureType getFigureType() {
        return figureType;
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

    public ImageView getImage(boolean en) {
        return new ImageView();
    }




}
