package ar.com.manflack.expensemanager.app.enums;

public enum CardEnum
{
    AMEX("AMEX"),
    VISA("VISA"),
    MASTERCARD("MASTER");

    private final String tittle;

    CardEnum(String tittle)
    {
        this.tittle = tittle;
    }

    @Override
    public String toString()
    {
        return tittle;
    }
}
