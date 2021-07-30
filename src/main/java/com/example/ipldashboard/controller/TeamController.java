package com.example.ipldashboard.controller;


import com.example.ipldashboard.Model.Match;
import com.example.ipldashboard.Model.Team;
import com.example.ipldashboard.repo.MatchRepo;
import com.example.ipldashboard.repo.TeamRepo;
import com.example.ipldashboard.service.MatchServices;
import com.example.ipldashboard.service.TeamServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class TeamController {

    private final TeamRepo teamRepo;
    private final MatchRepo matchRepo;

    private final MatchServices matchServices;  //  only setup Pageable (size of output)
    private final TeamServices teamServices;  //  only setup Pageable (size of output)

    public TeamController(TeamRepo teamRepo, MatchRepo matchRepo, MatchServices matchServices,TeamServices teamServices) {
        this.teamRepo = teamRepo;
        this.matchRepo = matchRepo;
        this.matchServices = matchServices;
        this.teamServices = teamServices;
    }

    @GetMapping("/team")
    @ApiOperation(value =" All Team",
                    notes = "Give All teams with total wins and matches",
                    response =Team.class)
    public List<Team> getAllTeams() {
        return this.teamServices.findallteam();
    }

    @GetMapping("/team/{teamName}")
    @ApiOperation(value ="Team latest performance by teamName",
            notes = "Team's latest matches",
            response =Team.class)
    public Team getTeam(@PathVariable("teamName") String teamName){
        Team team = this.teamRepo.findByTeamName(teamName);
        //Pageable pageable = PageRequest.of(0, 4);  // using pageable set output result size

        //team.setMatches(matchRepo.findLatestMatchesbyTeam(teamName,4));
        team.setMatches(matchServices.LatestMatch(teamName,4));

        return team;
    }

    @GetMapping("/team/{teamName}/matches")
    @ApiOperation(value ="Team All matches by teamName and Year",
            notes = "Give All teams with total wins and matches",
            response =Match.class)
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return this.matchRepo.getMatchesByTeamBetweenDates(
                teamName,
                startDate,
                endDate
        );
    }

}
