package assignment1;

public class Hornet extends Insect {
    private int attack_damage;
    public static int BASE_FIRE_DMG;
    private boolean is_queen = false;
    private static int queen_count = 0;

    public Hornet(Tile t, int hp, int dmg) {
        super(t, hp);
        this.attack_damage = dmg;
    }

    public boolean takeAction() {

        if (isTheQueen()) {
            if (!theAction()) {
                return false;
            }
            return theAction();
        } else {
            return theAction();
        }

    }

    private boolean theAction() {
        Tile current = this.getPosition();
        Tile next = current.towardTheHive();
        HoneyBee currentBee = current.getBee();
        if (current.isOnFire()) {
            this.takeDamage(BASE_FIRE_DMG);
            if (this.getHealth() <= 0) {
                return false;
            }
        }

        if (currentBee != null) {
            currentBee.takeDamage(this.attack_damage);
        } else {
            if (next != null) {
                HoneyBee nextBee = next.getBee();
                current.removeInsect(this);
                next.addInsect(this);
                if (nextBee != null) {
                    nextBee.takeDamage(this.attack_damage);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        Hornet horn = (Hornet) obj;
        if (this == obj && attack_damage == horn.attack_damage) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return false;

    }

    public boolean isTheQueen() {
        return is_queen;
    }

    public void promote() {
        if (queen_count == 0) {
            this.is_queen = true;
            queen_count++;
        }
    }



}
