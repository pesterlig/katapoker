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

    private List<String> listCardCodes(String handStr) {
        List<String> cardCodes = new ArrayList<>();
        List<String> splitHand = Arrays.asList(handStr.split(" "));
        for (int i = 1; i < 6; i++) {
            cardCodes.add(splitHand.get(i));
        }
        return cardCodes;
    }

    private List<Card> parseCardCodes(List<String> cardCodes) {
        List<Card> cards = new ArrayList<>();
        cardCodes.forEach(cardCode -> cards.add(Card.findByCode(cardCode)));
        return cards;
    }

    private List<Card> sortByValuation(List<Card> cards) {
        cards.sort(new SortByRankValue());
        return cards;
    }

    //create a (sorted ascending) hand from a splitInputString

    public List<Card> createSortedAscendingHand(String splitInputString) {
        List<String> cardCodes = listCardCodes(splitInputString);
        List<Card> cards = parseCardCodes(cardCodes);
        return sortByValuation(cards);
    }

    //return a unique decimal value(from Card.getRank.hexVal))for high card comparison

    public int getDecimalHandVal() {
        String stringOfHexVal = getStringOfHexVal(cards);
        return Integer.parseInt(stringOfHexVal, 16);
    }

    private String getStringOfHexVal(List<Card> sortedCards) {
        char[] handCharHexValDescending = new char[5];
        handCharHexValDescending[0] = sortedCards.get(4).getRank().hexVal;
        handCharHexValDescending[1] = sortedCards.get(3).getRank().hexVal;
        handCharHexValDescending[2] = sortedCards.get(2).getRank().hexVal;
        handCharHexValDescending[3] = sortedCards.get(1).getRank().hexVal;
        handCharHexValDescending[4] = sortedCards.get(0).getRank().hexVal;

        return new String(handCharHexValDescending);
    }

    public int findDistinctValues(List<Card> sortedCards) {
        List<Character> distinctHexValues = (sortedCards.stream()
                .map(Card::getRank)
                .distinct()
                .map(rank -> rank.hexVal)
                .collect(Collectors.toList()));
        distinctHexValues.sort(Collections.reverseOrder());
        String stringOfDistinctHexVal = distinctHexValues.stream().map(Object::toString).collect(Collectors.joining());

        return Integer.parseInt(stringOfDistinctHexVal, 16);
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

    public int getPairsCount() {
        return pairsCount;
    }

    public void setPairsCount(int pairsCount) {
        this.pairsCount = pairsCount;
    }
}
