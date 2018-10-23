package army.Exceptions;

public class UnauthenticatedUserException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UnauthenticatedUserException() {
        super();
    }

    public UnauthenticatedUserException(String message) {
        super(message);
    }

    public UnauthenticatedUserException(String message, Throwable ex) {
        super(message, ex);
    }
}
