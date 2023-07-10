package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.CardDTO;
import com.example.bankdatabase.entity.Card;
import com.example.bankdatabase.entity.Customers;
import com.example.bankdatabase.repository.CardRepository;
import com.example.bankdatabase.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public List<Card> cardList(){
        return cardRepository.findAll();
    }

    @RequestMapping(value = "/card", method = RequestMethod.POST)
    public String addcard(@RequestBody CardDTO cardDTO){
        Optional<Customers> byId = customerRepository.findById(cardDTO.getCustomer_id());
        if (byId.isPresent()){
            Card card = new Card();
            card.setBalance(cardDTO.getBalance());
            card.setNumber(cardDTO.getNumber());
            card.setLifetime(cardDTO.getLifetime());
            card.setCustomers(byId.get());
            cardRepository.save(card);
            return "Karta qo'shildi";
        }
        return "Mijoz topilmadi";
    }

}
