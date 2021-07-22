package ar.com.manflack.expensemanager.repository;

import java.util.List;
import java.util.UUID;

import ar.com.manflack.expensemanager.app.model.Purchase;
import ar.com.manflack.expensemanager.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID>
{
    List<Purchase> findAllByUser(User user);
}
