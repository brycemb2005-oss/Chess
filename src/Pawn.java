import java.util.ArrayList;

class Pawn extends Piece {

    public Pawn(ChessBoard board, Color color) {
        super(board, color);
    }

    public ArrayList<String> legalMoves() {
        ArrayList<String> validMoves = new ArrayList<>();

        String targetPosition = getPosition();

        char column = Character.toLowerCase(targetPosition.charAt(0));
        int row = Character.getNumericValue(targetPosition.charAt(1));


        int direction;

        if (this.getColor() == Color.WHITE) {
            direction = 1;
        } else direction = -1;

        String forward = column + String.valueOf(row + direction);

        try {
            if (board.getPiece(forward) == null) {
                validMoves.add(forward);

                if ((this.getColor() == Color.WHITE && row == 2) ||
                        (this.getColor() == Color.BLACK && row == 7)) {

                    String twice = column + String.valueOf(row + (2 * direction));

                    if (board.getPiece(twice) == null) {
                        validMoves.add(twice);
                    }
                }
            }

            if (column > 'a') {
                String side1 = (char)(column - 1) + String.valueOf(row + direction);
                Piece capture1 = board.getPiece(side1);
                if (capture1 != null && capture1.getColor() != this.getColor()) {
                    validMoves.add(side1);
                }
            }

            if (column < 'h') {
                String side2 = (char)(column + 1) + String.valueOf(row + direction);
                Piece capture2 = board.getPiece(side2);
                if (capture2 != null && capture2.getColor() != this.getColor()) {
                    validMoves.add(side2);
                }
            }

        } catch (Exception e) {
            System.out.println("Error calculating pawn moves: " + e.getMessage());
        }

        return validMoves;
    }
}
