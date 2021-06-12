package com.example.ipldashboard.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

//    public Team(String teamName, long totalMatches) {          //  @Builder create
//        this.teamName = teamName;
//        this.totalMatches = totalMatches;
//    }


}
