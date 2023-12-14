package Logic;


public class Territory implements GameItem {
    private final String name;
    private Player owner;
    private int armies;
    private final Continent continent;

    public Territory(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    @Override
    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
        owner.addOwnedTerritory(this);
    }

    public int getArmies() {
        return armies;
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }

    public Continent getContinent() {
        return continent;
    }
}