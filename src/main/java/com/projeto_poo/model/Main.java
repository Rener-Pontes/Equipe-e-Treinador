/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto_poo.model;

/**
 *
 * @author Yago Elias
 */
public class Main {
    public static void main(String[] args) {
        Trainer t = new Trainer();
        
        t.setName("Rener");
        t.setCpf("111.222.333-44");
        t.setDate_birth("12/05/2003");
        t.setAddress("rua", "552", "bairro");
        System.out.println(t.getName());
        System.out.println(t.getCpf());
        System.out.println(t.getDateBirth());
        System.out.println(t.getAdressFull());
    }
}