package ar.com.manflack.expensemanager.app.factory;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.manflack.expensemanager.app.dto.PurchaseDTO;
import ar.com.manflack.expensemanager.app.model.Purchase;
import ar.com.manflack.expensemanager.exception.InvalidPurchaseException;
import org.springframework.stereotype.Component;

@Component
public class PurchaseFactory
{
    public static Purchase DTOToEntity(PurchaseDTO purchaseDTO) throws InvalidPurchaseException
    {
        List<Purchase> purchases =
                purchaseDTO.getPurchasesDetails().stream().map(PurchaseFactory::convertSingleDTO).collect(Collectors.toList());

        if (purchaseDTO.getPurchasesDetails() != null && purchaseDTO.getPurchasesDetails().size() != 0)
            return new Purchase(purchaseDTO.getPrice(), purchaseDTO.getPurchaseDate(), purchaseDTO.getDescription(),
                    purchases);

        return new Purchase(purchaseDTO.getPrice(), purchaseDTO.getPurchaseDate(), purchaseDTO.getDescription());
    }

    public static PurchaseDTO EntityToDTO(Purchase purchase)
    {
        List<PurchaseDTO> purchases =
                purchase.getPurchasesDetails().stream().map(PurchaseFactory::convertSingleEntity).collect(Collectors.toList());
        return new PurchaseDTO(purchase.getPrice(), purchase.getPurchaseDate(), purchase.getDescription(), purchases);
    }

    private static PurchaseDTO convertSingleEntity(Purchase purchase)
    {
        return new PurchaseDTO(purchase.getPrice(), purchase.getPurchaseDate(), purchase.getDescription());
    }

    private static Purchase convertSingleDTO(PurchaseDTO purchaseDTO)
    {
        return new Purchase(purchaseDTO.getPrice(), purchaseDTO.getPurchaseDate(), purchaseDTO.getDescription());
    }
}
