package com.example.petclinic.repository;


import com.example.petclinic.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getById(Long id);
    Account findByUsername(String username);
}
