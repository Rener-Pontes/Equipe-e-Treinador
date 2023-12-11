/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto_poo.bean;

import com.projeto_poo.core.ApplicationStates;
import com.projeto_poo.model.Trainer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Yago Elias
 */

@Named("trainerBean")
@SessionScoped
public class TrainerBean implements Serializable {
    List<Trainer> trainers = new ArrayList<>();
    Trainer trainer = new Trainer();
    ApplicationStates currentState = ApplicationStates.IDLE;
    int indexChange = -1;
    
    public List<Trainer> getTrainers() {
        return trainers;
    }
    
    public Trainer getTrainer() {
        return trainer;
    }
    
    public Trainer getTrainer(String name) {
        Trainer searchTrainer = null;
        
        for (Trainer tr: trainers) {
            if (trainers.equals(tr)) {
                // return tr;
                searchTrainer = tr;
                break;
            }
        }
        
        return searchTrainer;
    }
    
    public String labelButton() {
        if (currentState == ApplicationStates.EDITING) {
            return "Save";
        }
        return "Add";
    }
    
    public boolean isNewTrainer() {
        return currentState == ApplicationStates.IDLE;
    }
    
    public Trainer newTrainer() {
        trainer = new Trainer();
        currentState = ApplicationStates.CREATING;
        
        return trainer;
    }
    
    public String cancel() {
        this.trainer = null;
        currentState = ApplicationStates.IDLE;
        
        return "trainers";
    }
    
    public void addTrainer() {
        if (currentState == ApplicationStates.EDITING) {
            System.out.println("Vai editar");
            this.trainers.set(indexChange, trainer);
        } else if (currentState == ApplicationStates.CREATING) {
            System.out.println("Vai criar");
            this.trainers.add(trainer);
        }
        
        currentState = ApplicationStates.IDLE;
        trainer = new Trainer();
    }
    
    public void removeTrainer(Trainer trainer) {
        trainers.remove(trainer);
    }
    
    public Trainer copy(Trainer trainer) {
        Trainer copyTrainer = new Trainer();
        copyTrainer.setName(trainer.getName());
        copyTrainer.setCpf(trainer.getCpf());
        copyTrainer.setDateBirth(trainer.getDateBirth());
        
        return copyTrainer;
    }
    
    public void loadTrainer(Trainer trainer) {
        indexChange = trainers.indexOf(trainer);
        this.trainer = copy(trainer);
        currentState = ApplicationStates.EDITING;
    }
    
    @FacesConverter(forClass = Trainer.class)
    public static class TrainerBeanConverter implements Converter {
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            
            TrainerBean controller = (TrainerBean) facesContext.getApplication().getELResolver()
                    .getValue(facesContext.getELContext(), null, "trainerBean");
            return controller.getTrainer(value);
        }
        
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return ((Trainer) object).getName();
        }
    }
} 
