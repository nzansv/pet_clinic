package com.example.petclinic.exceptions;

public class AddPetOwnerException extends RuntimeException {
    public AddPetOwnerException() {
        super("Cannot create new Petowner");
    }
    public AddPetOwnerException(String message) {
        super(message);
    }
}
