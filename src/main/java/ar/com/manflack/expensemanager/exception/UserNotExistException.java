package ar.com.manflack.expensemanager.exception;

public class UserNotExistException extends GenericException
{
    public static final String CODE = "USER_NOT_EXISTS";
    public static final String MESSAGE = "Invalid user";

    public UserNotExistException()
    {
        super(CODE, MESSAGE);
    }
}
