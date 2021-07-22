package ar.com.manflack.expensemanager.service;

import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.exception.UserNotExistException;

public interface UserService
{
    User getUserByEmail(String email) throws UserNotExistException;
}
