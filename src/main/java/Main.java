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

        String inputString = "Black: 4H 3H AH 2H 5H  White: TC TS AD AC 8C";
        runAllTheThings(inputString);

       /* PokerHand black = new PokerHand("black");
        String handBlack = inputString.split("  ")[0];
        List<Card> sortedAscendingBlackHand = black.createSortedAscendingHand(handBlack);
        black.setCards((ArrayList<Card>) sortedAscendingBlackHand);
        black.setPokerHandType("UNDETERMINED");


        //System.out.println(black.getHandName()+ " score is: " + black.getDecimalHandVal(black.getStringOfHexVal());


        PokerHand white = new PokerHand("white");
        String handWhite = inputString.split("  ")[1];
        List<Card> sortedAscendingWhiteHand = white.createSortedAscendingHand(handWhite);
        white.setCards((ArrayList<Card>) sortedAscendingWhiteHand);
        white.setPokerHandType("UNDETERMINED");*/



        /*//Create an array of the two hands

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
*/

    }

    public static String runAllTheThings(String input){
        PokerHand black = new PokerHand("black");
        String handBlack = input.split("  ")[0];
        List<Card> sortedAscendingBlackHand = black.createSortedAscendingHand(handBlack);
        black.setCards((ArrayList<Card>) sortedAscendingBlackHand);
        black.setPokerHandType("UNDETERMINED");

        //System.out.println(black.getHandName()+ " score is: " + black.getDecimalHandVal(black.getStringOfHexVal());

        PokerHand white = new PokerHand("white");
        String handWhite = input.split("  ")[1];
        List<Card> sortedAscendingWhiteHand = white.createSortedAscendingHand(handWhite);
        white.setCards((ArrayList<Card>) sortedAscendingWhiteHand);
        white.setPokerHandType("UNDETERMINED");

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
        String winner = judge.compareHandsForWin(pokerHands);
        System.out.println(winner);

        return winner;

    }




}
