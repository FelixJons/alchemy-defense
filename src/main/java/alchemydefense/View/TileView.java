package alchemydefense.View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class TileView extends StackPane {
    final int tileSize = 64;
    final String defaultBackground = "available-path.png";
    List<ImageView> temporaryImages = new ArrayList<>();
    //List<ImageView> fixedImages = new ArrayList<>();

    public TileView(int startX, int startY, int width, int height) {
        setPrefSize(width, height);
        setLayoutX(startX);
        setLayoutY(startY);

        setDefaultBackground();
    }

    private void setDefaultBackground() {
        BackgroundImage backgroundImage = new BackgroundImage(new Image(defaultBackground, 64, 64, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
    }

    public void addImage(String filepath) {
        ImageView i = new ImageView(new Image(filepath));
        i.setFitHeight(64);
        i.setFitWidth(64);
        temporaryImages.add(i);
        this.getChildren().add(i);
    }

    public void clearImage() {
        getChildren().clear();
    }
}
