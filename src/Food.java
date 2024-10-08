public class Food extends Item {
    private int healthGain;
    private boolean poison;

    public Food(int healthGain, boolean poison, String name, String findName) {
        super(name, findName);
        this.healthGain = healthGain;
        this.poison = poison;
    }

    @Override
    public String getFindName() {
        return super.getFindName();
    }

    public boolean getPoison() {
        return poison;
    }

    public int getHealthGain() {
        return healthGain;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
