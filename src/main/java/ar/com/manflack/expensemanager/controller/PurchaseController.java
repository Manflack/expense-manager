package ar.com.manflack.expensemanager.controller;

import ar.com.manflack.expensemanager.app.ResponseApi;
import ar.com.manflack.expensemanager.app.dto.PurchaseDTO;
import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.controller.request.PurchaseRequest;
import ar.com.manflack.expensemanager.exception.InvalidPurchaseException;
import ar.com.manflack.expensemanager.exception.UserNotExistException;
import ar.com.manflack.expensemanager.service.PurchaseService;
import ar.com.manflack.expensemanager.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/purchases")
public class PurchaseController
{
    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService)
    {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/get/all")
    public ResponseApi getAllPurchases() throws UserNotExistException
    {
        User user = JWTUtil.getUserByContext();
        return new ResponseApi(purchaseService.getAllPurchases(user), HttpStatus.OK);
    }

    @PostMapping("/make")
    public ResponseApi makePurchase(PurchaseRequest purchaseRequest) throws InvalidPurchaseException
    {
        PurchaseDTO response =
                purchaseService.makePurchase(purchaseRequest.getPurchaseDTO(), purchaseRequest.getCardDTO());
        return new ResponseApi(response, HttpStatus.OK);
    }
}
