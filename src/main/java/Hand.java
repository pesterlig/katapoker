import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

    public Hand() {
    }

    public List<String> listBlackCards(String text) {

        String[] str = text.split(" ");
        List<String> blackCards = new ArrayList<>();
        List<String> splitStr = Arrays.asList(str);
        for (int i = 1; i < 6; i++) {
            blackCards.add(splitStr.get(i));
        }
        return blackCards;
    }
}
