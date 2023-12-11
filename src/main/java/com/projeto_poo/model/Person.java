/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto_poo.model;

/**
 *
 * @author Yago Elias
 */
public class Person {
    private String name, cpf, date_birth;
    
    public Person() {}

    public Person(String name, String cpf, String date_birth) {
        this.name = name;
        this.cpf = cpf;
        this.date_birth = date_birth;
    }
    
    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDateBirth() {
        return date_birth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDateBirth(String date_birth) {
        this.date_birth = date_birth;
    }
}
