package assignment1;

public class Tile {
    private int food;
    private boolean bee_built;
    private boolean horn_built;
    private boolean on_path;
    private Tile toward_bee;
    private Tile toward_horn;
    private HoneyBee the_bee;
    private SwarmOfHornets all_horn;

    private boolean on_fire = false;

    public Tile() {
        this.food = 0;
        this.bee_built = false;
        this.horn_built = false;
        this.on_path = false;
        this.toward_bee = null;
        this.toward_horn = null;
        this.the_bee = null;
        this.all_horn = new SwarmOfHornets();

    }

    public Tile(int fd, boolean bbuilt, boolean hbuilt, boolean path, Tile towardb, Tile towardh, HoneyBee b, SwarmOfHornets h) {
        this.food = fd;
        this.bee_built = bbuilt;
        this.horn_built = hbuilt;
        this.on_path = path;
        this.toward_bee = towardb;
        this.toward_horn = towardh;
        this.the_bee = b;
        this.all_horn = h;
        
    }

    public boolean isHive() {
        return bee_built;
    }

    public boolean isNest() {
        return horn_built;
    }

    public void buildHive() {
        this.bee_built = true;
    }

    public void buildNest() {
        this.horn_built = true;
    }

    public boolean isOnThePath() {
        return on_path;
    }

    public Tile towardTheHive() {
        if (!isOnThePath() || this.horn_built) {
            return null;
        } else {
            return toward_bee;
        }
    }

    public Tile towardTheNest() {
        if (!isOnThePath() || this.bee_built) {
            return null;
        } else {
            return toward_horn;
        }
    }

    public void createPath(Tile towardHive, Tile towardNest) {
        String errmsg = "Error: both tiles cannot be null";
        
        if (towardHive == null && towardNest == null) {
            throw new IllegalArgumentException(errmsg);
        }

        if (towardHive == null) {
            if (!this.isHive()) {
                throw new IllegalArgumentException(errmsg);
            }
        }

        if (towardNest == null) {
            if (!this.isNest()) {
                throw new IllegalArgumentException(errmsg);
            }
        }

        this.toward_bee = towardHive;
        this.toward_horn = towardNest;
        this.on_path = true;
    }

    public int collectFood() {
        int temp = this.food;
        this.food = 0;
        return temp;
    }

    public void storeFood(int a) {
        this.food += a;
    }

    public int getNumOfHornets() {
        return this.all_horn.sizeOfSwarm();
    }

    public HoneyBee getBee() {
        return the_bee;
    }

    public Hornet getHornet() {
        Hornet[] swarm = getHornets();
        if (swarm.length > 0) {
            return swarm[0];
        } else {
            return null; 
        }
    }

    public Hornet[] getHornets() {
        return all_horn.getHornets();
    }

    public boolean addInsect(Insect insec) {
        if (insec instanceof Hornet) {
            if (!this.on_path) {
                return false;
            }
            this.all_horn.addHornet((Hornet) insec);
            insec.setPosition(this);
            return true;
        } else if (insec instanceof HoneyBee){
            if (this.the_bee != null || this.horn_built) {
                return false;
            }
            this.the_bee = (HoneyBee) insec;
            insec.setPosition(this);
            return true;
        }
        return false;
    }

    public boolean removeInsect(Insect insec) {

        if (insec instanceof HoneyBee) {
            this.the_bee = null;
            insec.setPosition(null);
            return true;
        }

        if (insec instanceof Hornet) {
            if (all_horn.removeHornet((Hornet) insec)) {
                ((Hornet) insec).setPosition(null);
                return true;
            }
        }
        return false;
    }

    public void setOnFire() {
        this.on_fire = true;
    }

    public boolean isOnFire() {
        return on_fire;
    }

}



