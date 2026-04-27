/*
    Creates a board
    Updates board based on information passed from the "Movement()" Method
 */

class ChessBoard {

    Piece[][] Board = new Piece[8][8];

    ChessBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Board[i][j] = null;
            }
        }
    }

    void initialize() {
        // Kings
        placePiece(new King(this, Piece.Color.BLACK), "e8");
        placePiece(new King(this, Piece.Color.WHITE), "e1");

        // Queens
        placePiece(new Queen(this, Piece.Color.BLACK), "d8");
        placePiece(new Queen(this, Piece.Color.WHITE), "d1");

        // Bishops
        placePiece(new Bishop(this, Piece.Color.BLACK), "c8");
        placePiece(new Bishop(this, Piece.Color.BLACK), "f8");
        placePiece(new Bishop(this, Piece.Color.WHITE), "c1");
        placePiece(new Bishop(this, Piece.Color.WHITE), "f1");

        // Knights
        placePiece(new Knight(this, Piece.Color.BLACK), "b8");
        placePiece(new Knight(this, Piece.Color.BLACK), "g8");
        placePiece(new Knight(this, Piece.Color.WHITE), "b1");
        placePiece(new Knight(this, Piece.Color.WHITE), "g1");

        // Rooks
        placePiece(new Rook(this, Piece.Color.BLACK), "a8");
        placePiece(new Rook(this, Piece.Color.BLACK), "h8");
        placePiece(new Rook(this, Piece.Color.WHITE), "a1");
        placePiece(new Rook(this, Piece.Color.WHITE), "h1");

        // Pawns
        for (int i = 0; i < 8; i++) {
            char file = (char) ('a' + i);
            placePiece(new Pawn(this, Piece.Color.BLACK), file + "7");
            placePiece(new Pawn(this, Piece.Color.WHITE), file + "2");
        }
    }

    Piece getPiece(String position) throws IllegalPositionException {
        // Return the piece at the given square, or null if empty
        if (position == null || position.length() != 2) {
            throw new IllegalPositionException("Invalid position format. Use algebraic notation (e.g., 'e4).");
        }

        int letter = Character.toLowerCase(position.charAt(0) - 'a');
        int number = position.charAt(1) - '1';

        if (letter < 0 || letter > 7 || number < 0 || number > 7) {
            throw new IllegalPositionException("Position out of bounds" + position);
        }

        if (Board[letter][number] == null) {
            return null;
        } else {
            return (Board[letter][number]);
        }
    }

    boolean placePiece(Piece piece, String position) {
        // Place piece; return false (do not throw) if position is out of range.

        if (position == null || position.length() != 2) {
            return false;
        }

        int letter = Character.toLowerCase(position.charAt(0) - 'a');
        int number = position.charAt(1) - '1';

        if (letter < 0 || letter > 7 || number < 0 || number > 7) {
            return false;
        }

//        String symbol;
//        switch (piece.getClass().getSimpleName()) {
//            case "King":
//                symbol = "K";
//                break;
//            case "Queen":
//                symbol = "Q";
//                break;
//            case "Bishop":
//                symbol = "B";
//                break;
//            case "Knight":
//                symbol = "N";
//                break;
//            case "Rook":
//                symbol = "R";
//                break;
//            case "Pawn":
//                symbol = "P";
//                break;
//            default:
//                return false;
//
//        }

        Board[letter][number] = piece;

        try {
            piece.setPosition(position);
        } catch (IllegalPositionException e) {
            return false;
        }

        return true;
    }

    void move(String from, String to) throws IllegalMoveException {
        // Move piece from one square to another; throw if the move is illegal

        try {
            Piece pieceSymbol = getPiece(from);

            if (pieceSymbol == null) {
                throw new IllegalMoveException("No piece to move at " + from);
            }

            int fromCol = Character.toLowerCase(from.charAt(0) - 'a');
            int fromRow = from.charAt(1) - '1';

            int toCol = Character.toLowerCase(to.charAt(0) - 'a');
            int toRow = to.charAt(1) - '1';

            for (String piece : pieceSymbol.legalMoves()) {
                if (piece.equals(to)) {
                    Board[toCol][toRow] = pieceSymbol;
                    Board[fromCol][fromRow] = null;
                }
            }
            pieceSymbol.setPosition(to);

        } catch (IllegalPositionException e) {
            throw new IllegalMoveException("Invalid coordinates: " + e.getMessage());
        }
    }

    void printBoard() {

        String[][] sBoard = new String[10][10];

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (Board[i - 1][j - 1] == null) {
                    sBoard[i][j] = "*";
                } else {
                    switch (Board[i - 1][j - 1].getClass().getSimpleName()) {
                        case "King":
                            sBoard[i][j] = "K";
                            break;
                        case "Queen":
                            sBoard[i][j] = "Q";
                            break;
                        case "Bishop":
                            sBoard[i][j] = "B";
                            break;
                        case "Knight":
                            sBoard[i][j] = "N";
                            break;
                        case "Rook":
                            sBoard[i][j] = "R";
                            break;
                        case "Pawn":
                            sBoard[i][j] = "P";
                            break;
                        default:
                            sBoard[i][j] = "*";
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print("# ");
        }
        System.out.println();
        for (int i = 1; i < 9; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < 9; j++) {
                System.out.print(sBoard[j][i] + " ");
            }
            System.out.println("# ");
        }
        System.out.print("# ");
        for (int i = 1; i < 9; i++) {
            char letter = (char) (i + 96);
            System.out.print(letter + " ");
        }
        System.out.print("# ");
    }
}