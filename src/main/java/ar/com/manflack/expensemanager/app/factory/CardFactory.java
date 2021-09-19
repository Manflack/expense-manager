package ar.com.manflack.expensemanager.app.factory;

import ar.com.manflack.expensemanager.app.dto.CardDTO;
import ar.com.manflack.expensemanager.app.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardFactory
{
    public static CardDTO entityToDTO(Card card) {
        return CardDTO.builder()
                .id(card.getId())
                .lastFourNumbers(card.getLastFourNumbers())
                .title(card.getTitle())
                .build();
    }
}
