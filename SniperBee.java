package assignment1;

public class SniperBee extends HoneyBee {
    private int attack_damage;
    private int piercing_power;
    public static int BASE_HEALTH;
    public static int BASE_COST;
    private boolean aimed = false;

    public SniperBee(Tile t, int dmg, int piercing) {
        super(t, BASE_HEALTH, BASE_COST);
        this.attack_damage = dmg;
        this.piercing_power = piercing;
    }

    public boolean takeAction() {
        Tile current = this.getPosition();
        Tile target = current;

        if (!current.isOnThePath()) {
            return false; // Not on the path, can't take action
        }

        if (!aimed) {
            aimed = true;
            return false; // Still aiming, return false
        } else {
            aimed = false; // Reset aim flag

            for (int i = 0; i < 100; i++) {
                if (target.getHornets() != null && target.getHornets().length > 0) {
                    break; // Found a non-empty swarm along the route
                }
                target = target.towardTheNest();
            }
            Hornet[] hornets = target.getHornets();

            int power = Math.min(this.piercing_power, hornets.length); // Determine shooting power

            for (int x = 0; x < power; x++) {
                hornets[x].takeDamage(this.attack_damage); // Shoot at hornets
            }
            return true; // Shot released
        }
    }
}

