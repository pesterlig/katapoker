import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class KataPokerTest {

    private String input;
    private String expectedOutput;

    public KataPokerTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

//    @Before
//    public void setUp() {
//        String oneFlushText = "Black: 3D 2D 9D 5D KD  White: 2C 3H 4S 8C AH";
//        String testFlushText = "Black: 2H 4H 5H 9H KD  White: 2C 3H 4S 8C AH", "white"
//        String oneStraightText = "Black: 3H 4H 5H 6H 2D  White: 2C 3H 4S 8C AH", "black"

//        String oneStraightFlush = "Black: TH KH AH JH QH  White: 2C 3H 4S 8C AH", "black"

//        String oneHandFullHouse = "Black: TH TD AH AS AC  White: 2C 3H 4S 8C AH", "black"

//        String oneHandFourOfAKind = "Black: TH AD 9H AS AC  White: 3C 3H 3S 3D AH", "white"

//        String oneHandOnePair = "Black: TH 9D AH AS 4C  White: 2C 3H 4S 8C AH", "black"

//        String oneHandOfTwoPairs = "Black: TH TD AH AS 5C  White: TC AD TS 8C AC","white"


//    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Black: 4H 3H AH 2H 5H  White: TC TS AD AC 8C", "black"}); //flush
        list.add(new Object[]{"Black: 2H 4H 5H 9H KD  White: 2C 3H 4S 8C AH", "white"}); //high card
        list.add(new Object[]{"Black: 3H 4H 5H 6H 2D  White: 2C 3H 4S 8C AH", "black"}); //high card
        list.add(new Object[]{"Black: TH KH AH JH QH  White: 2C 3H 4S 8C AH", "black"}); //straight flush
        list.add(new Object[]{"Black: TH TD AH AS AC  White: 2C 3H 4S 8C AH", "black"}); //full house
        list.add(new Object[]{"Black: TH AD 9H AS AC  White: 3C 3H 3S 3D AH", "white"}); //four of kind
        list.add(new Object[]{"Black: TH 9D AH AS 4C  White: 2C 3H 4S 8C AH", "black"}); //single pair
        list.add(new Object[]{"Black: TH TD AH AS 5C  White: TC AD TS 8C AC", "white"}); //two pair, high card tie-breaker
        list.add(new Object[]{"Black: TH TD AH AS 8H  White: TC AD TS 8C AC", "white"}); //two pair, tie
        list.add(new Object[]{"Black: 5H 5D AH AS 8H  White: TC AD TS 8C AC", "white"}); //two pair, 2nd pair high
        list.add(new Object[]{"Black: 5H 5D JH AS 8H  White: 5C AD 5S 8C JC", "white"}); //one pair, tie
        list.add(new Object[]{"Black: 5H 5D JH AS 9H  White: 5C AD 5S 8C JC", "black"}); //one pair, third card high
        list.add(new Object[]{"Black: 4H 3D AH 2H 5C  White: TC 9S AD JC 8C", "white"}); //high card
        list.add(new Object[]{"Black: 4H 4S 4D 2H 5H  White: TC TS TD AC 8C", "white"}); //three of a kind


        return list;
    }

    @Test
    public void testbutts() {
        Assert.assertEquals(Main.runAllTheThings(input), expectedOutput);
    }


}
