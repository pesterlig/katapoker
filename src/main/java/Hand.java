import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand {

    public Hand() {
    }

    public String getBlackHand(String text) {
        return text.split("  ")[0];
    }

    public String getWhiteHand(String text) {
        return text.split("  ")[1];
    }

    public List<String> listCardCodes(String handStr) {

        String[] splitHandStr = handStr.split(" ");
        List<String> cardCodes = new ArrayList<>();
        List<String> splitHand = Arrays.asList(splitHandStr);
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

    public List<Card> sortByValuation (List<Card> cards){
        Collections.sort(cards, new SortByValuation());
        return cards;
    }



//lambda runs the internal block of code on each element of the array
    //referencing them by the name provided before the sting
    // -> sting
    // => rocket

    //get the hexValuation from the cardAbbreviation
    // and put it in a new array


}
