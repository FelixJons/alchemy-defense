package alchemydefense.Model.Interfaces;

/**
 * @author Willem Brahmstaedt
 * Interface for representing health.
 *
 * Date: 2021-09-14
 */

public interface Health {
    boolean takeDamage(int damageCount);

    int getMaxHP();

    int getCurrentHP();

    void setCurrentHP(int hp);
}
