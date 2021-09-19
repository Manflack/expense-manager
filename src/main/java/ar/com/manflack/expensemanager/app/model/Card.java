package ar.com.manflack.expensemanager.app.model;

import javax.persistence.*;

import ar.com.manflack.expensemanager.app.enums.CardEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cards")
public class Card
{
    @Id
    Long id;

    CardEnum title;

    Long lastFourNumbers;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public static CardBuilder builder()
    {
        return new CardBuilder();
    }

    public static final class CardBuilder
    {
        private Card card;

        private CardBuilder()
        {
            card = new Card();
        }

        public CardBuilder id(Long id)
        {
            card.setId(id);
            return this;
        }

        public CardBuilder title(CardEnum title)
        {
            card.setTitle(title);
            return this;
        }

        public CardBuilder lastFourNumbers(Long lastFourNumbers)
        {
            card.setLastFourNumbers(lastFourNumbers);
            return this;
        }

        public CardBuilder user(User user)
        {
            card.setUser(user);
            return this;
        }

        public Card build()
        {
            return card;
        }
    }
}
