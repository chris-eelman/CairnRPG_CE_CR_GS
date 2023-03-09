import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    void testFightHit() {
        Hero Luke1 = new Hero(100, 10, true);
        Enemy trooper1 = new Enemy(100, 10, true);

        double initialHeroHealth = Luke1.getHealth();
        boolean attackHit = false;
        for (int i = 0; i < 10; i++) { // run the test 10 times to increase chance of attack hitting
            attackHit = trooper1.fight(Luke1);
            if (attackHit) { // if the attack hits, break out of the loop
                break;
            }
        }
        if (attackHit) { // if the attack hit, check that the hero's health has decreased by the expected amount
            assertEquals(initialHeroHealth - trooper1.getAttackPower(), Luke1.getHealth(), 0.01);
        } else { // if the attack missed every time, fail the test
            fail("Attack missed every time.");
        }
    }

    @Test
    void testMagicAttack() {
        Hero Luke1 = new Hero(100, 10, true);
        Enemy trooper1 = new Enemy(100, 10, true);

        double initialHeroHealth = Luke1.getHealth();
        boolean attackHit = false;
        for (int i = 0; i < 50; i++) { // run the test 10 times to increase chance of attack hitting
            attackHit = trooper1.fight(Luke1);
            if (attackHit && (Luke1.getHealth() == initialHeroHealth - trooper1.getAttackPower() * 2)) { // if the attack hits, break out of the loop
                break;
            }else{
                Luke1.setHealth(100);
            }
        }
        if (attackHit) { // if the attack hit, check that the hero's health has decreased by the expected amount
            assertEquals(initialHeroHealth - trooper1.getAttackPower() * 2, Luke1.getHealth(), 0.01);
        } else { // if the attack missed every time, fail the test
            fail("No attacks were special double attacks, run test again ");
        }
    }

    @Test
    void testFightAttackMiss() {
        Hero Luke1 = new Hero(100, 10, true);
        Enemy trooper1 = new Enemy(100, 10, true);

        double initialHeroHealth = Luke1.getHealth();
        boolean attackHit = false;
        for (int i = 0; i < 50; i++) { // run the test 10 times to increase chance of attack hitting
            attackHit = trooper1.fight(Luke1);
            if (!attackHit) { // if the attack misses, break out of the loop
                break;
            }
        }
        if (!attackHit) { // if the attack hit, check that the hero's health has decreased by the expected amount
            assertEquals(attackHit, false);
        } else { // if the attack missed every time, fail the test
            fail("Attack Hit every time. Run test again to see if it will miss");
        }
    }

    @Test
    void infoTest1() {
        var info1TestEnemy = new Enemy("Stormtrooper", 100, 100, true);
        assertEquals("Enemy Name: Stormtrooper, Health: 100.0, Attack Power: 100.0, Is Alive: true, Magic Power: 30",info1TestEnemy.info());
    }

    @Test
    void infoTest2() {
        var info1TestEnemy = new Enemy("Stormtrooper", 50, 50, true);
        assertEquals("Enemy Name: Stormtrooper, Health: 50.0, Attack Power: 50.0, Is Alive: true, Magic Power: 30",info1TestEnemy.info());
    }
}