package ar.com.manflack.expensemanager.repository;

import ar.com.manflack.expensemanager.app.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>
{
}
