package ar.com.manflack.expensemanager.util;

import ar.com.manflack.expensemanager.app.model.User;

public class JWTUtil
{
    public static User getUserByContext()
    {
        return new User(null, null, null, null);
    }
}
