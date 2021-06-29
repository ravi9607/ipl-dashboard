package com.example.ipldashboard.repo;

import com.example.ipldashboard.Model.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepo extends JpaRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);   // using pageable set output result size

//    default List<Match> findLatestMatchesbyTeam(String teamName, int count) {
//        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
//    }

    @Query("select m from Match m where (m.team1 = :teamName or m.team2 = :teamName) and m.date between :dateStart and :dateEnd order by date desc")
    List<Match> getMatchesByTeamBetweenDates(
            @Param("teamName") String teamName,
            @Param("dateStart") LocalDate dateStart,
            @Param("dateEnd") LocalDate dateEnd
    );
}
