package ar.com.manflack.expensemanager.app.factory;

import ar.com.manflack.expensemanager.app.dto.ItemDTO;
import ar.com.manflack.expensemanager.app.model.Item;
import ar.com.manflack.expensemanager.exception.InvalidItemException;
import org.springframework.stereotype.Component;

@Component
public class ItemFactory
{
    public static Item convertItemDTOToItem(ItemDTO itemDTO) throws InvalidItemException
    {
        if (itemDTO.getDetailsItems() != null && itemDTO.getDetailsItems().size() != 0)
            return new Item(itemDTO.getPrice(), itemDTO.getPurchaseDate(), itemDTO.getDescription(), itemDTO.getDetailsItems());

        return new Item(itemDTO.getPrice(), itemDTO.getPurchaseDate(), itemDTO.getDescription());
    }

    public static ItemDTO convertItemToItemDTO(Item item)
    {
        return new ItemDTO(item.getPrice(), item.getPurchaseDate(), item.getDescription(), item.getDetailsItems());
    }
}
