/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto_poo.bean;

import com.projeto_poo.core.ApplicationStates;
import com.projeto_poo.model.Team;
import com.projeto_poo.repositories.TeamRepository;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author renp
 */
@Named("teamBean")
@SessionScoped
public class TeamBean implements Serializable {
    TeamRepository repository;
    Team team;
    ApplicationStates currentState;
    int index;
    
    
    public TeamBean() {
    }
    
    @PostConstruct
    public void init() {
        repository = new TeamRepository();
        team = new Team();
        currentState = ApplicationStates.IDLE;
        index = -1;  // Initialize index to a default value
    }
    
    public Team getTeam() {
        return team;
    }
    
    public Team getTeam(String teamName) {
        return repository.findTeam(teamName);
    }
    
    public ArrayList<Team> getTeamList() {
        return repository.getTeamList();
    }
    
    private void resetState() {
        currentState = ApplicationStates.IDLE;
        team = null;
        index = -1;
    }
    
    public void saveOperation() {
        if (currentState == ApplicationStates.EDITING) 
            repository.saveTeam(index, team);
        else {
            repository.addTeam(team);
        }
        
        resetState();
    }
    
    public void removeOperation(Team team) {
        repository.removeTeam(team);
        
        resetState();
    }
    
    public Team newOperation() {
        team = new Team();
        currentState = ApplicationStates.CREATING;
        
        return team;
    }
    
    public void cancelOperation() {
        resetState();
    }
    
    public void loadTeam(Team team) {
        this.team = new Team();
        this.team = repository.cloneTeam(team);
        
        index = repository.getTeamIndex(team);
        currentState = ApplicationStates.EDITING;
    }
    
    public boolean newButtonActivated() {
        return currentState == ApplicationStates.IDLE;
    }
    
    @FacesConverter(forClass = Team.class)
    public static class TeamBeanConverter implements Converter {
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TeamBean controller = (TeamBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "teamBean");
            return controller.getTeam(value);
        }
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return ((Team) object).getName();
        }

    }
}