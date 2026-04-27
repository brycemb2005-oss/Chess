import java.util.ArrayList;

class Knight extends Piece {

    public Knight(ChessBoard board, Color color) {
        super(board, color);
    }

    public void lMoves(String position, ArrayList<String> validMoves) {
        try {
            if (board.getPiece(position) == null) {
                validMoves.add(position);
            } else {
                if (this.getColor() != board.getPiece(position).getColor()) {
                    validMoves.add(position);
                }
            }
        } catch (IllegalPositionException e) {

        }
    }

    public ArrayList<String> legalMoves() {
        ArrayList<String> validMoves = new ArrayList<>();

        String targetPosition = getPosition();

        int column = Character.toLowerCase(targetPosition.charAt(0));
        int row = Character.getNumericValue(targetPosition.charAt(1));

        String upright1 = (char) (column + 1) + String.valueOf(row - 2);
        lMoves(upright1, validMoves);
        String upright2 = (char) (column + 2) + String.valueOf(row - 1);
        lMoves(upright2, validMoves);
        String downright1 = (char) (column + 2) + String.valueOf(row + 1);
        lMoves(downright1, validMoves);
        String downright2 = (char) (column + 1) + String.valueOf(row + 2);
        lMoves(downright2, validMoves);
        String downleft1 = (char) (column - 1) + String.valueOf(row + 2);
        lMoves(downleft1, validMoves);
        String downleft2 = (char) (column - 2) + String.valueOf(row + 1);
        lMoves(downleft2, validMoves);
        String upleft1 = (char) (column - 2) + String.valueOf(row - 1);
        lMoves(upleft1, validMoves);
        String upleft2 = (char) (column - 1) + String.valueOf(row - 2);
        lMoves(upleft2, validMoves);

        return validMoves;
    }
}
