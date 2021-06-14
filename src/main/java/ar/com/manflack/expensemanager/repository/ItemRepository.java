package ar.com.manflack.expensemanager.repository;

import java.util.List;
import java.util.UUID;

import ar.com.manflack.expensemanager.app.model.Item;
import ar.com.manflack.expensemanager.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID>
{
    List<Item> findAllByUser(User user);
}
