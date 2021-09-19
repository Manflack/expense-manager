package ar.com.manflack.expensemanager.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.manflack.expensemanager.app.dto.CardDTO;
import ar.com.manflack.expensemanager.app.factory.CardFactory;
import ar.com.manflack.expensemanager.app.model.Card;
import ar.com.manflack.expensemanager.app.model.User;
import ar.com.manflack.expensemanager.repository.CardRepository;
import ar.com.manflack.expensemanager.service.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService
{
    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardDTO create(CardDTO cardDTO, User user)
    {
        Card card = Card.builder()
                .lastFourNumbers(cardDTO.getLastFourNumbers())
                .title(cardDTO.getTitle())
                .user(user)
                .build();

        card = cardRepository.saveAndFlush(card);
        cardDTO.setId(card.getId());

        return cardDTO;
    }

    @Override
    public List<CardDTO> getAll()
    {
        return cardRepository.findAll().stream()
                .map(CardFactory::entityToDTO)
                .collect(Collectors.toList());
    }
}
