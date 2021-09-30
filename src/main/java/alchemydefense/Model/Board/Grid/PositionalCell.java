package alchemydefense.Model.Board.Grid;

import alchemydefense.Model.Board.ConcreteBoard;
import alchemydefense.Model.Board.BoardObject;
import alchemydefense.Model.Foe.Foe;
import alchemydefense.Model.Towers.Tower;

import java.awt.Point;
import java.util.ArrayList;


public class PositionalCell {
    final Point cellCoordinate;
    private boolean isOccupied = false;
    private Tower tower;
    private Foe foe;
    public boolean hasBeenUpdated = false;

    public PositionalCell(int x, int y){
        cellCoordinate = new Point(x,y);
    }

    public void setHasBeenUpdated(boolean b){
        hasBeenUpdated = b;
    }

    public boolean hasFoe(){
        return (foe != null);
    }

    public Foe getFoe(){
        return foe;
    }

    public PositionalCell(Point point){
        cellCoordinate = point;
    }

    public void addTower(Tower tower) {
        if(isOccupied) return;
        isOccupied = true;
        this.tower = tower;
    }

    public Point getCellCoordinate(){
        return cellCoordinate;
    }

    public BoardObject getBoardObject(){
        if(tower != null){
            return tower;
        }
        else if(foe != null){
            return foe;
        }
        return null;
    }

    public Tower getTower(){
        return tower;
    }

    public void insertTower(Tower tower){
        this.tower  = tower;
    }


    public boolean isOccupied() {
        return isOccupied;
    }

    public void clear(){
        boardObject = null;
        foe = null;
        isOccupied = false;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    private Point convertCellPositionToWorld(Point cellPosition){
        int cellWorldWidth = 64;                                    //<<<<<<<< NEEDS REFACTORING
        int cellWorldHeight = 64;

        return new Point(cellWorldWidth * cellCoordinate.x, cellWorldHeight * cellCoordinate.y);
    }

    public ArrayList<PositionalCell> getPositionalCellsWithinRange(ConcreteBoard board){
        ArrayList<PositionalCell> cellsInRange = new ArrayList<>();

        if(tower == null || tower.getRange() == 0){
           return cellsInRange;
        }

        int range = tower.getRange();

        for (int y = -range; y <= range; y++) {
            for (int x = -range; x <= range ; x++) {
                if(x == 0 && y == 0){
                    continue;
                }
                if(Math.abs(x) + Math.abs(y) > range){
                    continue;
                }
                Point currentCellPosition = new Point(cellCoordinate.x + x, cellCoordinate.y + y);
                if(currentCellPosition.x >= 0 && currentCellPosition.x < board.width &&
                currentCellPosition.y >= 0 && currentCellPosition.y < board.height){
                    cellsInRange.add(board.getCell(currentCellPosition));
                }
            }
        }
        return cellsInRange;
    }

    public Foe removeFoe(){
        Foe foe = this.foe;
        clear();
        return foe;
    }

    public void addFoe(Foe foe){
        if(!hasFoe()){
            this.foe = foe;
            boardObject = foe;
        }
    }

    @Override
    public String toString(){
        return "(" + cellCoordinate.x + ", " + cellCoordinate.y + ")";
    }
}
