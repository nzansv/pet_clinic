package com.example.petclinic.controller;

import com.example.petclinic.entities.PetOwner;
import com.example.petclinic.exceptions.AddPetOwnerException;
import com.example.petclinic.exceptions.ErrorResponse;
import com.example.petclinic.repository.PetOwnerRepository;
import com.example.petclinic.services.PetOwnerService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Api(value = "CRUD Petowner Controller class", description = "This class allows to interact with PetOwner object")
public class CRUDController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Autowired
    PetOwnerService petOwnerService;


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
        } catch (AddPetOwnerException ex) {
            log.error("Exception handled: "+ ex.getMessage(), ex);
            ErrorResponse errorResponse = new ErrorResponse("DIVIDE_BY_ZERO_ERROR", ex.getMessage());
            return "add-petowner" ;
        } catch (Exception ex) {
            log.error("Exception handled: "+ ex.getMessage(), ex);
            ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR", "Произошла системсная ошибка. Обратитесь к админу.");
            return "add-petowner" ;        }
    }

}
