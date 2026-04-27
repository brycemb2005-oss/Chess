/*
    All pieces move
    Movement(): accepts valid places that the piece can move and prompts user to pick a square
    among the valid places that the piece can move, then it passes that information to the board
    which updates the board with the new piece.
 */

import java.util.ArrayList;

abstract class Piece {

    public enum Color {WHITE, BLACK}

    protected ChessBoard board;
    protected Color color;
    protected String position;

    public Piece(ChessBoard board, Color color) {
        this.board = board;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    String getPosition() {
        // Return current algebraic position string (e. g. "e4")
        return this.position;
    }

    void setPosition(String position) throws IllegalPositionException {
        // Validate then store position; throw if format or range is invalid
        this.position = position;
    }

    abstract ArrayList<String> legalMoves();
        // Return all  legal destination squares. Must account for board edges,
        // blocking by same-color pieces, and ability to capture opposite-color pieces. En passant not required
}
