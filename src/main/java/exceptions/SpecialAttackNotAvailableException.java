package exceptions;

/**
 * Created by mresende on 13/11/16.
 */
public class SpecialAttackNotAvailableException extends Exception {

    public SpecialAttackNotAvailableException() {
        this("The special attack is not available for the class");
    }

    public SpecialAttackNotAvailableException(String message) {
        super(message);
    }
}
