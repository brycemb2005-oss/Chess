public class IllegalPositionException extends RuntimeException {

    public IllegalPositionException(String message) {
        super(message);
    }

    public IllegalPositionException(String message, String description) {

        super(message);
        System.err.println(description);

    }

    public IllegalMoveException myMethod() { return null; }

}