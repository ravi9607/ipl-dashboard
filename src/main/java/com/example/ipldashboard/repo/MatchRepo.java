package com.example.ipldashboard.repo;

import com.example.ipldashboard.Model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepo extends JpaRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);   // using pageable set output result size

//    default List<Match> findLatestMatchesbyTeam(String teamName, int count) {
//        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
//    }
}
