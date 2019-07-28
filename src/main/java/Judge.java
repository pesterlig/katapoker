import enums.Card;
import enums.Rank;


import java.lang.reflect.Array;
import java.util.*;

import static enums.Card.*;

public class Judge {


    // todo remove nested word - done
    public void determinePokerHandType(List<PokerHand> hands) {

        hands.forEach((hand) -> {
            checkForFlush(hand);
            checkForStraight(hand); //todo: deal with edge case A,2,3,4,5
            findDuplicatesOfRankValue(hand);
            checkForThreeOfAKind(hand);
            checkForTwoPairs(hand);
            checkForOnlyOnePair(hand);
            checkForHighCard(hand);
        });
    }

    public void displayEachHandOfCards(List<PokerHand> hands){
        hands.forEach((hand) -> {
            displayHands(hand);
        });
    }




    public String compareHandsForWin(List<PokerHand> hands) {

        String winner = "Narp";



        if (hands.get(0).getScore().equals(hands.get(1).getScore())) {
            winner = "tie";
            System.out.println(hands.get(0).getHandName() + " has a " + hands.get(0).getPokerHandType()+ " and is tied with " +
                    hands.get(1).getHandName() + " which has the same value " + hands.get(1).getPokerHandType()  );
        } else if (hands.get(0).getScore() > hands.get(1).getScore()) {
            winner = hands.get(0).getHandName();
            System.out.println(hands.get(0).getHandName() + " wins with " + hands.get(0).getPokerHandType());
        } else {
            System.out.println(hands.get(1).getHandName() + " wins with " + hands.get(1).getPokerHandType());
            winner = hands.get(1).getHandName();
        }

        return winner;
    }

    //



    /*
    public method takes an array of five cards & calls all private
    methods to determine what kind of poker hand it is & changes the state
    of the hand instance accordingly
    */

    private void displayHands(PokerHand pokerHand){
        for (int i = 0; i < 5; i++) {
            System.out.println(
            pokerHand.getCards().get(i).getRank().displayName + " of " +
                    pokerHand.getCards().get(i).getSuit().displayName + ", ");
        }
    }

    private void checkForFlush(PokerHand pokerHand) {
        int count = 0;

        for (int i = 0; i < 4; i++) {

            if (pokerHand.getCards().get(i).getSuit().equals(pokerHand.getCards().get(i + 1).getSuit())) {
                count++;

            }
        }

        if (count == 4) {
            pokerHand.setPokerHandType("FLUSH");
            pokerHand.setScore(0x500000 + (pokerHand.getDecimalHandVal()));
            System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later

        } else {
            pokerHand.setScore(0);

        }
    }

    //checkForStraight covers Straight Flush also
    private void checkForStraight(PokerHand pokerHand) {
        int count = 0;

        for (int i = 0; i < 4; i++) {

            int elementValue = pokerHand.getCards().get(i).getRank().value;
            int nextElementValue = pokerHand.getCards().get(i + 1).getRank().value;

            if (elementValue + 1 == nextElementValue) {
                count++;
            }
            if ((count == 4)| ((count ==3) && (nextElementValue == 14))){
                if (pokerHand.getPokerHandType().equals("FLUSH")) {
                    pokerHand.setPokerHandType("STRAIGHT FLUSH");
                    pokerHand.setScore(0x900000 + (pokerHand.getCards().get(3).getRank().hexVal * 0x64));
                    System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later
                } else {
                    pokerHand.setPokerHandType("STRAIGHT");
                    pokerHand.setScore(0x400000 + (pokerHand.getCards().get(3).getRank().hexVal * 0x64));
                    System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later
                }

            } else {
                pokerHand.setScore(0);
            }

        }
    }

