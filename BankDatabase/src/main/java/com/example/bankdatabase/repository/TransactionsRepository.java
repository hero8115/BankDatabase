package com.example.bankdatabase.repository;

import com.example.bankdatabase.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {


    List<Transactions> findAllById(Integer id);
}
