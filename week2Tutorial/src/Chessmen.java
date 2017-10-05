public enum Chessmen {

    BLACK_KING(" \u2654 "," K ", "Black"),
    BLACK_QUEEN(" \u2655 "," Q ", "Black"),
    BLACK_ROOK(" \u2656 "," R ", "Black"),
    BLACK_BISHOP(" \u2657 "," B ", "Black"),
    BLACK_KNIGHT(" \u2658 "," N ", "Black"),
    BLACK_PAWN(" \u2659 "," P ", "Black"),
    WHITE_KING(" \u265A "," k ", "White"),
    WHITE_QUEEN(" \u265B "," q ", "White"),
    WHITE_ROOK(" \u265C "," r ", "White"),
    WHITE_BISHOP(" \u265D "," b ", "White"),
    WHITE_KNIGHT(" \u265E "," n ", "White"),
    WHITE_PAWN(" \u265F "," p ", "White"),
    EMPTY("   ","   ", "    ");

    String character;
    String unicode;
    String colour;

    Chessmen(String unicode,String character, String colour) {
        this.unicode = unicode;
        this.character = character;
        this.colour = colour;
    }

    public String getCharacter() {
        return character;
    }

    public String getUnicode() {
        return unicode;
    }

    public String getColour() {
        return colour;
    }
}
