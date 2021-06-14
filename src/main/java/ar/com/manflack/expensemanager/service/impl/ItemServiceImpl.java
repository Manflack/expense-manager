package ar.com.manflack.expensemanager.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.manflack.expensemanager.app.dto.ItemDTO;
import ar.com.manflack.expensemanager.app.factory.ItemFactory;
import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.repository.ItemRepository;
import ar.com.manflack.expensemanager.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService
{
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDTO> getAll(User user)
    {
        return itemRepository.findAllByUser(user)
                .stream()
                .map(ItemFactory::convertItemToItemDTO)
                .collect(Collectors.toList());
    }
}
