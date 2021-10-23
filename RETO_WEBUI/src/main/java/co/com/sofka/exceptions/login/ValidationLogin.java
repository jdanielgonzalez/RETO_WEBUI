package co.com.sofka.exceptions.login;

public class ValidationLogin extends AssertionError{
    public static final String VALIDATION_DO_NOT_MATCH = "The validation don't match. %s";
    public static final String VALIDATION_DO_NOT_FOUND = "The validation don't found. %s";

    public ValidationLogin(String message, Throwable cause)
    {
        super (message, cause);
    }
}
