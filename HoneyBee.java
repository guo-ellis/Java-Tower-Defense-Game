package assignment1;

public abstract class HoneyBee extends Insect {
    private int food_cost;
    public static double HIVE_DMG_REDUCTION;

    public HoneyBee(Tile t, int hp, int f_cost) {
        super(t, hp);
        this.food_cost = f_cost;
    }

    public int getCost() {
        return food_cost;
    }
    
    // idk
    public void takeDamage(int dmg) {
        Tile current = getPosition();
        if (current.isHive()) {
            int reducedDamage = (int) (dmg * (1 - HIVE_DMG_REDUCTION));
            super.takeDamage(reducedDamage);
        } else {
            super.takeDamage(dmg);
        }
    }

}
