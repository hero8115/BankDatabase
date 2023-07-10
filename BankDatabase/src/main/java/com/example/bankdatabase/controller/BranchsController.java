package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.BranchsDTO;
import com.example.bankdatabase.entity.Adress;
import com.example.bankdatabase.entity.Bank;
import com.example.bankdatabase.entity.Branchs;
import com.example.bankdatabase.repository.AdressRepository;
import com.example.bankdatabase.repository.BankRepository;
import com.example.bankdatabase.repository.BranchsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BranchsController {
    @Autowired
    AdressRepository adressRepository;

    @Autowired
    BranchsRepository branchsRepository;

    @Autowired
    BankRepository bankRepository;

    @RequestMapping(value = "/branchs", method = RequestMethod.GET)
    public List<Branchs> branchsList(){
        return branchsRepository.findAll();
    }

    @RequestMapping(value = "/branchs", method = RequestMethod.POST)
    public String addbranchs(@RequestBody BranchsDTO branchsDTO){
        Optional<Bank> byId = bankRepository.findById(branchsDTO.getBank_id());
        if (byId.isPresent()){
            Adress adress = new Adress();
            Branchs branchs = new Branchs();
            branchs.setBranchs_amount(branchsDTO.getBranchs_amount());
            branchs.setName(branchsDTO.getName());
            branchs.setCreated_at(branchsDTO.getCreated_at());
            branchs.setBank(byId.get());
            adress.setCity(branchsDTO.getCity());
            adress.setStreet(branchsDTO.getStreet());
            adressRepository.save(adress);
            branchs.setAdress(adress);
            branchsRepository.save(branchs);
            return "Filial qo'shildi";
        }
        return "Bank topilmadi";
    }
}
