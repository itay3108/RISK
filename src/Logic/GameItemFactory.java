package Logic;

public class GameItemFactory {
    private static GameItemFactory instance;

    private GameItemFactory() {
        // Private constructor to prevent instantiation
    }

    public static GameItemFactory getInstance() {
        if (instance == null) {
            instance = new GameItemFactory();
        }
        return instance;
    }

    public GameItem createItem(ItemType itemType, String name) {
        try {
            return itemType.getItemClass().getConstructor(String.class).newInstance(name);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to create item for type: " + itemType, e);
        }
    }
}
