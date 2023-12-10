/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto_poo.repositories;

import com.projeto_poo.model.Team;
import java.util.ArrayList;

/**
 *
 * @author renp
 */
public class TeamRepository {
    final ArrayList<Team> teamList = new ArrayList();
        
    public ArrayList<Team> getTeamList() {
        return teamList;
    }
    
    public void addTeam(Team newTeam) {
        teamList.add(newTeam);
    }
   
    public void removeTeam(Team team) {
        teamList.remove(team);
    }
    
    public void saveTeam(int teamIndex, Team editedTeam) {
        teamList.set(teamIndex, editedTeam);
    }
    
    
    public Team findTeam(String teamName) {
        for (Team team : teamList) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        
        return null;
    }
    
    public int getTeamIndex(Team team) {
        return teamList.indexOf(team);
    }
    
    public Team cloneTeam(Team team) {
        Team clone = new Team();
        
        clone.setName(team.getName());
        clone.setCity(team.getCity());
        clone.setTrainer(team.getTrainer());
        
        return clone;
    }
    
}
