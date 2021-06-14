package ar.com.manflack.expensemanager.app.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import ar.com.manflack.expensemanager.exception.InvalidItemException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Items")
public class Item
{
    @Id
    private UUID id;

    private Integer price;

    private LocalDateTime purchaseDate;

    private String description;

    @Setter(AccessLevel.NONE)
    @OneToMany
    private List<Item> detailsItems;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public Item(Integer price, LocalDateTime purchaseDate, String description, List<Item> detailsItems)
            throws InvalidItemException
    {
        if (detailsItems == null || detailsItems.size() == 0 || detailsItems.stream()
                .anyMatch(item -> item.getDetailsItems() != null))
        {
            throw new InvalidItemException();
        }
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.description = description;
    }

    public Item(Integer price, LocalDateTime purchaseDate, String description)
    {
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.description = description;
    }
}
