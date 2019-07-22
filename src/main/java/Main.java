import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hand hand = new Hand();
        HandScore handScore = new HandScore(0);
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        String oneFlushText = "Black: 3D 2D 9D 5D KD  White: 2C 3H 4S 8C AH";
        String testFlushText = "Black: 2H 4H 5H 9H KD  White: 2C 3H 4S 8C AH";



        String blackHand = hand.getBlackHand(testFlushText);
        System.out.println("String blackHand = " + blackHand);

        List<String> cardCodes = new ArrayList<>();
        cardCodes = hand.listCardCodes(blackHand);

        System.out.println("ArrayList cardCodes = " + cardCodes);

        List<Card> cards = new ArrayList<>();
        cards = hand.parseCardCodes(cardCodes);

        System.out.println("Cards unsorted = " + cards);

        Collections.sort(cards);
        System.out.println("Sorted cards = " + cards);

        Collections.sort(cards, new SortByValuation());
        System.out.println("Cards sorted by valuation = " + cards);

        List<Card> flush = new ArrayList<>();
        flush = handScore.checkForFlush(cards);
        System.out.println("Cards in the flush array = " + flush);

        int score = handScore.getScore();
        System.out.println("The score for the hand is " + score);



    }
}
