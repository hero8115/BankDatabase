package com.example.bankdatabase.repository;

import com.example.bankdatabase.entity.Branchs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchsRepository extends JpaRepository<Branchs, Integer> {
}
