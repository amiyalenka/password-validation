package exception;

/**
 * Custom exception which will be thrown in case of invalid password
 */
public class InvalidPasswordException extends Exception {

    /**
     * @param message message to be added in the exception
     */
    public InvalidPasswordException(String message) {
        super(message);
    }

    /**
     * @param message message to be added in the exception
     */
    public InvalidPasswordException(StringBuffer message) {
        super(String.valueOf(message));
    }
}