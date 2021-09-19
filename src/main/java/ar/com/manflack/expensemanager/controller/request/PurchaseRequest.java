package ar.com.manflack.expensemanager.controller.request;

import ar.com.manflack.expensemanager.app.dto.CardDTO;
import ar.com.manflack.expensemanager.app.dto.PurchaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest
{
    private PurchaseDTO purchaseDTO;

    private CardDTO cardDTO;
}
