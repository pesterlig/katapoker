package enums;

public enum Card {

    //Clubs

    CLUBS_TWO(Suit.CLUBS, Rank.TWO, "2C"),
    CLUBS_THREE(Suit.CLUBS, Rank.THREE, "3C"),
    CLUBS_FOUR(Suit.CLUBS, Rank.FOUR, "4C"),
    CLUBS_FIVE(Suit.CLUBS, Rank.FIVE, "5C"),
    CLUBS_SIX(Suit.CLUBS, Rank.SIX, "6C"),
    CLUBS_SEVEN(Suit.CLUBS, Rank.SEVEN, "7C"),
    CLUBS_EIGHT(Suit.CLUBS, Rank.EIGHT, "8C"),
    CLUBS_NINE(Suit.CLUBS, Rank.NINE, "9C"),
    CLUBS_TEN(Suit.CLUBS, Rank.TEN, "TC"),
    CLUBS_JACK(Suit.CLUBS, Rank.TEN, "TC"),
    CLUBS_QUEEN(Suit.CLUBS, Rank.QUEEN, "QC"),
    CLUBS_KING(Suit.CLUBS, Rank.KING, "KC"),
    CLUBS_ACE(Suit.CLUBS, Rank.ACE, "AC"),

    //Diamonds

    DIAMONDS_TWO(Suit.DIAMONDS, Rank.TWO, "2D"),
    DIAMONDS_THREE(Suit.DIAMONDS, Rank.THREE, "3D"),
    DIAMONDS_FOUR(Suit.DIAMONDS, Rank.FOUR, "4D"),
    DIAMONDS_FIVE(Suit.DIAMONDS, Rank.FIVE, "5D"),
    DIAMONDS_SIX(Suit.DIAMONDS, Rank.SIX, "6D"),
    DIAMONDS_SEVEN(Suit.DIAMONDS, Rank.SEVEN, "7D"),
    DIAMONDS_EIGHT(Suit.DIAMONDS, Rank.EIGHT, "8D"),
    DIAMONDS_NINE(Suit.DIAMONDS, Rank.NINE, "9D"),
    DIAMONDS_TEN(Suit.DIAMONDS, Rank.TEN, "TD"),
    DIAMONDS_JACK(Suit.DIAMONDS, Rank.TEN, "TD"),
    DIAMONDS_QUEEN(Suit.DIAMONDS, Rank.QUEEN, "QD"),
    DIAMONDS_KING(Suit.DIAMONDS, Rank.KING, "KD"),
    DIAMONDS_ACE(Suit.DIAMONDS, Rank.ACE, "AD"),

    //Hearts

    HEARTS_TWO(Suit.HEARTS, Rank.TWO, "2H"),
    HEARTS_THREE(Suit.HEARTS, Rank.THREE, "3H"),
    HEARTS_FOUR(Suit.HEARTS, Rank.FOUR, "4H"),
    HEARTS_FIVE(Suit.HEARTS, Rank.FIVE, "5H"),
    HEARTS_SIX(Suit.HEARTS, Rank.SIX, "6H"),
    HEARTS_SEVEN(Suit.HEARTS, Rank.SEVEN, "7H"),
    HEARTS_EIGHT(Suit.HEARTS, Rank.EIGHT, "8H"),
    HEARTS_NINE(Suit.HEARTS, Rank.NINE, "9H"),
    HEARTS_TEN(Suit.HEARTS, Rank.TEN, "TH"),
    HEARTS_JACK(Suit.HEARTS, Rank.TEN, "TH"),
    HEARTS_QUEEN(Suit.HEARTS, Rank.QUEEN, "QH"),
    HEARTS_KING(Suit.HEARTS, Rank.KING, "KH"),
    HEARTS_ACE(Suit.HEARTS, Rank.ACE, "AH"),

    //Hearts

    SPADES_TWO(Suit.SPADES, Rank.TWO, "2S"),
    SPADES_THREE(Suit.SPADES, Rank.THREE, "3S"),
    SPADES_FOUR(Suit.SPADES, Rank.FOUR, "4S"),
    SPADES_FIVE(Suit.SPADES, Rank.FIVE, "5S"),
    SPADES_SIX(Suit.SPADES, Rank.SIX, "6S"),
    SPADES_SEVEN(Suit.SPADES, Rank.SEVEN, "7S"),
    SPADES_EIGHT(Suit.SPADES, Rank.EIGHT, "8S"),
    SPADES_NINE(Suit.SPADES, Rank.NINE, "9S"),
    SPADES_TEN(Suit.SPADES, Rank.TEN, "TS"),
    SPADES_JACK(Suit.SPADES, Rank.TEN, "TS"),
    SPADES_QUEEN(Suit.SPADES, Rank.QUEEN, "QS"),
    SPADES_KING(Suit.SPADES, Rank.KING, "KS"),
    SPADES_ACE(Suit.SPADES, Rank.ACE, "AS"),

    ;


    public final Rank rank;
    public final Suit suit;
    public final String cardCode;

    Card(Suit suit, Rank rank, String cardCode) {
        this.suit = suit;
        this.rank = rank;
        this.cardCode = cardCode;
    }


    public static Card findByCode(String cardAbbr) {
        for (Card card : Card.values()) {
            if (card.getCardCode().equals(cardAbbr)) {
                return card;
            }
        }
        return null;
    }

    // Public Methods: Getters

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getCardCode() {
        return cardCode;
    }


}


