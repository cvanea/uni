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

            if (attemptMove(chessboard, move, player)) {
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

    private static Boolean attemptMove(Chessmen[][] chessboard, String move, String player) {

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

        if (rules(chessboard, oldRI, oldC, newRI, newC, player)) {
            chessboard[newC][newRI] = movedPiece;
            chessboard[oldC][oldRI] = Chessmen.EMPTY;

            printBoard(chessboard);
            return true;
        } else {
            System.out.println("Invalid move!\n");
            return false;
        }
    }

    private static boolean rules(Chessmen[][] chessboard, int oldC, int oldRI, int newC, int newRI, String player)
        throws IndexOutOfBoundsException {

        try {

            // Cannot pick up an empty space.
            if (chessboard[oldRI][oldC] == Chessmen.EMPTY) return false;

            // Cannot place a piece in its original location.
            if (chessboard[oldRI][oldC] == chessboard[newRI][newC]) return false;

            // Cannot take a King.
            if (chessboard[newRI][newC] == Chessmen.WHITE_KING) return false;
            if (chessboard[newRI][newC] == Chessmen.BLACK_KING) return false;

            // Cannot place on a piece of the same colour.
            if (chessboard[newRI][newC].getColour().equals(chessboard[oldRI][oldC].getColour())) return false;

            // Cannot pick up other player's piece.
            if (!player.equals(chessboard[oldRI][oldC].getColour())) return false;

            // Rules for a King.
            if (chessboard[oldRI][oldC] == Chessmen.BLACK_KING || chessboard[oldRI][oldC] == Chessmen.WHITE_KING) {
                int subRow = Math.abs(oldC - newC);
                int subCol = Math.abs(oldRI - newRI);

                if ((subRow == 1 || subRow == 0) && (subCol == 1 || subCol == 0)) {
                    return true;
                } else return false;

            }

            // Rules for a Rook.
            if (chessboard[oldRI][oldC] == Chessmen.BLACK_ROOK || chessboard[oldRI][oldC] == Chessmen.WHITE_ROOK) {
                int subRow = Math.abs(oldC - newC);
                int subCol = Math.abs(oldRI - newRI);

                if ((subRow <= 7 && subCol == 0) || (subCol <= 7 && subRow == 0)) {
                    return true;
                } else return false;

            }

            // Rules for a Bishop.
            if (chessboard[oldRI][oldC] == Chessmen.BLACK_BISHOP || chessboard[oldRI][oldC] == Chessmen.WHITE_BISHOP) {
                int subRow = Math.abs(oldC - newC);
                int subCol = Math.abs(oldRI - newRI);

                if ((subRow <= 7 && subCol == subRow) || (subCol <= 7 && subRow == subCol)) {
                    return true;
                } else return false;

            }

            // Rules for a Knight.
            if (chessboard[oldRI][oldC] == Chessmen.BLACK_KNIGHT || chessboard[oldRI][oldC] == Chessmen.WHITE_KNIGHT) {
                int subRow = Math.abs(oldC - newC);
                int subCol = Math.abs(oldRI - newRI);

                if ((subRow == 2 && subCol == 1) || (subCol <= 2 && subRow == 1)) {
                    return true;
                } else return false;

            }

            // Rules for a Queen.
            if (chessboard[oldRI][oldC] == Chessmen.BLACK_QUEEN || chessboard[oldRI][oldC] == Chessmen.WHITE_QUEEN) {
                int subRow = Math.abs(oldC - newC);
                int subCol = Math.abs(oldRI - newRI);

                if ((subRow <= 7) || (subCol <= 7)) {
                    return true;
                } else return false;

            }

            // Rules for a White Pawn.
            if (chessboard[oldRI][oldC] == Chessmen.WHITE_PAWN) {
                int subRow = (newRI - oldRI);

                if (oldRI == 1) {
                    if ((subRow == 1) || subRow == 2) {
                        return true;
                    }
                } else return subRow == 1;

            }

            // Rules for a Black Pawn.
            if (chessboard[oldRI][oldC] == Chessmen.BLACK_PAWN) {
                int subRow = (newRI - oldRI);

                if (oldRI == 6) {
                    if ((subRow == -1) || subRow == -2) {
                        return true;
                    }
                } else return subRow == -1;

            }

            return true;

            // Cannot move a piece off the board.
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}