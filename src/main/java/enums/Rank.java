package enums;


public enum Rank {
    TWO(2, "Two", '2'),
    THREE(3, "Three", '3'),
    FOUR(4, "Four", '4'),
    FIVE(5, "Five", '5'),
    SIX(6, "Six", '6'),
    SEVEN(7, "Seven", '7'),
    EIGHT(8, "Eight", '8'),
    NINE(9, "Nine", '9'),
    TEN(10, "Ten", 'A'),
    JACK(11, "Jack", 'B'),
    QUEEN(12, "Queen", 'C'),
    KING(13, "King", 'D'),
    ACE(14, "Ace", 'E'),
    ;

    public final int value;
    public final String displayName;
    public final char hexVal;


    Rank(int value, String displayName, char hexVal) {
        this.value = value;
        this.displayName = displayName;
        this.hexVal = hexVal;
    }


}
