package com.example.petclinic.controller;

import com.example.petclinic.entities.Account;
import com.example.petclinic.entities.Role;
import com.example.petclinic.entities.RoleType;
import com.example.petclinic.repository.AccountRepository;
import com.example.petclinic.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {

    @Autowired
    private AccountRepository userRepo;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/reg")
    public String registration(){
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(Account user, Map<String, Object> model){
        Account userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.put("message","User exists!");
            return "reg";
        }
        user.setRoles(Arrays.asList(roleRepository.findByName("USER")));
        userRepo.save(user);
        return "redirect:/login";
    }

}
