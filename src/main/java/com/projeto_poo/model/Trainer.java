/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto_poo.model;

/**
 *
 * @author Yago Elias
 */
public class Trainer {
    private Person person = new Person();
    
    public Trainer() {}
    
    public Trainer(String name, String cpf, String date_birth) {
        person = new Person(name, cpf, date_birth);
    }
    
    public String getName() {
        return person.getName();
    }
    
    public String getCpf() {
        return person.getCpf();
    }
    
    public String getDateBirth() {
        return person.getDateBirth();
    }
    
    public String getAddressStreet() {
        return person.getAddressStreat();
    }
    
    public String getAddressNumber() {
        return person.getAddressNumber();
    }
    
    public String getAddressNeighborhood() {
        return person.getAddressNeighborhood();
    }
    
    public String getAddressCity() {
        return person.getAddressCity();
    }
    
    public String getAddressState() {
        return person.getAddressState();
    }
    
    public String getAdressFull() {
        return person.getAddressFull();
    }
    
    public void setName(String name) {
        person.setName(name);
    }

    public void setCpf(String cpf) {
        person.setCpf(cpf);
    }

    public void setDate_birth(String date_birth) {
        person.setDateBirth(date_birth);
    }

    public void setAddress(String street, String number, String neighborhood) {
        person.setAddress(street, number, neighborhood);
    }
    
    public void setAddressFull(String street, String number, String neighborhood, String city, String state) {
        person.setAddressFull(street, number, neighborhood, city, state);
    }
}
