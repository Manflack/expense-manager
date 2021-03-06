package ar.com.manflack.expensemanager.repository;

import ar.com.manflack.expensemanager.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);
}
