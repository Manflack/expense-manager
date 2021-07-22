package ar.com.manflack.expensemanager.repository;

import ar.com.manflack.expensemanager.app.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
{
    User findByEmail(String email);
}
