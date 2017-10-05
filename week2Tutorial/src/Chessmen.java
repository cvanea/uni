public enum Chessmen {

    BLACK_KING(" \u2654 "," K "),
    BLACK_QUEEN(" \u2655 "," Q "),
    BLACK_ROOK(" \u2656 "," R "),
    BLACK_BISHOP(" \u2657 "," B "),
    BLACK_KNIGHT(" \u2658 "," N "),
    BLACK_PAWN(" \u2659 "," P "),
    WHITE_KING(" \u265A "," k "),
    WHITE_QUEEN(" \u265B "," q "),
    WHITE_ROOK(" \u265C "," r "),
    WHITE_BISHOP(" \u265D "," b "),
    WHITE_KNIGHT(" \u265E "," n "),
    WHITE_PAWN(" \u265F "," p "),
    EMPTY("   ","   ");

    String character;
    String unicode;

    Chessmen(String unicode,String character) {
        this.unicode = unicode;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public String getUnicode() {
        return unicode;
    }
}
