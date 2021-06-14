package ar.com.manflack.expensemanager.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import ar.com.manflack.expensemanager.app.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO
{
    Integer price;

    LocalDateTime purchaseDate;

    String description;

    List<Item> detailsItems;
}