    private void findDuplicatesOfRankValue(PokerHand pokerHand) {
        if (pokerHand.getCardMatchCounter().size() == 0) {
            Map<Rank, Integer> cardMatchCounter = new HashMap<>();
            //Set<Integer> valueOfPairs = new HashSet<>();
        /*
        iterate through the inputCards ArrayList and build HashMap
        Key is the card valuation of each element, and Value(mapValue) is
        the number of duplicate card valuations there are
        */
            for (Card card : pokerHand.getCards()) {
                Integer mapValue = cardMatchCounter.get(card.getRank());
                if (cardMatchCounter.get(card.getRank()) == null) {
                    cardMatchCounter.put(card.getRank(), 1);//if map does not contain key
                    //put element as Key, 1 as Value

                } else {
                    mapValue = mapValue + 1;
                    cardMatchCounter.put(card.getRank(), mapValue);//increment the counter
                    //if the element already exists in the map
                }
            }
            cardMatchCounter.forEach((rank, copies) -> {
                System.out.println(cardMatchCounter.get(rank) + " => " + copies);//todo: get rid of this
                int countPairs = 0;
                if (copies == 4) { // todo make this a switch, don't forget break;s
                    pokerHand.setPokerHandType("FOUR_OF_KIND");
                    pokerHand.setValueOfFourOfAKind(rank.hexVal);
                    pokerHand.setScore(0x800000 + (pokerHand.getValueOfFourOfAKind() * 0x64));
                    System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later

                } else if (copies == 3) {
                    pokerHand.setPokerHandType("THREE_OF_KIND");
                    pokerHand.setValueOfThreeOfAKind(rank.hexVal);

                } else if (copies == 2) {
                    countPairs++;
                    pokerHand.setPairsCount(countPairs);
                    pokerHand.getValuesOfPairs().add(rank.value);
                }

            });
            pokerHand.setCardMatchCounter(cardMatchCounter);
        }
    }


    private void checkForThreeOfAKind(PokerHand pokerHand) {
        findDuplicatesOfRankValue(pokerHand);
        //covers the check for full house as well
        if (pokerHand.getPokerHandType().equals("THREE_OF_KIND")) {
            if (pokerHand.getPairsCount() > 0) {
                pokerHand.setPokerHandType("FULL_HOUSE");
                pokerHand.setScore(0x600000 + (pokerHand.getValueOfThreeOfAKind() * 0x64));
                System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later
            } else {
                pokerHand.setScore(0x300000 + (pokerHand.getValueOfThreeOfAKind() * 0x64));
            }
        }
    }


    private void checkForTwoPairs(PokerHand pokerHand) {
        ArrayList<Integer> pairs = new ArrayList<>(pokerHand.getValuesOfPairs());
        pairs.sort(Integer::compareTo);

        findDuplicatesOfRankValue(pokerHand);

        List<Card> twoPairs = new ArrayList<Card>(); // todo remove unused variable
        if (pairs.size() == 2) {
            pokerHand.setPokerHandType("TWO_PAIRS");
            int decimalBonus = pokerHand.findDistinctValues(pokerHand.getCards());
            pokerHand.setScore((0x200000 + (pairs.get(1) * 0x64)) + decimalBonus);
            System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later
        }

    }

    private void checkForOnlyOnePair(PokerHand pokerHand) {
        ArrayList<Integer> pairs = new ArrayList<>(pokerHand.getValuesOfPairs());
        pairs.sort(Integer::compareTo);

        findDuplicatesOfRankValue(pokerHand);

        List<Card> onePair = new ArrayList<Card>(); // todo remove unused variable
        if (pairs.size() == 1) {
            pokerHand.setPokerHandType("ONE_PAIR");
            int decimalBonus = pokerHand.findDistinctValues(pokerHand.getCards());
            pokerHand.setScore((0x100000 + (pairs.get(0) * 0x64)) + decimalBonus);
            System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later
        }

    }

    private void checkForHighCard(PokerHand pokerHand) {
        if (pokerHand.getPokerHandType().equals("UNDETERMINED")) {
            pokerHand.setPokerHandType("HIGH_CARD");
            pokerHand.setScore(pokerHand.getDecimalHandVal());
            System.out.println(pokerHand.getHandName() + " score: " + pokerHand.getScore());//todo: remove this later
        }
    }


}


