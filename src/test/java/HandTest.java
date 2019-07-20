import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class HandTest {

    Hand hand;


    @Before
    public void setUp() {

        hand = new Hand();
    }

    /*@Test
    public void whenHandIsPassedAStringItReturnsThatString(){
        assertEquals("sometext",hand.listCards("sometext"));
    }
*/
    @Test
    public void whenHandIsPassedAStringItReturnsAStringArray() {

        String text = "Black White";
        hand.listCards(text);
        assertEquals("Black", hand.listCards(text)[0]);
        assertEquals("White", hand.listCards(text)[1]);
    }

    /* @Test
    public void whenHandIsPassedASampleInputItReturnsAStringArrayOfCardForBlack() {

        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH"
        hand.listCards(text);
        assertEquals("Black", hand.listCards(text)[0]);
        assertEquals("2H", hand.listCards(text)[13]);

    }
*/

}
