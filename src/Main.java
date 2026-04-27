import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.initialize();
        Scanner scanner = new Scanner(System.in);

//        Piece whiteQueen = new Queen(board, Piece.Color.WHITE);
//
//        boolean success = board.placePiece(whiteQueen, "d5");

        System.out.println(board.getPiece("d5"));

        while (true) {
            board.printBoard();
            System.out.println();
            System.out.println();
            System.out.println("Please input what Piece you want to move in algebraic notation (e.g. e4)");
            String from = scanner.next();
            System.out.println("Please input what Position you want the selected piece to move in algebraic notation (e.g. e4)");
            String to = scanner.next();

            try {
                board.move(from, to);
            } catch (Exception e) {
                System.out.println("Invalid move: " + e.getMessage());
            }
        }
    }
}