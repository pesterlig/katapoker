import enums.Card;

import java.util.Comparator;

public class SortByRankValue implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return (o1.getRank().value - o2.getRank().value);
    }
}
