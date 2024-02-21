package assignment1;

public class AngryBee extends HoneyBee{
    
    private int attack_damage;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public AngryBee(Tile t, int dmg) {
        super(t, BASE_HEALTH, BASE_COST);
        this.attack_damage = dmg;
    }

    public boolean takeAction() {
        Tile current = getPosition();
        Tile next = current.towardTheNest();
        if (!current.isOnThePath()) {
            return false;
        }

        Hornet[] swarm = current.getHornets();
        Hornet[] nextSwarm = next.getHornets();
        if (swarm.length == 0) {
            if (nextSwarm.length == 0){
                return false;
            } else {
                Hornet first = nextSwarm[0];
                if (first != null) {
                    first.takeDamage(this.attack_damage);
                }
            }
        } else {
            Hornet first = swarm[0];
            if (first != null) {
                first.takeDamage(this.attack_damage);
            }
        }
        return true;

    }
}

