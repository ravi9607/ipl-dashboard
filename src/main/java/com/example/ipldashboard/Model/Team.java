package com.example.ipldashboard.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder      //   used to creat object using anu instant variable
@ToString
public class Team {
    public Team(long id, String teamName, long totalMatches, long totalWins) {
        this.id = id;
        this.teamName = teamName;
        this.totalMatches = totalMatches;
        this.totalWins = totalWins;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatches;
    private long totalWins;

    @Transient
    private List<Match> matches;

//    public Team(String teamName, long totalMatches) {          //  @Builder create
//        this.teamName = teamName;
//        this.totalMatches = totalMatches;
//    }


}
