import enums.Card;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("This program evaluates two poker hands expressed as a string of data, formatted as the examples below: \n" +
                "Black: 2H 4H 3S 8H AD  White: 2C 3H 4S 8C AH\n" +
                "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH\n" +
                "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S\n" +
                "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH\n" +
                "Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH");

        String choice = "0";
        //Demo Loop
        while (!choice.equalsIgnoreCase("q") || choice.equalsIgnoreCase("0")) {
            displayPencilDemoMenu();
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("E")) {
                System.out.println("Please enter your data string. You may try one of the lines above, or create your own. \n " +
                        "(Ensure one space between cards and TWO SPACES between the last card of the black hand and White:");
                System.out.println("");
                String inputPokerHands = input.nextLine();
                runAllTheThings(inputPokerHands);
            } else if (choice.contains("q")) {
                System.out.println("Thanks for playing!");
                System.out.println("Good bye.");
                System.exit(0);
            } else
                System.out.println("That was not a valid choice");
        }
    }

    public static void displayPencilDemoMenu() {
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println(" E = Evaluate some Poker Hands!");
        System.out.println(" Leave Kata Poker Demo (Type q to quit)");
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
        judge.displayEachHandOfCards(pokerHands);
        judge.determinePokerHandType(pokerHands);
        String winner = judge.compareHandsForWin(pokerHands);
        System.out.println(winner);

        return winner;

    }




}
