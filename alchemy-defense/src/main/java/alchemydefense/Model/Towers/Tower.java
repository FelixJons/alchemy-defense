package alchemydefense.Model.Towers;
import alchemydefense.Model.Interfaces.BoardObject;
import java.awt.*;


/**
 * @author Johan Lindén
 * @date: 2021-09-14
 *
 * A class for an abstract tower. Concrete towers extends this class. Handles
 * all the shared logic of towers. Implements BoardObject.
 *
 *
 *
 */

public abstract class Tower implements BoardObject {

    protected String filePath;

    Point worldPosition;
    Point cellPosition;

    int width;
    int height;
    double range;


    public enum TowerType {

        RED, BLUE, GREEN, PURPLE

    }


    public Tower(Point cellPosition) {
        this.cellPosition = cellPosition;
    }


    @Override
    public Point getWorldPosition() {
        return worldPosition;
    }

    @Override
    public Point getCellPosition() {
        return cellPosition;
    }

    @Override
    public void setCellPosition(Point cell) {
        cellPosition = cell;
    }

    public void update() {
        //TODO
    }

    @Override
    public String getImageFilePath() {
        return filePath;
    }

}