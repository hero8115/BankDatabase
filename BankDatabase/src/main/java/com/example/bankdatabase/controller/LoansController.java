package com.example.bankdatabase.controller;

import com.example.bankdatabase.dto.LoanDTO;
import com.example.bankdatabase.entity.Accounts;
import com.example.bankdatabase.entity.Branchs;
import com.example.bankdatabase.entity.Loans;
import com.example.bankdatabase.repository.AccountRepository;
import com.example.bankdatabase.repository.BranchsRepository;
import com.example.bankdatabase.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoansController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BranchsRepository branchsRepository;

    @Autowired
    LoansRepository loansRepository;

    @RequestMapping(value = "/loan", method = RequestMethod.GET)
    public List<Loans> loansList(){
        return loansRepository.findAll();
    }

    @RequestMapping(value = "/loan/{id}", method = RequestMethod.POST)
    public List<Loans> loansListbyId(@PathVariable Integer id){
        return loansRepository.findAllById(id);
    }

    @RequestMapping(value = "/loan", method = RequestMethod.POST)
    public String addloan(@RequestBody LoanDTO loanDTO){
        Optional<Accounts> byId = accountRepository.findById(loanDTO.getAccount_id());
        Optional<Branchs> byId1 = branchsRepository.findById(loanDTO.getBranchs_id());
        if (byId.isPresent() && byId1.isPresent()){
            Branchs branchs = byId1.get();
            Loans loans = new Loans();
            loans.setAmount(loanDTO.getAmount());
            loans.setDate(loanDTO.getDate());
            loans.setAccounts(byId.get());
            loans.setBranchs(branchs);
            branchs.setBranchs_amount(branchs.getBranchs_amount()-loanDTO.getAmount());
            branchsRepository.save(branchs);
            loansRepository.save(loans);
            return loanDTO.getAmount()+" so'm kredit olindi, qaytarish kerak bo'lgan miqdor "+Math.pow(1.12, loanDTO.getYear())*loanDTO.getAmount();
        }
        return "Account topilmadi";
    }
}
