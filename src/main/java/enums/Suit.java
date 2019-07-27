package enums;


public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    public final String displayName;

    Suit(String displayName) {
        this.displayName = displayName;
    }

}