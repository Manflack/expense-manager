package ar.com.manflack.expensemanager.controller;

import ar.com.manflack.expensemanager.app.ResponseApi;
import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.service.ItemService;
import ar.com.manflack.expensemanager.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/api/items")
public class ItemController
{
    private ItemService itemService;

    public ItemController(ItemService itemService)
    {
        this.itemService = itemService;
    }

    @GetMapping("/get/all")
    public ResponseApi getAllItems()
    {
        User user = JWTUtil.getUserByContext();
        return new ResponseApi(itemService.getAll(user), HttpStatus.OK);
    }
}
