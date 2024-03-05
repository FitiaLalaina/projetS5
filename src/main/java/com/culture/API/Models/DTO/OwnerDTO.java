package com.culture.API.Models.DTO;


public class OwnerDTO {
    
    private int idOwner;

    private String name;

    private String email;

    

    public OwnerDTO(int idOwner, String name, String email) {
        this.idOwner = idOwner;
        this.name = name;
        this.email = email;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
}
