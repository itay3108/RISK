package Logic;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private final List<Continent> continents;
    private int[][] adjacencyMatrix;
    private final List<Card> territoryCards;

    public GameBoard() {
        this.continents = new ArrayList<>();
        this.territoryCards = new ArrayList<>();

    }

    public void addContinent(Continent continent) {
        continents.add(continent);
        // Update adjacency matrix if needed
        updateAdjacencyMatrix();
    }

    public void createTerritoryCards() {
        int cardsLeftToMake = 0;
        for (Continent continent : continents)
            cardsLeftToMake += continent.getTerritories().size();

        for (Continent continent : continents) {
            for (Territory territory : continent.getTerritories()) {
                GameItemFactory.getInstance();
                switch (cardsLeftToMake % 3) {
                    case 0:
                        territoryCards.add((Card) GameItemFactory.createGameItem(territory.getName(), ItemType.CARD, CardType.INFANTRY));
                        break;
                    case 1:
                        territoryCards.add((Card) GameItemFactory.createGameItem(territory.getName(), ItemType.CARD, CardType.CAVALRY));
                        break;
                    case 2:
                        territoryCards.add((Card) GameItemFactory.createGameItem(territory.getName(), ItemType.CARD, CardType.ARTILLERY));
                        break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            territoryCards.add((Card) GameItemFactory.createGameItem("", ItemType.CARD, CardType.JOKER));
        }

    }

    private void updateAdjacencyMatrix() {
        // Logic to update the adjacency matrix based on the current state of territories
        // You might iterate through territories and continents to update the matrix
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public int[][] getTerritoryConnections(Territory territory) {

        return adjacencyMatrix;
    }

    public List<Card> getTerritoryCards() {
        return territoryCards;
    }
}