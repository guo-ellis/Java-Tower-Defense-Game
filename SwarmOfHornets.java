package assignment1;

public class SwarmOfHornets {
    private Hornet[] hornets;
    private int size;
    public static double QUEEN_BOOST;

    public SwarmOfHornets() {
        this.hornets = new Hornet[0];
        this.size = 0;
    }

    public int sizeOfSwarm() {
        return size;
    }

    public Hornet[] getHornets() {
        Hornet[] temp = new Hornet[size];
        
        for (int i = 0; i < size; i++) {
            temp[i] = hornets[i];
        }
        return temp;
    }

    public Hornet getFirstHornet() {
        if (size <= 0) {
            return null;
        } else {
            return hornets[0];
        }
    }

    public void addHornet(Hornet horn) {

        if (horn.isTheQueen()) {
            for (int i = 0; i < size; i++) {
                hornets[i].regenerateHealth(QUEEN_BOOST);
            }
        }

        if (size >= hornets.length) {
            Hornet[] temp = new Hornet[hornets.length + 1];
            for (int i = 0; i < size; i++) {
                temp[i] = hornets[i];
            }
            temp[size] = horn;
            this.hornets = temp;

        } else {
            hornets[size] = horn;
        }
        size++;
    }

    public boolean removeHornet(Hornet horn) {
        for (int i = 0; i < size; i++) {
            if (hornets[i] == (horn)) {
                for (int x = i + 1; x < size; x++) {
                    hornets[x - 1] = hornets[x];
                }
                hornets[--size] = null;
                return true;
            }
        }
        return false;
    }
}
