import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hand hand = new Hand();
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        String blackHand = hand.getBlackHand(text);

        List<String> cardCodes = new ArrayList<>();
        cardCodes = hand.listCardCodes(blackHand);

        List<Card> cards = new ArrayList<>();
        cards = hand.parseCardCodes(cardCodes);

        System.out.println(cards);

        Collections.sort(cards);
        System.out.println(cards);

        Collections.sort(cards, new SortByValuation());
        System.out.println(cards);



    }
}
