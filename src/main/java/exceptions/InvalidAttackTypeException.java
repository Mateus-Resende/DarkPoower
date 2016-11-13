package exceptions;

/**
 * Created by mresende on 13/11/16.
 */
public class InvalidAttackTypeException extends Exception {

    private String message;

    public InvalidAttackTypeException(String message) {
        super(message);
    }

    public InvalidAttackTypeException() {
        this("This is not a valid attack");
    }


}
