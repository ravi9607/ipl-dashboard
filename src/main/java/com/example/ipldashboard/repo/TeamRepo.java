package com.example.ipldashboard.repo;

import com.example.ipldashboard.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {
    Team findByTeamName(String teamName);


}
