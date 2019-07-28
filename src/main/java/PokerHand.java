import enums.Card;
import enums.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class PokerHand {

    private final String handName;
    private ArrayList<Card> cards;
    private Integer score;
    private String pokerHandType;

    private int valueOfFourOfAKind;
    private int valueOfThreeOfAKind;
    private int valueOfFullHouse;

    private int pairsCount;

    private Set<Integer> valuesOfPairs;

    private Map<Rank, Integer> cardMatchCounter;

    public PokerHand(String handName) {
        this.handName = handName;
        this.valuesOfPairs = new HashSet<>();
        this.cardMatchCounter = new HashMap<>();
    }

    public void setCardMatchCounter(Map<Rank, Integer> cardMatchCounter) {
        this.cardMatchCounter = cardMatchCounter;
    }

    public Map<Rank, Integer> getCardMatchCounter() {
        return cardMatchCounter;
    }

    public List<String> listCardCodes(String handStr) {

        List<String> cardCodes = new ArrayList<>();
        List<String> splitHand = Arrays.asList(handStr.split(" "));
        for (int i = 1; i < 6; i++) {
            cardCodes.add(splitHand.get(i));
        }
        return cardCodes;
    }

    public List<Card> parseCardCodes(List<String> cardCodes) {
        List<Card> cards = new ArrayList<>();

        cardCodes.forEach(cardCode -> {
            cards.add(Card.findByCode(cardCode));
        });

        return cards;
    }

    public List<Card> sortByValuation(List<Card> cards) {
        Collections.sort(cards, new SortByRankValue());

        return cards;
    }

    //method to create a (sorted ascending) hand from a splitInputString

    public List<Card> createSortedAscendingHand(String splitInputString) {
        List<String> cardCodes = listCardCodes(splitInputString);
        List<Card> cards = parseCardCodes(cardCodes);
        List<Card> sortedCards = sortByValuation(cards);
        return sortedCards;
    }


    //method to return a unique decimal value (from Card.getRank.hexVal))
    // for a given hand of cards for high card comparison


    public int getDecimalHandVal() {
        String stringOfHexVal = getStringOfHexVal(cards);
        int hexStringToDecimal = Integer.parseInt(stringOfHexVal, 16);
        return hexStringToDecimal;
    }

    public String getStringOfHexVal(List<Card> sortedCards) {
        char[] handCharHexValDescending = new char[5];
        handCharHexValDescending[0] = sortedCards.get(4).getRank().hexVal;
        handCharHexValDescending[1] = sortedCards.get(3).getRank().hexVal;
        handCharHexValDescending[2] = sortedCards.get(2).getRank().hexVal;
        handCharHexValDescending[3] = sortedCards.get(1).getRank().hexVal;
        handCharHexValDescending[4] = sortedCards.get(0).getRank().hexVal;

        String stringOfHexVal = new String(handCharHexValDescending);
        return stringOfHexVal;
    }

    // todo remove unused method
    /*public String addOxToStringOfHexVal(String stringOfHexVal) {
        String OxHexVal = "0x";
        OxHexVal = OxHexVal.concat(stringOfHexVal);
        return OxHexVal;
    }*/

    public int findDistinctValues(List<Card> sortedCards) {
        List<Character> distinctHexValues = new ArrayList<>();

        distinctHexValues = (sortedCards.stream()
                .map(Card::getRank)
                .distinct()
                .map(rank -> rank.hexVal)
                .collect(Collectors.toList()));
        Collections.sort(distinctHexValues, Collections.reverseOrder());
        String stringOfDistinctHexVal = distinctHexValues.stream().map(e -> e.toString()).collect(Collectors.joining());

        int decimalHighCardBonus = Integer.parseInt(stringOfDistinctHexVal, 16);
        return decimalHighCardBonus;

    }


    public String getHandName() {
        return handName;
    }


    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPokerHandType() {
        return pokerHandType;
    }

    public void setPokerHandType(String pokerHandType) {
        this.pokerHandType = pokerHandType;
    }

    public int getValueOfFourOfAKind() {
        return valueOfFourOfAKind;
    }

    public void setValueOfFourOfAKind(int valueOfFourOfAKind) {
        this.valueOfFourOfAKind = valueOfFourOfAKind;
    }

    public int getValueOfThreeOfAKind() {
        return valueOfThreeOfAKind;
    }

    public void setValueOfThreeOfAKind(int valueOfThreeOfAKind) {
        this.valueOfThreeOfAKind = valueOfThreeOfAKind;
    }


    public Set<Integer> getValuesOfPairs() {
        return valuesOfPairs;
    }

    // todo why is this not used?
    public void setValuesOfPairs(Set<Integer> valuesOfPairs) {
        this.valuesOfPairs = valuesOfPairs;
    }

    public int getPairsCount() {
        return pairsCount;
    }

    public void setPairsCount(int pairsCount) {
        this.pairsCount = pairsCount;
    }
}
