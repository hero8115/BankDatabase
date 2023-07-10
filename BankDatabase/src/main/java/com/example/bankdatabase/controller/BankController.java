package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.BankDTO;
import com.example.bankdatabase.entity.Adress;
import com.example.bankdatabase.entity.Bank;
import com.example.bankdatabase.repository.AdressRepository;
import com.example.bankdatabase.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BankController {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    AdressRepository adressRepository;

    @RequestMapping(value = "/bank", method = RequestMethod.GET)
    public List<Bank> bankList(){
        return bankRepository.findAll();
    }

    @RequestMapping(value = "/bank", method = RequestMethod.POST)
    public String addbank(@RequestBody BankDTO bankDTO) {
        boolean name = bankRepository.existsByName(bankDTO.getName());
        if (!name) {
            Bank bank = new Bank();
            Adress adress = new Adress();
            bank.setName(bankDTO.getName());
            adress.setCity(bankDTO.getCity());
            adress.setStreet(bankDTO.getStreet());
            adressRepository.save(adress);
            bank.setAdress(adress);
            bankRepository.save(bank);
            return "Bank qo'shildi";
        }
        return "Bunday nomli bank bo'lishi mumkin";
    }


}
