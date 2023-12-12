package Logic;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Territory> ownedTerritories;
    // Add other player-related attributes as needed

    public Player(String name) {
        this.name = name;
        this.ownedTerritories = new ArrayList<>();
        // Initialize other attributes as needed
    }

    // Additional getters and setters for ownedTerritories and other attributes

    public void addOwnedTerritory(Territory territory) {
        ownedTerritories.add(territory);
    }
}
