package Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
    private List<Territory> territories;
    private Map<Territory, List<Territory>> territoryConnections;

    public GameBoard() {
        this.territories = new ArrayList<>();
        this.territoryConnections = new HashMap<>();
        // Initialize the game board with territories and their connections as needed
    }

    public void addTerritory(Territory territory, List<Territory> connections) {
        territories.add(territory);
        territoryConnections.put(territory, connections);
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public List<Territory> getConnections(Territory territory) {
        return territoryConnections.getOrDefault(territory, new ArrayList<>());
    }
}
