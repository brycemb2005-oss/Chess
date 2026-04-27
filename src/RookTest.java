//import static org.junit.jupiter.api.Assertions.*;
//
//class RookTest {
//
//    Rook rook;
//
//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//        rook = new Rook();
//    }
//
//    void testLegalMoves() {
//        // Set row to 1
//        rook.setRow(1);
//        // set column to 1
//        rook.setColumn(1);
//        // Call legal Move
//        var legalMoves = rook.legalMoves();
//        // Ensure return value includes "b1", "b2", "b3", "b4"..., "a2", "c2"...
//        assertEquals("b1", legalMoves.getFirst());
//    }
//
//}