package com.example.ipldashboard.service;

import com.example.ipldashboard.Model.Match;
import com.example.ipldashboard.repo.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServices {

    private final MatchRepo matchRepo;

    public MatchServices(MatchRepo matchRepo) {
        this.matchRepo = matchRepo;
    }

    public List<Match> LatestMatch(String teamName, int count){
        return matchRepo.getByTeam1OrTeam2OrderByDateDesc(teamName,teamName, PageRequest.of(0,count));
    }

}
