package ar.com.manflack.expensemanager.exception;

public class GenericException extends Exception
{
    private final String code;

    public GenericException(String code, String message)
    {
        super(message);
        this.code = code;
    }
}
