import org.junit.Before;
import org.junit.Test;

public class JudgeTest {

    PokerHand pokerHand;
    Judge judge;

    @Before
    public void setUp() {
        String oneFlushText = "Black: 3D 2D 9D 5D KD  White: 2C 3H 4S 8C AH";
        String testFlushText = "Black: 2H 4H 5H 9H KD  White: 2C 3H 4S 8C AH";
        String oneStraightText = "Black: 3H 4H 5H 6H 2D  White: 2C 3H 4S 8C AH";
        String oneStraightFlush = "Black: TH KH AH JH QH  White: 2C 3H 4S 8C AH";
        String oneHandFullHouse = "Black: TH TD AH AS AC  White: 2C 3H 4S 8C AH";
        String oneHandFourOfAKind = "Black: TH AD AH AS AC  White: 2C 3H 4S 8C AH";
        String oneHandOnePair = "Black: TH 9D AH AS 4C  White: 2C 3H 4S 8C AH";
        String oneHandOfTwoPairs = "Black: TH TD AH AS 5C  White: 2C 3H 4S 8C AH";
    }

}
