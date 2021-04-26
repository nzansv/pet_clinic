package com.example.petclinic.entities;
import org.springframework.security.core.GrantedAuthority;
public enum RoleType implements GrantedAuthority{
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
