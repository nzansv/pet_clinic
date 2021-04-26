package com.example.petclinic.controller;


import com.example.petclinic.entities.Account;
import com.example.petclinic.services.AccountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Api(value = "Api Controller class")
public class AccountController {

    @Autowired
    private AccountService accountService;

   @GetMapping
    public List<Account> getAllAccounts(){
       return accountService.getAll();
   }

   @GetMapping("/create")
    public void createAccountByUsernamePassword(String username, String password){
       Account account = new Account();
       account.setPassword(password);
       account.setUsername(username);

       accountService.create(account);
   }

   @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @PathVariable Account account) {
       System.out.println("id = [" + id + "]");
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       System.out.println("authentication.getName() = " + authentication.getName());

       accountService.updateUser(id, account);
   }
}
