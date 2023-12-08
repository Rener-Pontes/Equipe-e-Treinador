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
    private Address address = new Address();
    
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

    public String getAddressNumber() {
        return address.getNumber();
    }
    
    public String getAddressStreat() {
        return address.getStreet();
    }
    
    public String getAddressNeighborhood() {
        return address.getNeighborhood();
    }
    
    public String getAddressCity() {
        return address.getCity();
    }
    
    public String getAddressState() {
        return address.getState();
    }
    
    public String getAddressFull() {
        return address.getAddressFull();
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

    public void setAddress(String street, String number, String neighborhood) {
        address.setStreet(street);
        address.setNumber(number);
        address.setNeighborhood(neighborhood);
        address.setCity("");
        address.setState("");
    }
    
    public void setAddressFull(String street, String number, String neighborhood, String city, String state) {
        address.setStreet(street);
        address.setNumber(number);
        address.setNeighborhood(neighborhood);
        address.setCity(city);
        address.setState(state);
    }
}
