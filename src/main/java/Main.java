import enums.Card;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        String oneFlushText = "Black: 3D 2D 9D 5D KD  White: 2C 3H 4S 8C AH";
        String testFlushText = "Black: 2H 4H 5H 9H KD  White: 2C 3H 4S 8C AH";
        String oneStraightText = "Black: 3H 4H 5H 6H 2D  White: 2C 3H 4S 8C AH";
        String oneStraightFlush = "Black: TH KH AH JH QH  White: 2C 3H 4S 8C AH";
        String oneHandFullHouse = "Black: TH TD AH AS AC  White: 2C 3H 4S 8C AH";
        String oneHandFourOfAKind = "Black: TH AD AH AS AC  White: 2C 3H 4S 8C AH";
        String oneHandOnePair = "Black: TH 9D AH AS 4C  White: 2C 3H 4S 8C AH";
        String oneHandOfTwoPairs = "Black: TH TD AH AS 5C  White: TC TS AD AC 8C";
        */

        //Format the input data & create black & white hands
        String inputString = "Black: TH TD AH AS 5C  White: TC TS AD AC 8C";

        PokerHand black = new PokerHand("black");
        String handBlack = inputString.split("  ")[0];
        List<Card> sortedAscendingBlackHand = black.createSortedAscendingHand(handBlack);
        black.setCards((ArrayList<Card>) sortedAscendingBlackHand);
        black.setPokerHandType("UNDETERMINED");


        //System.out.println(black.getHandName()+ " score is: " + black.getDecimalHandVal(black.getStringOfHexVal());


        PokerHand white = new PokerHand("white");
        String handWhite = inputString.split("  ")[1];
        List<Card> sortedAscendingWhiteHand = white.createSortedAscendingHand(handWhite);
        white.setCards((ArrayList<Card>) sortedAscendingWhiteHand);
        white.setPokerHandType("UNDETERMINED");


        //System.out.println(white.getHandName()+ " score is: " + white.getDecimalHandVal(white.getCards()));

        //Create an array of the ArrayList of cards from each hand

        List<Card>[] nestedCards = new List[2];
        nestedCards[0] = black.getCards();
        nestedCards[1] = white.getCards();

        for (int i = 0; i < nestedCards.length; i++) {
            List<Card> cardsOfBothHands = nestedCards[i];
            System.out.println(cardsOfBothHands);
        }


        //Create an array of the two hands

        List<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(black);
        pokerHands.add(white);

        for (int i = 0; i < pokerHands.size(); i++) {
            List<PokerHand> bothHands = pokerHands;
            System.out.println(bothHands);
        }

        Judge judge = new Judge();
        judge.determinePokerHandType(pokerHands);
        judge.compareHandsForWin(pokerHands);



        /*List<Card> flush = new ArrayList<>();
        flush = handScore.checkForFlush(cards);
        System.out.println("Cards in the flush array = " + flush);

        int score = handScore.getScore();
        System.out.println("The score for the hand is " + score);

        List<Card> straight = new ArrayList<>();
        straight = handScore.checkForStraight(cards);
        System.out.println("Cards in the straight array = " + straight);

        int straightScore = handScore.getScore();
        System.out.println("The score for the hand is " + straightScore);

        List<Card> straightFlush = new ArrayList<>();
        straightFlush = handScore.checkForStraightFlush(cards);
        System.out.println("Cards in the straight array = " + straightFlush);

        int straightFlushScore = handScore.getScore();
        System.out.println("The score for the hand is " + straightFlushScore);

        handScore.findDuplicatesOfValue(cards);*/



        /*handScore.checkForFourOfAKind(cards);
        System.out.println("Four of a Kind? " + handScore.isFourOfAKind());
        System.out.println("Score for FourOfAKind: " + handScore.getScore());

        handScore.checkForFullHouse(cards);
        System.out.println("FullHouse? " + handScore.isFullHouse());
        System.out.println("Score for this FullHouse: " + handScore.getScore());

        handScore.checkForThreeOfAKind(cards);
        System.out.println("Three of a Kind only? " + handScore.isThreeOfAKind());
        System.out.println("Score for Three of a Kind: " + handScore.getScore());

        handScore.checkForTwoPairs(cards, handScore.findDuplicatesOfValue(cards));
        System.out.println("Two Pairs? " + handScore.isTwoPairs());
        System.out.println("Score for Two Pairs: " + handScore.getScore());

        handScore.checkForOnlyOnePair(cards, handScore.findDuplicatesOfValue(cards));
        System.out.println("Only One Pair? " + handScore.isOnePair());
        System.out.println("Score for One Pair: " + handScore.getScore());*/


    }


}
