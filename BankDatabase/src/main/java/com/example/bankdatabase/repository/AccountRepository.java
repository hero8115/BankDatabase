package com.example.bankdatabase.repository;

import com.example.bankdatabase.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Integer> {
    List<Accounts> findAllById(Integer id);
}
