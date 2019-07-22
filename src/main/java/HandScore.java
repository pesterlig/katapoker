import java.util.ArrayList;
import java.util.List;

public class HandScore {

    private int score;

    public HandScore(int score) {
        this.score = score;
    }



    /*public List<Card> checkForFlush(List<Card> cards){
        List<Card> flush = new ArrayList<>();
        //flush.add(cards.get(0));
        for (int i = 4 ; i > 0; i--){
            int count = 0;
            if (cards.get(i).getSuitIndicator().equals(cards.get(i-1).getSuitIndicator())){
                flush.add(cards.get(i));
                count++;
                if(count == 4){
                    flush.add(cards.get(0));
                    setScore(0x500);
                    return flush;
                }
            }
            return cards;

        }
     return null;
    }*/

    public List<Card> checkForFlush(List<Card> cards) {
        List<Card> flush = new ArrayList<Card>();
        //flush.add(cards.get(0));
        int count = 0;

        for (int i = 0; i < 4; i++) {

            if (cards.get(i).getSuitIndicator().equals(cards.get(i + 1).getSuitIndicator())) {
                flush.add(cards.get(i));
                count++;
                System.out.println("Count from the method is " + count);
            }

        }
        flush.add(cards.get(4));
        setScore(0x500);
        if (count != 4) {
            flush.clear();
            setScore(0);
        }

        System.out.println("Count from outside the for loop of the method is " + count);
        return flush;
    }


    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }
    /*
    notes on scoring
    flush scores 0x5000
    */
}
