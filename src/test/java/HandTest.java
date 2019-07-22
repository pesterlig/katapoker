import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static junit.framework.TestCase.*;

public class HandTest {

    Hand hand;


    @Before
    public void setUp() {

        hand = new Hand();
    }

    /*@Test
    public void whenHandIsPassedAStringItReturnsThatString(){
        assertEquals("sometext",hand.listCardCodes("sometext"));
    }
*/
    /*@Test
    public void whenHandIsPassedAStringItReturnsAStringArray() {

        String text = "Black White";
        hand.listCardCodes(text);
        assertEquals("Black", hand.listCardCodes(text)[0]);
        assertEquals("White", hand.listCardCodes(text)[1]);
    }*/


    @Test
    public void whenSplitHandsIsPassedSampleInputItCreatesTwoStringsOfHands() {
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        hand.getBlackHand(text);
        assertEquals("Black: 2H 3D 5S 9C KD", hand.getBlackHand(text));
    }

    @Test
    public void whenSplitWhiteHandsIsPassedSampleInputItCreatesTwoStringsOfHands() {
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        hand.getWhiteHand(text);
        assertEquals("White: 2C 3H 4S 8C AH", hand.getWhiteHand(text));
    }


    @Test
    public void whenlistCardsIsPassedABlackHandStringInputItReturnArrayListOfCardsForBlack() {
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        String blackHand = hand.getBlackHand(text);
        hand.listCardCodes(blackHand);
        assertEquals("2H", hand.listCardCodes(blackHand).get(0));
        assertEquals("3D", hand.listCardCodes(blackHand).get(1));
        assertEquals("5S", hand.listCardCodes(blackHand).get(2));
        assertEquals("9C", hand.listCardCodes(blackHand).get(3));
        assertEquals("KD", hand.listCardCodes(blackHand).get(4));
    }

    @Test
    public void whenlistCardsIsPassedAWhiteHandStringInputItReturnArrayListOfCardsForWhite() {
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        String whiteHand = hand.getWhiteHand(text);
        hand.listCardCodes(whiteHand);
        assertEquals("2C", hand.listCardCodes(whiteHand).get(0));
        assertEquals("3H", hand.listCardCodes(whiteHand).get(1));
        assertEquals("4S", hand.listCardCodes(whiteHand).get(2));
        assertEquals("8C", hand.listCardCodes(whiteHand).get(3));
        assertEquals("AH", hand.listCardCodes(whiteHand).get(4));
    }

    /*@Test
    public void whenGetHexValueIsPassedAnArrayListOfCardsInAHandItReturnTheHexValueOfTheElementAtIndex0(){
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        String whiteHand = hand.getWhiteHand(text);
        List<String> cards = new ArrayList<>(hand.listCardCodes(whiteHand));
                hand.getHexValue(cards);
        assertEquals(0x2,hand.getHexValue(cards));
        assertEquals("2C");
    }*/

    //test below should be part of a CardTest class instead of HandTest
    @Test
    public void whenCardFindByCardAbbreviationIsPassedValidCardAbbrItReturnsCard() {
        String abbr = "AH";
        Card chosenCard = Card.findByCode(abbr);
        int abbrValuation = chosenCard.getValuation();

        //assertEquals("HEARTS_ACE",CHOSEN_CARD);
        assertEquals(14, abbrValuation);
    }

    @Test
    public void whenFindByCardCode_IsPassedValidCardCode_ItReturnsCardValuation() {
        String abbr = "KS";
        Card chosenCard = Card.findByCode(abbr);
        int abbrValuation = chosenCard.getValuation();

        //assertEquals("HEARTS_ACE",CHOSEN_CARD);
        assertEquals(13, abbrValuation);
    }



    @Test
    public void whenParseCardCodes_IsPassedAnArrayOfCodes_ItReturnsAnArrayOfCards(){
        String text = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        String blackHand = hand.getBlackHand(text);
        List<String> cardCodes = new ArrayList<>();
        cardCodes = hand.listCardCodes(blackHand);
        List<Card> cards = new ArrayList<>();
        cards = hand.parseCardCodes(cardCodes);
        assertEquals("2H",cardCodes.get(0));
        assertEquals(Card.HEARTS_TWO, cards.get(0));




    }


}
