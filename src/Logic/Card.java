package Logic;

public class Card implements GameItem {
    private String name;
    private CardType cardType; // Assuming there's a CardType enum

    public Card(String name, CardType cardType) {
        this.name = name;
        this.cardType = cardType;
    }

    @Override
    public String getName() {
        return name;
    }

    // Additional getters for cardType and other attributes
}
