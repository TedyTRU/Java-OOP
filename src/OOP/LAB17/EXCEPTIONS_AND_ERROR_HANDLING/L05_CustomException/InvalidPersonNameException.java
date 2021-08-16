package OOP.LAB17.EXCEPTIONS_AND_ERROR_HANDLING.L05_CustomException;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
