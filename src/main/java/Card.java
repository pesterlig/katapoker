import java.security.PublicKey;

public enum Card {


    //Clubs

    CLUBS_TWO("2C", 0x2,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_TWO,
            PokerCardStrings.RANK_NAME_TWO
    ),

    CLUBS_THREE("3C", 0x3,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_THREE,
            PokerCardStrings.RANK_NAME_THREE
    ),

    CLUBS_FOUR("4C", 0x4,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_FOUR,
            PokerCardStrings.RANK_NAME_FOUR
    ),

    CLUBS_FIVE("5C", 0x5,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_FIVE,
            PokerCardStrings.RANK_NAME_FIVE
    ),

    CLUBS_SIX("6C", 0x6,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_SIX,
            PokerCardStrings.RANK_NAME_SIX
    ),

    CLUBS_SEVEN("7C", 0x7,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_SEVEN,
            PokerCardStrings.RANK_NAME_SEVEN
    ),

    CLUBS_EIGHT("8C", 0x8,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_EIGHT,
            PokerCardStrings.RANK_NAME_EIGHT
    ),

    CLUBS_NINE("9C", 0x9,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_NINE,
            PokerCardStrings.RANK_NAME_NINE
    ),

    CLUBS_TEN("TC", 0xA,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_TEN,
            PokerCardStrings.RANK_NAME_TEN
    ),

    CLUBS_JACK("JC", 0xB,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_JACK,
            PokerCardStrings.RANK_NAME_JACK
    ),

    CLUBS_QUEEN("QC", 0xC,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_QUEEN,
            PokerCardStrings.RANK_NAME_QUEEN
    ),

    CLUBS_KING("KC", 0xD,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_KING,
            PokerCardStrings.RANK_NAME_KING
    ),

    CLUBS_ACE("AC", 0xE,
            PokerCardStrings.SUIT_INDICATOR_CLUBS,
            PokerCardStrings.SUIT_NAME_CLUBS,
            PokerCardStrings.RANK_INDICATOR_ACE,
            PokerCardStrings.RANK_NAME_ACE
    ),

    //Diamonds

    DIAMONDS_TWO("2D", 0x2,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_TWO,
            PokerCardStrings.RANK_NAME_TWO
    ),

    DIAMONDS_THREE("3D", 0x3,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_THREE,
            PokerCardStrings.RANK_NAME_THREE
    ),

    DIAMONDS_FOUR("4D", 0x4,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_FOUR,
            PokerCardStrings.RANK_NAME_FOUR
    ),

    DIAMONDS_FIVE("5D", 0x5,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_FIVE,
            PokerCardStrings.RANK_NAME_FIVE
    ),

    DIAMONDS_SIX("6D", 0x6,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_SIX,
            PokerCardStrings.RANK_NAME_SIX
    ),

    DIAMONDS_SEVEN("7D", 0x7,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_SEVEN,
            PokerCardStrings.RANK_NAME_SEVEN
    ),

    DIAMONDS_EIGHT("8D", 0x8,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_EIGHT,
            PokerCardStrings.RANK_NAME_EIGHT
    ),

    DIAMONDS_NINE("9D", 0x9,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_NINE,
            PokerCardStrings.RANK_NAME_NINE
    ),

    DIAMONDS_TEN("TD", 0xA,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_TEN,
            PokerCardStrings.RANK_NAME_TEN
    ),

    DIAMONDS_JACK("JD", 0xB,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_JACK,
            PokerCardStrings.RANK_NAME_JACK
    ),

    DIAMONDS_QUEEN("QD", 0xC,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_QUEEN,
            PokerCardStrings.RANK_NAME_QUEEN
    ),

    DIAMONDS_KING("KD", 0xD,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_KING,
            PokerCardStrings.RANK_NAME_KING
    ),

    DIAMONDS_ACE("AD", 0xE,
            PokerCardStrings.SUIT_INDICATOR_DIAMONDS,
            PokerCardStrings.SUIT_NAME_DIAMONDS,
            PokerCardStrings.RANK_INDICATOR_ACE,
            PokerCardStrings.RANK_NAME_ACE
    ),


    //Hearts

    HEARTS_TWO("2H", 0x2,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_TWO,
            PokerCardStrings.RANK_NAME_TWO
    ),

    HEARTS_THREE("3H", 0x3,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_THREE,
            PokerCardStrings.RANK_NAME_THREE
    ),

    HEARTS_FOUR("4H", 0x4,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_FOUR,
            PokerCardStrings.RANK_NAME_FOUR
    ),

    HEARTS_FIVE("5H", 0x5,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_FIVE,
            PokerCardStrings.RANK_NAME_FIVE
    ),

