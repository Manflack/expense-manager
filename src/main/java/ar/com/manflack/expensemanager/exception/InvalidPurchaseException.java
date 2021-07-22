package ar.com.manflack.expensemanager.exception;

public class InvalidPurchaseException extends GenericException
{

    public static final String CODE = "PURCHASE_NOT_VALID";
    public static final String MESSAGE = "Invalid purchase provided";

    public InvalidPurchaseException()
    {
        super(CODE, MESSAGE);
    }
}
