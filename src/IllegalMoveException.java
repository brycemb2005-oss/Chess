public class IllegalMoveException extends RuntimeException {

    public IllegalMoveException(String message) {
        super(message);
    }

    public IllegalMoveException(String message, String description) {

        super(message);
        System.err.println(description);

    }

    public IllegalMoveException myMethod() {
        return null;
    }

}