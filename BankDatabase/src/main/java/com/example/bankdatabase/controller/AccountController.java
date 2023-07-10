package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.AccountDTO;
import com.example.bankdatabase.entity.Accounts;
import com.example.bankdatabase.entity.Customers;
import com.example.bankdatabase.repository.AccountRepository;
import com.example.bankdatabase.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public List<Accounts> accountsList(){
        return accountRepository.findAll();
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.POST)
    public List<Accounts> accountsListbyId(@PathVariable Integer id){
        return accountRepository.findAllById(id);
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String addAccount(@RequestBody AccountDTO accountDTO){
        Optional<Customers> byId = customerRepository.findById(accountDTO.getCustomer_id());
        if (byId.isPresent()){
            Accounts accounts = new Accounts();
            accounts.setBalance(accountDTO.getBalance());
            accounts.setCurrency(accountDTO.getCurrency());
            accounts.setCreated_at(accountDTO.getCreated_at());
            accounts.setCustomers(byId.get());
            accountRepository.save(accounts);
            return "Account qo'shildi";
        }
        return "Mijoz topilmadi";
    }

}
