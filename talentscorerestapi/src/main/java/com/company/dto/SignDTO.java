package com.company.dto;


import com.company.entity.User;

public class SignDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;

    private SignDTO(){

    }
    public SignDTO(User u){
        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.email = u.getEmail();
        this.password = u.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
