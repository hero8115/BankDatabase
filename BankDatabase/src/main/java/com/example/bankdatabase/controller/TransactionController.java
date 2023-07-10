package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.TransactionDTO;
import com.example.bankdatabase.entity.Card;
import com.example.bankdatabase.entity.Transactions;
import com.example.bankdatabase.repository.CardRepository;
import com.example.bankdatabase.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionsRepository transactionsRepository;

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public List<Transactions> transactionsList(){
        return transactionsRepository.findAll();
    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.POST)
    public List<Transactions> transactionsListbyId(@PathVariable Integer id){
        return transactionsRepository.findAllById(id);
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public String addTransaction(@RequestBody TransactionDTO transactionDTO){
        Optional<Card> byId = cardRepository.findById(transactionDTO.getCard_id());
        if (byId.isPresent()){
            Transactions transactions = new Transactions();
            transactions.setType(transactionDTO.getType());
            transactions.setDate(transactionDTO.getDate());
            transactions.setCard(byId.get());
            transactionsRepository.save(transactions);
            return "Operatsiya amalga oshirildi";
        }
        return "Card topilmadi";
    }

}