    HEARTS_SIX("6H", 0x6,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_SIX,
            PokerCardStrings.RANK_NAME_SIX
    ),

    HEARTS_SEVEN("7H", 0x7,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_SEVEN,
            PokerCardStrings.RANK_NAME_SEVEN
    ),

    HEARTS_EIGHT("8H", 0x8,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_EIGHT,
            PokerCardStrings.RANK_NAME_EIGHT
    ),

    HEARTS_NINE("9H", 0x9,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_NINE,
            PokerCardStrings.RANK_NAME_NINE
    ),

    HEARTS_TEN("TH", 0xA,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_TEN,
            PokerCardStrings.RANK_NAME_TEN
    ),

    HEARTS_JACK("JH", 0xB,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_JACK,
            PokerCardStrings.RANK_NAME_JACK
    ),

    HEARTS_QUEEN("QH", 0xC,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_QUEEN,
            PokerCardStrings.RANK_NAME_QUEEN
    ),

    HEARTS_KING("KH", 0xD,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_KING,
            PokerCardStrings.RANK_NAME_KING
    ),

    HEARTS_ACE("AH", 0xE,
            PokerCardStrings.SUIT_INDICATOR_HEARTS,
            PokerCardStrings.SUIT_NAME_HEARTS,
            PokerCardStrings.RANK_INDICATOR_ACE,
            PokerCardStrings.RANK_NAME_ACE
    ),

    //Spades

    SPADES_TWO("2S", 0x2,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_TWO,
            PokerCardStrings.RANK_NAME_TWO
    ),

    SPADES_THREE("3S", 0x3,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_THREE,
            PokerCardStrings.RANK_NAME_THREE
    ),

    SPADES_FOUR("4S", 0x4,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_FOUR,
            PokerCardStrings.RANK_NAME_FOUR
    ),

    SPADES_FIVE("5S", 0x5,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_FIVE,
            PokerCardStrings.RANK_NAME_FIVE
    ),

    SPADES_SIX("6S", 0x6,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_SIX,
            PokerCardStrings.RANK_NAME_SIX
    ),

    SPADES_SEVEN("7S", 0x7,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_SEVEN,
            PokerCardStrings.RANK_NAME_SEVEN
    ),

    SPADES_EIGHT("8S", 0x8,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_EIGHT,
            PokerCardStrings.RANK_NAME_EIGHT
    ),

    SPADES_NINE("9S", 0x9,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_NINE,
            PokerCardStrings.RANK_NAME_NINE
    ),

    SPADES_TEN("TS", 0xA,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_TEN,
            PokerCardStrings.RANK_NAME_TEN
    ),

    SPADES_JACK("JS", 0xB,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_JACK,
            PokerCardStrings.RANK_NAME_JACK
    ),

    SPADES_QUEEN("QS", 0xC,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_QUEEN,
            PokerCardStrings.RANK_NAME_QUEEN
    ),

    SPADES_KING("KS", 0xD,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_KING,
            PokerCardStrings.RANK_NAME_KING
    ),

    SPADES_ACE("AS", 0xE,
            PokerCardStrings.SUIT_INDICATOR_SPADES,
            PokerCardStrings.SUIT_NAME_SPADES,
            PokerCardStrings.RANK_INDICATOR_ACE,
            PokerCardStrings.RANK_NAME_ACE
    ),

    NULL_CARD("  ", 0, "null", "null",
            "null", "null");


    //private fields
    private final String cardCode;
    private final int valuation;

    private final String suitIndicator;
    private final String suitName;
    private final String rankIndicator;
    private final String rankName;

    //constructor

    Card(String cardCode, int valuation, String suitIndicator,
         String suitName, String rankIndicator, String rankName) {
        this.cardCode = cardCode;
        this.valuation = valuation;
        this.suitIndicator = suitIndicator;
        this.suitName = suitName;
        this.rankIndicator = rankIndicator;
        this.rankName = rankName;
    }

    // Public Methods: Getters

    public String getCardCode() {
        return cardCode;
    }

    public int getValuation() {
        return valuation;
    }

    public String getSuitIndicator() {
        return suitIndicator;
    }

    public String getSuitName() {
        return suitName;
    }

    public String getRankIndicator() {
        return rankIndicator;
    }

    public String getRankName() {
        return rankName;
    }

    public static Card findByCode(String cardAbbr) {
        for (Card card : Card.values()) {
            if(card.getCardCode().equals(cardAbbr)){
                return card;
            }
        }
      return null;
    }

    @Override
    public String toString(){
        return this.getRankName()+" of "+ this.getSuitName();
    }


    // Valuation - Convert Integer.toHexString() at Score calculation time
    // or make it a field in the enum - valuation of 14 = hexVal 0xE
}


