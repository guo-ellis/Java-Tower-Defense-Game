package assignment1;

public class FireBee extends HoneyBee {
    private int max_range;
    public static int BASE_HEALTH;
    public static int BASE_COST;

    public FireBee(Tile t, int range) {
        super(t, BASE_HEALTH, BASE_COST);
        this.max_range = range;
    }

    public boolean takeAction() {
        Tile current = this.getPosition();
        
        if (!current.isOnThePath() || current.isHive()) {
            return false;
        }

        boolean hornetfound = false;
        Tile tileInRange = current.towardTheNest();
        for (int i = 0; i < this.max_range; i++) {
            if (tileInRange != null) {
                if (tileInRange.isHive()) {
                    break;
                } else {
                    if (tileInRange.getHornets() != null && tileInRange.getHornets().length > 0) {
                        hornetfound = true;
                        tileInRange.setOnFire();
                    }
                    tileInRange = tileInRange.towardTheNest();
                }
            } else {
                break;
            }
        }
        return hornetfound;

    }



    
}

