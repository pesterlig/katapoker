import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;

import java.util.ArrayList;
import java.util.List;

public class HandScoreTest {

    Hand hand;
    HandScore handScore;


//set up for oneFlushText input, blackHand
    @Before
    public void setUp(){
        hand = new Hand();
        handScore = new HandScore(0);
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        String oneFlushText = "Black: 2D 3D 5D 9D KD  White: 2C 3H 4S 8C AH";
        String twoFlushesText = "Black: 2H 3D 5S 9C KD  White: 2C 3C 4C 8C AC";

    }

    @Test
    public void whenCheckForFlush_IsPassedAFlush_ItScores0x500(){
        String oneFlushText = "Black: 2D 3D 5D 9D KD  White: 2C 3H 4S 8C AH";
        String blackHand = hand.getBlackHand(oneFlushText);
        List<String> cardCodes = new ArrayList<>();
        cardCodes = hand.listCardCodes(blackHand);
        List<Card> cards = new ArrayList<>();
        cards = hand.parseCardCodes(cardCodes);
        List<Card> flush = new ArrayList<>();
        handScore.checkForFlush(cards);
        int score = handScore.getScore();
        assertEquals(0x500, handScore.getScore());

    }
    @Test
    public void whenCheckForFlush_IsPassedAFlush_ItReturnsAFlushArrayCalledFlush(){
        String oneFlushText = "Black: 2D 3D 5D 9D KD  White: 2C 3H 4S 8C AH";
        String blackHand = hand.getBlackHand(oneFlushText);
        List<String> cardCodes = new ArrayList<>();
        cardCodes = hand.listCardCodes(blackHand);
        List<Card> cards = new ArrayList<>();
        cards = hand.parseCardCodes(cardCodes);
        List<Card> flush = new ArrayList<>();
        flush = handScore.checkForFlush(cards);
        int score = handScore.getScore();

        //assertEquals(0x500, handScore.getScore());
        assertEquals(Card.DIAMONDS_KING,flush.get(4));

    }

}
