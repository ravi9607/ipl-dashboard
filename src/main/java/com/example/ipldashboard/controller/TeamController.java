package com.example.ipldashboard.controller;

import com.example.ipldashboard.Model.Team;
import com.example.ipldashboard.repo.MatchRepo;
import com.example.ipldashboard.repo.TeamRepo;
import com.example.ipldashboard.service.MatchServices;
import org.springframework.web.bind.annotation.*;


import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TeamController {

    private final TeamRepo teamRepo;
    private final MatchRepo matchRepo;

    private final MatchServices matchServices;  //  only setup Pageable (size of output)

    public TeamController(TeamRepo teamRepo, MatchRepo matchRepo, MatchServices matchServices) {
        this.teamRepo = teamRepo;
        this.matchRepo = matchRepo;
        this.matchServices = matchServices;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName){
        Team team = this.teamRepo.findByTeamName(teamName);
        //Pageable pageable = PageRequest.of(0, 4);  // using pageable set output result size

        //team.setMatches(matchRepo.findLatestMatchesbyTeam(teamName,4));
        team.setMatches(matchServices.LatestMatch(teamName,5));

        return team;
    }

}
