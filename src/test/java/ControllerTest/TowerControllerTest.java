package ControllerTest;

import alchemydefense.Controller.TowerController;
import alchemydefense.Model.GameModel;
import alchemydefense.Model.Towers.TowerHierarchy.RedTower;
import alchemydefense.Model.Towers.TowerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TowerControllerTest {
    static GameModel model;
    static TowerController towerController;

    @BeforeAll
    public static void beforeAll() {
        model = new GameModel();
        towerController = new TowerController(model);
    }

    @Test
    public void testIsHoldingTower() {
        towerController = new TowerController(model);
        Assertions.assertFalse(towerController.isHoldingTower());
        towerController.setGreenTowerActive();
        Assertions.assertTrue(towerController.isHoldingTower());
        towerController.setHoldingTowerFalse();
        Assertions.assertFalse(towerController.isHoldingTower());
    }

    @Test
    public void testSetActiveTower() {
        towerController.setBlueTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), TowerType.BLUE);
        towerController.setGreenTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), TowerType.GREEN);
        towerController.setPurpleTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), TowerType.PURPLE);
        towerController.setRedTowerActive();
        Assertions.assertEquals(towerController.getActiveTower(), TowerType.RED);
    }

    @Test
    public void testTowerCreation() {
        towerController.setRedTowerActive();
        towerController.createTower(2,2);
        Assertions.assertEquals(RedTower.class, model.getBoardObjectInCell(new Point(2,2)).getClass());
    }

    @Test
    public void testTowerPressed() {
        model.placeTowerInCell(TowerType.RED, new Point(2,2));
        Assertions.assertFalse(towerController.isTowerPressed());
        towerController.cellPressed(new Point(2,2));
        Assertions.assertTrue(towerController.isTowerPressed());
        towerController.cellPressed(new Point(1,1));
        Assertions.assertFalse(towerController.isTowerPressed());
    }

    @Test
    public void testSellTower() {
        model.placeTowerInCell(TowerType.RED, new Point(2,2));
        Assertions.assertEquals(RedTower.class, model.getBoardObjectInCell(new Point(2,2)).getClass());
        towerController.cellPressed(new Point(2,2));
        towerController.sellTower();
        Assertions.assertNull(model.getBoardObjectInCell(new Point(2,2)));
    }
}
