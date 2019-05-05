package figures;

import javafx.scene.image.ImageView;

public class None extends Figure{

    private ImageView figure;

    public None() {
        super(ColorType.NONE);
        this.figure = new ImageView(Figure.getNone());
    }

    public ImageView getFigure() {
        return figure;
    }
}
