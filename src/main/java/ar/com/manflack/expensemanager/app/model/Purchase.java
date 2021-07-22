package ar.com.manflack.expensemanager.app.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
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

    @Setter(AccessLevel.NONE)
    @OneToMany
    private List<Purchase> purchasesDetails;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public Purchase(Integer price, LocalDateTime purchaseDate, String description, List<Purchase> purchasesDetails)
    {
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.description = description;
        this.purchasesDetails = purchasesDetails;
    }

    public Purchase(Integer price, LocalDateTime purchaseDate, String description)
    {
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.description = description;
    }
}
