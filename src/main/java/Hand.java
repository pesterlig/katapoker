import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

    public Hand() {
    }

    public String[] listCards(String text){
        String[] cards = text.split(" ");
        return cards;
    }

}
