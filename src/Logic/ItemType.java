package Logic;

public enum ItemType {
    TERRITORY(Territory.class),
    CARD(Card.class);

    private final Class<? extends GameItem> itemClass;

    ItemType(Class<? extends GameItem> itemClass) {
        this.itemClass = itemClass;
    }

    public Class<? extends GameItem> getItemClass() {
        return itemClass;
    }
}
