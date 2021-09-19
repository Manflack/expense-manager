package ar.com.manflack.expensemanager.service;

import java.util.List;

import ar.com.manflack.expensemanager.app.dto.CardDTO;
import ar.com.manflack.expensemanager.app.dto.PurchaseDTO;
import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.exception.InvalidPurchaseException;
import ar.com.manflack.expensemanager.exception.UserNotExistException;

public interface PurchaseService
{
    List<PurchaseDTO> getAllPurchases(User user) throws UserNotExistException;

    PurchaseDTO makePurchase(PurchaseDTO purchaseDTO, CardDTO cardDTO) throws InvalidPurchaseException;
}
