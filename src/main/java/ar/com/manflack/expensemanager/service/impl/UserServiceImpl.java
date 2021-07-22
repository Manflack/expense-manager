package ar.com.manflack.expensemanager.service.impl;

import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.exception.UserNotExistException;
import ar.com.manflack.expensemanager.repository.UserRepository;
import ar.com.manflack.expensemanager.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) throws UserNotExistException
    {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new UserNotExistException();

        return user;
    }
}
