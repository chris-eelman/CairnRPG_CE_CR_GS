import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    public void fight() {
        var hit = new Hero(20.0, 2, true);
        Enemy enemy = new Enemy("Stormtrooper", 30, 20, true);
//        made expected 5 just to test
        assertEquals(5, hit.fight(enemy));

    }

    @Test
    void useItem() {
    }

    @Test
    void levelUp() {
        var level = new Hero(20, 3, true);
        assertEquals(false,level.levelUp());
    }

    @Test
    void addToInventory() {
        var add = new Hero(25, 1, true);
        Item item = new Item("Name", 3);
//        made expected 5 just to test
        assertEquals(5, add.addToInventory(item));
    }

    @Test
    void showInventory() {
        var show = new Hero(22, 2, true);
        //        made expected 5 just to test
        assertEquals(5,show.showInventory());
    }

    @Test
    void Info() {
        var intel = new Hero(20, 2, true);
        assertEquals("Name: Starkiller, Health: 20.0, Attack Power: 2.0, Is Alive: true, Level: 1, Experiance: 0, Money: 0.0, Inventory:", intel.Info());
    }
}
