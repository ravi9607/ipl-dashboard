package com.example.ipldashboard.service;

import com.example.ipldashboard.Model.Team;
import com.example.ipldashboard.repo.TeamRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeamServices {

    private final TeamRepo teamRepo;

    public TeamServices( TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public List<Team> findallteam(){

        return teamRepo.findAll();
    }


}
