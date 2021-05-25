package com.example.petclinic.controller;

import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.entities.Veterinarian;
import com.example.petclinic.repository.PetOwnerRepository;
import com.example.petclinic.repository.VeterinarianRepository;
import com.example.petclinic.services.PetOwnerService;
import com.example.petclinic.services.VeterinarianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CRUDController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Autowired
    PetOwnerService petOwnerService;


    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Autowired
    VeterinarianService veterinarianService;


    @RequestMapping("/list-veterinarians")
    public String handleRequestVet(Model model) {

        List<Veterinarian> veterinarians = veterinarianRepository.findAll();
        model.addAttribute("veterinarians", veterinarians);
        return "list-veterinarians";
    }


    @RequestMapping("/list-petowners")
    public String handleRequest(Model model) {

        List<PetOwner> petowners = petOwnerRepository.findAll();
        model.addAttribute("petowners", petowners);
        return "list-petowners";
    }

    @GetMapping(value = {"/add-petowner"})
    public String showAddUser(Model model) {
        PetOwner petowner = new PetOwner();
        model.addAttribute("add", true);
        model.addAttribute("petowner", petowner);

        return "add-petowner";
    }

    @PostMapping(value = "/add-petowner")
    public String addUser(Model model,
                          @ModelAttribute("petowner") PetOwner petOwner) {
        try {
            PetOwner newPetowner = petOwnerRepository.save(petOwner);
            return "add-petowner" ;
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", true);
            return "add-petowner";
        }
    }



}
