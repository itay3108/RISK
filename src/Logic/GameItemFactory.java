package Logic;

public class GameItemFactory {
    private static GameItemFactory instance;

    private GameItemFactory() {
        // Private constructor to prevent instantiation
    }

    public static GameItemFactory getInstance() {
        if (instance == null) instance = new GameItemFactory();
        return instance;
    }

    public static GameItem createGameItem(String name, ItemType itemType, Object additionalInfo) {
        GameItem gameItem = switch (itemType) {
            case CARD -> createCard(name, (CardType) additionalInfo);
            case TERRITORY -> createTerritory(name, (Continent) additionalInfo);
        };
        return gameItem;
    }

    private static Card createCard(String name, CardType cardType) {
        return new Card(name, cardType);
    }

    private static Territory createTerritory(String name, Continent continent) {
        return new Territory(name, continent);
    }
}
