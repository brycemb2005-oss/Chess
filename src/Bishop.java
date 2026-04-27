import java.util.ArrayList;

class Bishop extends Piece {

    public Bishop(ChessBoard board, Color color) {
        super(board, color);
    }

    public boolean bMoves(String position, ArrayList<String> validMoves) {

        boolean decision = false;

        if (board.getPiece(position) == null) {
            validMoves.add(position);
        } else {
            if (this.getColor() != board.getPiece(position).getColor()) {
                validMoves.add(position);
            }
            decision = true;
        }

        return decision;
    }

    public ArrayList<String> legalMoves() {
        ArrayList<String> validMoves = new ArrayList<>();

        String targetPosition = getPosition();

        int column = Character.toLowerCase(targetPosition.charAt(0));
        int row = Character.getNumericValue(targetPosition.charAt(1));

        int offset = 1;

        // up-right
        while (true) {

            int newNumber = (row - offset);
            char newLetter = (char) (column + offset);

            if (newNumber < 1 || newLetter > 'h') {
                offset = 1;
                break;
            }

            String up = (newLetter) + String.valueOf(newNumber);

            if (bMoves(up, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }

        // up-left
        while (true) {

            int newNumber = (row - offset);
            char newLetter = (char) (column - offset);

            if (newNumber < 1 || newLetter < 'a') {
                offset = 1;
                break;
            }

            String down = (newLetter) + String.valueOf(newNumber);

            if (bMoves(down, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }

        // down-left
        while (true) {

            int newNumber = (row + offset);
            char newLetter = (char) (column - offset);

            if (newNumber > 8 || newLetter < 'a') {
                offset = 1;
                break;
            }

            String right = newLetter + String.valueOf(newNumber);

            if (bMoves(right, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }

        // down-right
        while (true) {

            int newNumber = (row + offset);
            char newLetter = (char) (column + offset);

            if (newNumber > 8 || newLetter > 'h') {
                offset = 1;
                break;
            }

            String left = newLetter + String.valueOf(newNumber);

            if (bMoves(left, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }
        return validMoves;
    }
}
