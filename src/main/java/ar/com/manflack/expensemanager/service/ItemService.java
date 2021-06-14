package ar.com.manflack.expensemanager.service;

import java.util.List;

import ar.com.manflack.expensemanager.app.dto.ItemDTO;
import ar.com.manflack.expensemanager.app.model.User;

public interface ItemService
{
    List<ItemDTO> getAll(User user);
}
