package Logic;

import java.util.ArrayList;

public class Player {
    private final String name;
    private int armies;
    private final ArrayList<Territory> ownedTerritories;
    // Add other player-related attributes as needed

    public Player(String name) {
        this.name = name;
        this.armies = 33; // place holder
        this.ownedTerritories = new ArrayList<>();
        // Initialize other attributes as needed
    }

    // Additional getters and setters for ownedTerritories and other attributes

    public void addOwnedTerritory(Territory territory) {
        ownedTerritories.add(territory);
    }

    public ArrayList<Territory> getOwnedTerritories() {
        return ownedTerritories;
    }

    public int getTerritoryAmount() {
        return this.ownedTerritories.size();
    }

    public String getName() {
        return this.name;
    }

    public int getArmies() {
        return this.armies;
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }


}
