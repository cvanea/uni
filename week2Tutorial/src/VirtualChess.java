import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;
import java.lang.Math;

public class VirtualChess {

    public static void main(String[] args) {
        Chessmen[][] chessboard = new Chessmen[8][8];
        Scanner input = new Scanner(System.in);

        placePieces(chessboard);
        System.out.println("\nWelcome to chess! \n");

        Boolean exit = false;
        String player;
        int count = 0;

        while (!exit) {

            if (count % 2 == 0) {
                player = "White";
            } else player = "Black";

            System.out.println(printBoard(chessboard));
            System.out.println(player + " to move. What is your move? (e.g. e2 e3)");
            if (input.hasNext("exit")) {
                exit = true;
            }
            String move = input.nextLine();

            if (move(chessboard, move)) {
                count++;
            }
        }
    }

    private static void placePieces(Chessmen[][] chessboard) {
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                chessboard[i][0] = Chessmen.WHITE_ROOK;
                chessboard[i][1] = Chessmen.WHITE_KNIGHT;
                chessboard[i][2] = Chessmen.WHITE_BISHOP;
                chessboard[i][3] = Chessmen.WHITE_QUEEN;
                chessboard[i][4] = Chessmen.WHITE_KING;
                chessboard[i][5] = Chessmen.WHITE_BISHOP;
                chessboard[i][6] = Chessmen.WHITE_KNIGHT;
                chessboard[i][7] = Chessmen.WHITE_ROOK;
            } else if (i == 7) {
                chessboard[i][0] = Chessmen.BLACK_ROOK;
                chessboard[i][1] = Chessmen.BLACK_KNIGHT;
                chessboard[i][2] = Chessmen.BLACK_BISHOP;
                chessboard[i][3] = Chessmen.BLACK_QUEEN;
                chessboard[i][4] = Chessmen.BLACK_KING;
                chessboard[i][5] = Chessmen.BLACK_BISHOP;
                chessboard[i][6] = Chessmen.BLACK_KNIGHT;
                chessboard[i][7] = Chessmen.BLACK_ROOK;
            } else {
                for (int j = 0; j < 8; j++) {
                    if (i == 1) {
                        chessboard[i][j] = Chessmen.WHITE_PAWN;
                    } else if (i == 6) {
                        chessboard[i][j] = Chessmen.BLACK_PAWN;
                    } else chessboard[i][j] = Chessmen.EMPTY;
                }
            }
        }
    }

    private static String printBoard(Chessmen[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\ta  b  c  d  e  f  g  h \n");
        for (int i = 7; i >= 0; i--) {
            stringBuilder.append(" ").append(i + 1).append(".");
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(board[i][j].getUnicode());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static Boolean move(Chessmen[][] chessboard, String move) {

        // e.g. e2 e3
        String[] components = move.split(" ");

        //Takes user input and splits into chars.
        char oldR = components[0].charAt(0);
        int oldC = (components[0].charAt(1) - '0') - 1;
        char newR = components[1].charAt(0);
        int newC = (components[1].charAt(1) - '0') - 1;

        // Converts chars to ints.
        int oldRI = oldR - 'a';
        int newRI = newR - 'a';

        Chessmen movedPiece = chessboard[oldC][oldRI];
//        Chessmen moveTo = chessboard[newC][newRI];


        if (rules(chessboard, oldRI, oldC, newRI, newC)) {
            chessboard[newC][newRI] = movedPiece;
            chessboard[oldC][oldRI] = Chessmen.EMPTY;

            printBoard(chessboard);
            return true;
        } else {
            System.out.println("Invalid move!\n");
            return false;}
    }

    private static boolean rules(Chessmen[][] chessboard, int oldRI, int oldC, int newRI, int newC)
        throws IndexOutOfBoundsException {

        try {

            // Cannot pick up an empty space.
            if (chessboard[oldC][oldRI] == Chessmen.EMPTY) return false;

            // Cannot place a piece in its original location.
            if (chessboard[oldC][oldRI] == chessboard[newC][newRI]) return false;

            // Cannot take a King.
            if (chessboard[newC][newRI] == Chessmen.WHITE_KING) return false;
            if (chessboard[newC][newRI] == Chessmen.BLACK_KING) return false;

            // Cannot place on a piece of the same colour.
            if (chessboard[oldC][oldRI] == Chessmen.BLACK_ROOK || chessboard[oldC][oldRI]
                == Chessmen.BLACK_KNIGHT || chessboard[oldC][oldRI]
                == Chessmen.BLACK_PAWN || chessboard[oldC][oldRI]
                == Chessmen.BLACK_BISHOP || chessboard[oldC][oldRI]
                == Chessmen.BLACK_QUEEN || chessboard[oldC][oldRI]
                == Chessmen.BLACK_KING) {
                if (chessboard[newC][newRI] == Chessmen.BLACK_ROOK || chessboard[newC][newRI]
                    == Chessmen.BLACK_KNIGHT || chessboard[newC][newRI]
                    == Chessmen.BLACK_PAWN || chessboard[newC][newRI]
                    == Chessmen.BLACK_BISHOP || chessboard[newC][newRI]
                    == Chessmen.BLACK_QUEEN || chessboard[newC][newRI]
                    == Chessmen.BLACK_KING) {
                    return false;
                }
            }
            if (chessboard[oldC][oldRI] == Chessmen.WHITE_ROOK || chessboard[oldC][oldRI]
                == Chessmen.WHITE_KNIGHT || chessboard[oldC][oldRI]
                == Chessmen.WHITE_PAWN || chessboard[oldC][oldRI]
                == Chessmen.WHITE_BISHOP || chessboard[oldC][oldRI]
                == Chessmen.WHITE_QUEEN || chessboard[oldC][oldRI]
                == Chessmen.WHITE_KING) {
                if (chessboard[newC][newRI] == Chessmen.WHITE_ROOK || chessboard[newC][newRI]
                    == Chessmen.WHITE_KNIGHT || chessboard[newC][newRI]
                    == Chessmen.WHITE_PAWN || chessboard[newC][newRI]
                    == Chessmen.WHITE_BISHOP || chessboard[newC][newRI]
                    == Chessmen.WHITE_QUEEN || chessboard[newC][newRI]
                    == Chessmen.WHITE_KING) {
                    return false;
                }
            }

            // Rules for a King.
            if (chessboard[oldC][oldRI] == Chessmen.BLACK_KING || chessboard[oldC][oldRI] == Chessmen.WHITE_KING) {
                int subRow = Math.abs(oldRI - newRI);
                int subCol = Math.abs(oldC - newC);

                if ((subRow == 1 || subRow == 0) && (subCol == 1 || subCol == 0)) {
                    return true;
                } else return false;

            }

//             Rules for a Rook. In progress...
            if (chessboard[oldC][oldRI] == Chessmen.BLACK_ROOK || chessboard[oldC][oldRI] == Chessmen.WHITE_ROOK) {
                int subRow = Math.abs(oldRI - newRI);
                int subCol = Math.abs(oldC - newC);

                if ((subRow == 1 || subRow == 0) && (subCol == 1 || subCol == 0)) {
                    return true;
                } else return false;

            }

            return true;

            // Cannot move a piece off the board.
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}