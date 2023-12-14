package Logic;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private final String name;
    private final List<Territory> territories;
    private final int bonusFactor;

    public Continent(String name, int bonusFactor) {
        this.name = name;
        this.territories = new ArrayList<>();
        this.bonusFactor = bonusFactor;
    }

    public String getName() {
        return name;
    }

    public int getBonusFactor() {
        return bonusFactor;
    }

    public void addTerritory(Territory territory) {
        territories.add(territory);
    }

    public List<Territory> getTerritories() {
        return territories;
    }
}
