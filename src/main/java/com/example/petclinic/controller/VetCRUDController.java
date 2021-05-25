package com.example.petclinic.controller;

import com.example.petclinic.entities.Veterinarian;
import com.example.petclinic.repository.VeterinarianRepository;
import com.example.petclinic.services.VeterinarianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class VetCRUDController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Autowired
    VeterinarianService veterinarianService;


    @RequestMapping("/list-veterinarians")
    public String handleRequest(Model model) {

        List<Veterinarian> veterinarians = veterinarianRepository.findAll();
        model.addAttribute("veterinarians", veterinarians);
        return "list-veterinarians";
    }

    @GetMapping(value = {"/add-veterinarian"})
    public String showAddUser(Model model) {
        Veterinarian veterinarian = new Veterinarian();
        model.addAttribute("add", true);
        model.addAttribute("veterinarian", veterinarian);

        return "add-veterinarian";
    }

    @PostMapping(value = "/add-veterinarian")
    public String addUser(Model model,
                          @ModelAttribute("veterinarian") Veterinarian veterinarian) {
        try {
            Veterinarian newVet = veterinarianRepository.save(veterinarian);
            return "add-veterinarian" ;
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", true);
            return "add-veterinarian";
        }
    }



}
