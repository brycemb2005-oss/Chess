/*
    Checks to see if King is alive
    Checks positon of King
    Finds
    if alive it finds which squares the King is allowed to move to and passes those valid regions to "Movement():"
    Uses higher method "Movement()" to select square and move the king using e7 etc.
*/

import java.util.ArrayList;

class King extends Piece {

    public King(ChessBoard board, Color color) {
        super(board, color);
    }

    ArrayList<String> kingLogic (String position) {
        ArrayList<String> moves = new ArrayList<String>();

        int column = Character.toLowerCase(position.charAt(0));
        int row = Character.getNumericValue(position.charAt(1));

        int top = row + 1;
        int bottom = row - 1;

        for (int i = -1; i < 3; i++) {
            String upper = (char) (column + i) + String.valueOf(top);
            moves.add(upper);
            String lower = (char) (column + i) + String.valueOf(bottom);
            moves.add(lower);
        }

        String left = (char) (column - 1) + String.valueOf(row);
        moves.add(left);
        String right = (char) (column + 1) + String.valueOf(row);
        moves.add(right);

        return moves;
    }

    public ArrayList<String> legalMoves() {
        ArrayList<String> validMoves = new ArrayList<>();

        String targetPosition = getPosition();

        kingLogic(targetPosition);

        for (int i = 0; i < kingLogic(targetPosition).size(); i++) {

            String piece = kingLogic(targetPosition).get(i);

            if (board.getPiece(piece) == null) {
                validMoves.add(piece);
            } else {
                if (this.getColor() != board.getPiece(piece).getColor()) {
                    validMoves.add(piece);
                }
            }
        }
        return validMoves;
    }
}