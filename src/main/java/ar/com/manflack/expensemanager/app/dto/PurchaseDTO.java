package ar.com.manflack.expensemanager.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO
{
    Long id;

    Integer price;

    LocalDateTime purchaseDate;

    String description;

    List<PurchaseDTO> purchasesDetails;

    public PurchaseDTO(Integer price, LocalDateTime purchaseDate, String description){
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.description = description;
        this.purchasesDetails = null;
    }

    public PurchaseDTO(Integer price, LocalDateTime purchaseDate, String description, List<PurchaseDTO> purchasesDetails){
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.description = description;
        this.purchasesDetails = purchasesDetails;
    }
}
