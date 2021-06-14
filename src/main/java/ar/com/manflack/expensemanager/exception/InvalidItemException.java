package ar.com.manflack.expensemanager.exception;

public class InvalidItemException extends GenericException
{

    public static final String CODE = "ITEM_NOT_VALID";
    public static final String MESSAGE = "Invalid item provided";

    public InvalidItemException()
    {
        super(CODE, MESSAGE);
    }
}
