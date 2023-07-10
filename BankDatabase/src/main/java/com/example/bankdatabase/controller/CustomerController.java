package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.CustomersDTO;
import com.example.bankdatabase.entity.Branchs;
import com.example.bankdatabase.entity.Customers;
import com.example.bankdatabase.repository.BranchsRepository;
import com.example.bankdatabase.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BranchsRepository branchsRepository;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customers> customersList(){
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String addcustomer(@RequestBody CustomersDTO customersDTO){
        Optional<Branchs> byId = branchsRepository.findById(customersDTO.getBranchs_id());
        if (byId.isPresent()){
            Customers customers = new Customers();
            customers.setFirstname(customersDTO.getFirstname());
            customers.setLastname(customersDTO.getLastname());
            customers.setPhonenumber(customersDTO.getPhonenumber());
            customers.setBranchs(byId.get());
            customerRepository.save(customers);
            return "Mijoz qo'shildi";
        }
        return "Filial topilmadi";
    }
}
