import java.util.ArrayList;

class Queen extends Piece {

    public Queen(ChessBoard board, Color color) {
        super(board, color);
    }

    public boolean qMoves(String position, ArrayList<String> validMoves) {

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

        // Up
        while (true) {

            int newNumber = (row - offset);

            if (newNumber < 1) {
                offset = 1;
                break;
            }

            String up = (char) (column) + String.valueOf(newNumber);

            if (qMoves(up, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }

        // Down
        while (true) {

            int newNumber = (row + offset);

            if (newNumber > 8) {
                offset = 1;
                break;
            }

            String down = (char) (column) + String.valueOf(newNumber);

            if (qMoves(down, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }

        // Right
        while (true) {

            char newLetter = (char) (column + offset);

            if (newLetter > 'h') {
                offset = 1;
                break;
            }

            String right = newLetter + String.valueOf(row);

            if (qMoves(right, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }

        // Left
        while (true) {

            char newLetter = (char) (column - offset);

            if (newLetter < 'a') {
                offset = 1;
                break;
            }

            String left = newLetter + String.valueOf(row);

            if (qMoves(left, validMoves)) {
                break;
            } else {offset = offset + 1;}
        }

        // up-right
        while (true) {

            int newNumber = (row - offset);
            char newLetter = (char) (column + offset);

            if (newNumber < 1 || newLetter > 'h') {
                offset = 1;
                break;
            }

            String up = (newLetter) + String.valueOf(newNumber);

            if (qMoves(up, validMoves)) {
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

            if (qMoves(down, validMoves)) {
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

            if (qMoves(right, validMoves)) {
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

            if (qMoves(left, validMoves)) {
                offset = 1;
                break;
            } else {offset = offset + 1;}
        }

        return validMoves;
    }
}
