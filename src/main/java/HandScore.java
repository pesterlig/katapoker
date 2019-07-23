import java.util.*;

public class HandScore {

    private int score;
    private boolean isFlush;
    private boolean isStraight;
    private boolean isStraightFlush;
    private boolean isFourOfAKind;
    private boolean isFullHouse;
    private boolean isThreeOfAKind;
    private boolean isTwoPairs;
    private boolean isOnePair;

    public HandScore(int score, boolean isFlush, boolean isStraight, boolean isStraightFlush,
                     boolean isFourOfAKind, boolean isFullHouse, boolean isThreeOfAKind,
                     boolean isTwoPairs, boolean isOnePair) {
        this.score = score;
        this.isFlush = isFlush;
        this.isStraight = isStraight;
        this.isStraightFlush = isStraightFlush;
        this.isFourOfAKind = isFourOfAKind;
        this.isFullHouse = isFullHouse;
        this.isThreeOfAKind = isThreeOfAKind;
        this.isTwoPairs = isTwoPairs;
        this.isOnePair = isOnePair;
    }


    public List<Card> checkForFlush(List<Card> cards) {
        List<Card> flush = new ArrayList<Card>();

        int count = 0;

        for (int i = 0; i < 4; i++) {

            if (cards.get(i).getSuitIndicator().equals(cards.get(i + 1).getSuitIndicator())) {
                flush.add(cards.get(i));
                count++;
                System.out.println("Count from the method is " + count);
            }
        }

        if (count == 4) {
            flush.add(cards.get(4));
            setScore(50000 + ((flush.get(4).getValuation() +
                    flush.get(3).getValuation() +
                    flush.get(2).getValuation() +
                    flush.get(1).getValuation() +
                    flush.get(0).getValuation())
                    * 100));//todo: refactor this dorkage into a lambda expression
            setFlush(true);
        } else {
            flush.clear();
            setScore(0);
        }

        System.out.println("Count from outside the for loop of the method is " + count);
        return flush;
    }

    public List<Card> checkForStraight(List<Card> cards) {
        List<Card> straight = new ArrayList<Card>();
        int count = 0;

        for (int i = 0; i < 4; i++) {

            int elementValue = cards.get(i).getValuation();
            int nextElementValue = cards.get(i + 1).getValuation();

            if (elementValue + 1 == nextElementValue) {
                straight.add(cards.get(i));
                count++;
                System.out.println("Count from the straight method is " + count);
            }
        }

        if (count == 4) {
            straight.add(cards.get(4));
            setScore(40000 + (straight.get(4).getValuation() * 100));
            setStraight(true);
        } else {
            straight.clear();
            setScore(0);
        }

        System.out.println("Count from outside the for loop of the straight method is " + count);
        return straight;
    }

    public List<Card> checkForStraightFlush(List<Card> cards) {
        checkForFlush(cards);
        checkForStraight(cards);
        List<Card> straightFlush = new ArrayList<Card>();
        if ((isStraight == true) && (isFlush == true)) {
            straightFlush = checkForStraight(cards);
            setStraightFlush(true);
            setScore(90000 + (straightFlush.get(4).getValuation() * 100));
        }
        return straightFlush;
    }

    /*public List<Card> checkForFourOfAKind(List<Card> cards) {
        List<Card> fourOfAKind = new ArrayList<Card>();
        int count = 0;

        for (int i = 0; i < 4; i++) {

            int elementValue = cards.get(i).getValuation();
            int nextElementValue = cards.get(i + 1).getValuation();

            if (elementValue == nextElementValue) {
                fourOfAKind.add(cards.get(i));
                cards.remove(i)
                count++;
                System.out.println("Count from the straight method is " + count);
            }
        }

        if (count == 4) {
            straight.add(cards.get(4));
            setScore(40000 + (straight.get(4).getValuation() * 100));
            setStraight(true);
        } else {
            straight.clear();
            setScore(0);
        }

        System.out.println("Count from outside the for loop of the straight method is " + count);
        return straight;
    }*/

    public Map<Integer, Integer> findPairsEtc(List<Card> inputCards){

        Map <Integer,Integer> cardMatchCounter = new HashMap<>();
        /*
        iterate through the inputCards ArrayList and build HashMap
        Key is the card valuation of each element, and Value(mapValue) is
        the number of duplicate card valuations there are
        */
        for(Card card : inputCards) {
            Integer cardValuation = card.getValuation();
            Integer mapValue = cardMatchCounter.get(cardValuation);
            if(cardMatchCounter.get(cardValuation)==null){
                cardMatchCounter.put(cardValuation, 1);//if map does not contain key
                //put element as Key, 1 as Value

            }else{
                mapValue = mapValue + 1;
                cardMatchCounter.put(cardValuation,mapValue);//increment the counter
                //if the element already exists in the map
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = cardMatchCounter.entrySet();
        cardMatchCounter.entrySet().stream()
                .filter((map -> map.getValue()>1))
                .forEach(map -> System.out.println(map.getKey()+ " => " + map.getValue()));
            return cardMatchCounter;
        }





   /* private static void findDuplicatesUsingJava8(int[] inputArray)
    {
        Set<Integer> uniqueElements = new HashSet<>();

        Set<Integer> duplicateElements =  Arrays.stream(inputArray)
                .filter(i -> !uniqueElements.add(i))
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(duplicateElements);
    }*/




    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }

    /*
    notes on scoring
    flush scores 50,000 + 100*sum of all card values
    straight scores 40,000 + 100*highest card
    */
    public boolean isFlush() {
        return isFlush;
    }

    public void setFlush(boolean flush) {
        isFlush = flush;
    }

    public boolean isStraight() {
        return isStraight;
    }

    public void setStraight(boolean straight) {
        isStraight = straight;
    }

    public boolean isStraightFlush() {
        return isStraightFlush;
    }

    public void setStraightFlush(boolean straightFlush) {
        isStraightFlush = straightFlush;
    }

    public boolean isFourOfAKind() {
        return isFourOfAKind;
    }

    public void setFourOfAKind(boolean fourOfAKind) {
        isFourOfAKind = fourOfAKind;
    }

    public boolean isFullHouse() {
        return isFullHouse;
    }

    public void setFullHouse(boolean fullHouse) {
        isFullHouse = fullHouse;
    }

    public boolean isThreeOfAKind() {
        return isThreeOfAKind;
    }

    public void setThreeOfAKind(boolean threeOfAKind) {
        isThreeOfAKind = threeOfAKind;
    }

    public boolean isTwoPairs() {
        return isTwoPairs;
    }

    public void setTwoPairs(boolean twoPairs) {
        isTwoPairs = twoPairs;
    }

    public boolean isOnePair() {
        return isOnePair;
    }

    public void setOnePair(boolean onePair) {
        isOnePair = onePair;
    }
}
