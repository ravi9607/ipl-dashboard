package com.example.ipldashboard.data;

import com.example.ipldashboard.Model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

//    JdbcTemplate.query() executes a raw SQL query via Spring's JDBC API
//    EntityManager.createQuery() creates, but does not execute, a JPA query, via the native JPA API.

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    private final EntityManager entityManager;

    @Autowired
    public JobCompletionNotificationListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

//            jdbcTemplate.query("SELECT team1, team2, date FROM match",
//                    (rs, row) -> "Team 1 -> " + rs.getString(1) + " Team 2 -> " +rs.getString(2) + " Date -> " + rs.getString(3)
//            ).forEach(str -> System.out.println(str));
            Map<String, Team> teamData = new HashMap<>();

            entityManager.createQuery("select m.team1, count(m) from Match m group by m.team1", Object[].class)
                    .getResultList()
                    .stream()
//                    .map(e -> new Team((String) e[0], (long) e[1]))       ///  without Builder Patten
                    .map(e -> Team.builder().teamName((String) e[0]).totalMatches((long)e[1]).build())  //  with builder (create object with any parameter ) in Team.java
                    .forEach(team -> teamData.put(team.getTeamName(), team));

            entityManager.createQuery("select m.team2, count(m) from Match m group by m.team2", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamData.get((String) e[0]);
                        team.setTotalMatches(team.getTotalMatches() + (long) e[1]);
                    });

            entityManager.createQuery("select m.matchWinner, count(m) from Match m group by m.matchWinner", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamData.get((String) e[0]);
                        if (team != null) team.setTotalWins((long) e[1]);
                    });

            teamData.values().forEach(team -> entityManager.persist(team));
            //teamData.values().forEach(team -> System.out.println(team.getTeamName() +" Wining % -> "+(team.getTotalWins()*100)/team.getTotalMatches()+"%"));
            teamData.values().forEach(team -> System.out.println(team));
        }
    }
}