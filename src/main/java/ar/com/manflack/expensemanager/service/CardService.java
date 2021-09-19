package ar.com.manflack.expensemanager.service;

import java.util.List;

import ar.com.manflack.expensemanager.app.dto.CardDTO;
import ar.com.manflack.expensemanager.app.model.User;

public interface CardService
{
    CardDTO create(CardDTO cardDTO, User user);

    List<CardDTO> getAll();
}
