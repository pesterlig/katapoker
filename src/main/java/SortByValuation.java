import java.util.Comparator;

public class SortByValuation implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getValuation()-o2.getValuation();
    }
}
