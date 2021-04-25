package com.example.petclinic.services;


import com.example.petclinic.entities.Account;

import java.util.List;

public interface AccountService {
    void create(Account account);
    List<Account> getAll();
    Account getById(Long id);
    void updateUser(Long id, Account user);
}


