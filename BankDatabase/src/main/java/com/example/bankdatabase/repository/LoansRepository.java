package com.example.bankdatabase.repository;

import com.example.bankdatabase.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Integer> {
    List<Loans> findAllById(Integer id);
}
