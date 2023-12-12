package Logic;

import java.util.List;

public class Territory implements GameItem {
    private String name;
    private Player owner;
    private int armies;
    private List<Territory> neighbors;

    public Territory(String name) {
        this.name = name;
        // Initialize other attributes as needed
    }

    @Override
    public String getName() {
        return name;
    }

    // Additional getters and setters for owner, armies, neighbors, etc.
}