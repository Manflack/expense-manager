package ar.com.manflack.expensemanager.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.manflack.expensemanager.app.dto.PurchaseDTO;
import ar.com.manflack.expensemanager.app.factory.PurchaseFactory;
import ar.com.manflack.expensemanager.app.model.Purchase;
import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.exception.InvalidPurchaseException;
import ar.com.manflack.expensemanager.exception.UserNotExistException;
import ar.com.manflack.expensemanager.repository.PurchaseRepository;
import ar.com.manflack.expensemanager.service.PurchaseService;
import ar.com.manflack.expensemanager.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService
{
    private PurchaseRepository purchaseRepository;
    private UserService userService;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository,
            UserService userService)
    {
        this.purchaseRepository = purchaseRepository;
        this.userService = userService;
    }

    @Override
    public List<PurchaseDTO> getAllPurchases(User user) throws UserNotExistException
    {
        user = userService.getUserByEmail(user.getEmail());

        return purchaseRepository.findAllByUser(user)
                .stream()
                .map(PurchaseFactory::EntityToDTO)
                .collect(Collectors.toList());
    }

    public PurchaseDTO createPurchase(PurchaseDTO purchaseDTO) throws InvalidPurchaseException
    {
        Purchase persistentPurchase = PurchaseFactory.DTOToEntity(purchaseDTO);

        persistentPurchase = purchaseRepository.saveAndFlush(persistentPurchase);

        return PurchaseFactory.EntityToDTO(persistentPurchase);
    }
}
