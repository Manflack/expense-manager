package ar.com.manflack.expensemanager.app.dto;

import ar.com.manflack.expensemanager.app.enums.CardEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO
{
    Long id;

    CardEnum title;

    Long lastFourNumbers;

    public static CardDTOBuilder builder()
    {
        return new CardDTOBuilder();
    }

    public static final class CardDTOBuilder
    {
        private CardDTO cardDTO;

        private CardDTOBuilder()
        {
            cardDTO = new CardDTO();
        }

        public CardDTOBuilder id(Long id)
        {
            cardDTO.setId(id);
            return this;
        }

        public CardDTOBuilder title(CardEnum title)
        {
            cardDTO.setTitle(title);
            return this;
        }

        public CardDTOBuilder lastFourNumbers(Long lastFourNumbers)
        {
            cardDTO.setLastFourNumbers(lastFourNumbers);
            return this;
        }

        public CardDTO build()
        {
            return cardDTO;
        }
    }
}
