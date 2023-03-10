public class Enemy extends Character {
    private int magicPower=30;


    public Enemy (double health, double attackPower, boolean isAlive) {
        super("Stormtrooper",health, attackPower, isAlive);
    }

    public Enemy (String name, double health, double attackPower, boolean isAlive) {
        super(name, health, attackPower, isAlive);
    }

    //Getters and Setters
    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public boolean fight(Hero hero) {
        double attackPower;
        String attackType;
        double randomValue = Math.random();
        if (randomValue < 0.2 && magicPower >= 30) {
            // 20% chance of using magical attack
            attackPower = this.getAttackPower() * 2;
            attackType = "Flame Thrower";
        } else {
            // 80% chance of using basic attack
            attackPower = this.getAttackPower();
            attackType = "Basic Blaster";
        }

        // Determine whether the attack misses the enemy
        double hitChance = 0.9; // assume 90% hit chance by default

        double hitRoll = Math.random();
        boolean hitSuccess = hitRoll < hitChance;

        // Calculate the damage and print a message to the console
        double damage = 0;
        if (hitSuccess) {
            damage = attackPower;
            if (damage < 0) {
                damage = 0; // damage cannot be negative
            }
            hero.setHealth(hero.getHealth() - damage); //take away health from the hero
            System.out.println("The Stormtrooper hit " + hero.getName() + " with a " + attackType + " attack, dealing " + damage + " damage.");
            if(hero.getHealth() <= 0){
                hero.setAlive(false);
                System.out.println(name + " ****KILLED**** " + hero.getName() + " with a fatal blow!");
            }
        } else {
            System.out.println("The Stormtrooper missed " + hero.getName() + ".");
        }

        // Return true if the attack landed, false otherwise
        return hitSuccess;
    }

    public String info() {
    //code to display the Enemy's statistics
        return "Enemy Name: " + name + ", Health: " + health + ", Attack Power: " + attackPower + ", Is Alive: " + isAlive +", Magic Power: " + magicPower;
    }
}

