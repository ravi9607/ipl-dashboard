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
