import enums.Card;
import enums.Rank;
import java.util.*;

public class Judge {

    public void determinePokerHandType(List<PokerHand> hands) {

        hands.forEach((hand) -> {
            checkForFlush(hand);
            checkForStraight(hand);
            findDuplicatesOfRankValue(hand);
            checkForThreeOfAKind(hand);
            checkForTwoPairs(hand);
            checkForOnlyOnePair(hand);
            checkForHighCard(hand);
        });
    }

    public void displayEachHandOfCards(List<PokerHand> hands) {
        hands.forEach(this::displayHands);
    }

    public String compareHandsForWin(List<PokerHand> hands) {

        PokerHand blackHand = hands.get(0);
        PokerHand whiteHand = hands.get(1);
        String winner;

        if (blackHand.getScore().equals(whiteHand.getScore())) {
            winner = "tie";
            System.out.println(blackHand.getHandName() + " has a " + blackHand.getPokerHandType() + " and is tied with " +
                    whiteHand.getHandName() + " which has the same value " + whiteHand.getPokerHandType());
        } else if (blackHand.getScore() > whiteHand.getScore()) {
            winner = blackHand.getHandName();
            System.out.println(blackHand.getHandName() + " wins with " + blackHand.getPokerHandType());
        } else {
            winner = whiteHand.getHandName();
            System.out.println(whiteHand.getHandName() + " wins with " + whiteHand.getPokerHandType());
        }

        return winner;
    }

    private void displayHands(PokerHand pokerHand) {
        System.out.println(pokerHand.getHandName());
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

            if ((count == 4) | ((count == 3) && (nextElementValue == 14))) {
                if (pokerHand.getPokerHandType().equals("FLUSH")) {
                    pokerHand.setPokerHandType("STRAIGHT FLUSH");
                    pokerHand.setScore(0x900000 + (pokerHand.getCards().get(3).getRank().hexVal * 0x64));
                } else {
                    pokerHand.setPokerHandType("STRAIGHT");
                    pokerHand.setScore(0x400000 + (pokerHand.getCards().get(3).getRank().hexVal * 0x64));
                }
            } else {
                pokerHand.setScore(0);
            }
        }
    }

    /*
        iterates through the inputCards ArrayList and build HashMap
        Key is the card valuation of each element, and Value(mapValue) is
        the number of duplicate card valuations there are
    */
    private void findDuplicatesOfRankValue(PokerHand pokerHand) {
        if (pokerHand.getCardMatchCounter().size() == 0) {
            Map<Rank, Integer> cardMatchCounter = new HashMap<>();
            for (Card card : pokerHand.getCards()) {
                Integer mapValue = cardMatchCounter.get(card.getRank());
                if (cardMatchCounter.get(card.getRank()) == null) { //if map does not contain key
                    cardMatchCounter.put(card.getRank(), 1); //put element as Key, 1 as Value
                } else { //if the element already exists in the map
                    mapValue = mapValue + 1;
                    cardMatchCounter.put(card.getRank(), mapValue);//increment the counter
                }
            }

            cardMatchCounter.forEach((rank, copies) -> {
                int countPairs = 0;
                switch (copies) {
                    case 4:
                        pokerHand.setPokerHandType("FOUR_OF_KIND");
                        pokerHand.setValueOfFourOfAKind(rank.hexVal);
                        pokerHand.setScore(0x800000 + (pokerHand.getValueOfFourOfAKind() * 0x64));
                        break;
                    case 3:
                        pokerHand.setPokerHandType("THREE_OF_KIND");
                        pokerHand.setValueOfThreeOfAKind(rank.hexVal);
                        break;
                    case 2:
                        countPairs++;
                        pokerHand.setPairsCount(countPairs);
                        pokerHand.getValuesOfPairs().add(rank.value);
                        break;
                }
            });

            pokerHand.setCardMatchCounter(cardMatchCounter);
        }
    }

    //covers the check for full house as well
    private void checkForThreeOfAKind(PokerHand pokerHand) {
        findDuplicatesOfRankValue(pokerHand);
        if (pokerHand.getPokerHandType().equals("THREE_OF_KIND")) {
            if (pokerHand.getPairsCount() > 0) {
                pokerHand.setPokerHandType("FULL_HOUSE");
                pokerHand.setScore(0x600000 + (pokerHand.getValueOfThreeOfAKind() * 0x64));
            } else {
                pokerHand.setScore(0x300000 + (pokerHand.getValueOfThreeOfAKind() * 0x64));
            }
        }
    }

    private void checkForTwoPairs(PokerHand pokerHand) {
        ArrayList<Integer> pairs = new ArrayList<>(pokerHand.getValuesOfPairs());
        pairs.sort(Integer::compareTo);
        findDuplicatesOfRankValue(pokerHand);

        if (pairs.size() == 2) {
            pokerHand.setPokerHandType("TWO_PAIRS");
            int decimalBonus = pokerHand.findDistinctValues(pokerHand.getCards());
            pokerHand.setScore((0x200000 + (pairs.get(1) * 0x64)) + decimalBonus);
        }
    }

    private void checkForOnlyOnePair(PokerHand pokerHand) {
        ArrayList<Integer> pairs = new ArrayList<>(pokerHand.getValuesOfPairs());
        pairs.sort(Integer::compareTo);
        findDuplicatesOfRankValue(pokerHand);

        if (pairs.size() == 1) {
            pokerHand.setPokerHandType("ONE_PAIR");
            int decimalBonus = pokerHand.findDistinctValues(pokerHand.getCards());
            pokerHand.setScore((0x100000 + (pairs.get(0) * 0x64)) + decimalBonus);
        }
    }

    private void checkForHighCard(PokerHand pokerHand) {
        if (pokerHand.getPokerHandType().equals("UNDETERMINED")) {
            pokerHand.setPokerHandType("HIGH_CARD");
            pokerHand.setScore(pokerHand.getDecimalHandVal());
        }
    }
}


