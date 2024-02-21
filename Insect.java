package assignment1;

public abstract class Insect {
    
    public Tile insect_tile;
    public int insect_hp;
    
    public Insect(Tile t, int hp) {
        this.insect_tile = t;
        this.insect_hp = hp;
        HoneyBee bee = insect_tile.getBee();
        if (bee == null) {
            if ((this instanceof Hornet) && (!insect_tile.isOnThePath())) {
                throw new IllegalArgumentException("There's already a bee");
            }
            this.insect_tile.addInsect(this);
        } else if (this instanceof HoneyBee){
            throw new IllegalArgumentException("There's already a bee");
        }
    }

    public final Tile getPosition() {
        return insect_tile;
    }

    public final int getHealth() {
        return insect_hp;
    }

    public void setPosition(Tile t) {
        this.insect_tile = t;
    }

    public void takeDamage(int dmg) {
        this.insect_hp -= dmg;
        if (this.insect_hp <= 0) {
            this.insect_hp = 0;
            if (insect_tile != null) {
                insect_tile.removeInsect(this);
            }
        }
    }

    public abstract boolean takeAction();

    public boolean equals(Object obj) {
        Insect insec = (Insect) obj;
        if (this == obj && insect_hp == insec.insect_hp && insect_tile == insec.insect_tile) {
            return true;
        }
        if (!(obj instanceof Insect)) {
            return false;
        }
        return false;
    }

    public void regenerateHealth(double percent) {
        this.insect_hp = (int) ((percent + 1) * this.insect_hp);
    }

}

