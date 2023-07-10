package com.example.bankdatabase.repository;

import com.example.bankdatabase.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

    boolean existsByName(String name);
}
