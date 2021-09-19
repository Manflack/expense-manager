package ar.com.manflack.expensemanager.app.model;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Purchases")
public class Purchase
{
    @Id
    private UUID id;

    private Integer price;

    private LocalDateTime purchaseDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public static PurchaseBuilder builder()
    {
        return new PurchaseBuilder();
    }

    public static final class PurchaseBuilder
    {
        private Purchase purchase;

        private PurchaseBuilder()
        {
            purchase = new Purchase();
        }

        public PurchaseBuilder id(UUID id)
        {
            purchase.setId(id);
            return this;
        }

        public PurchaseBuilder price(Integer price)
        {
            purchase.setPrice(price);
            return this;
        }

        public PurchaseBuilder purchaseDate(LocalDateTime purchaseDate)
        {
            purchase.setPurchaseDate(purchaseDate);
            return this;
        }

        public PurchaseBuilder description(String description)
        {
            purchase.setDescription(description);
            return this;
        }

        public PurchaseBuilder user(User user)
        {
            purchase.setUser(user);
            return this;
        }

        public Purchase build()
        {
            return purchase;
        }
    }
}
