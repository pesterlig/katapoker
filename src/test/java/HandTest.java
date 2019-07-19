import org.junit.Test;

import java.awt.*;
import static junit.framework.TestCase.*;

public class HandTest {

    @Test
    public void whenHandIsPassedAStringItReturnsThatString(){
        Hand hand = new Hand();

        assertEquals("sometext",hand.listCards("sometext"));
    }
}
