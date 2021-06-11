package com.example.ipldashboard.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchInput {
    private long id;
    private String city;
    private String date;
    private String player_of_match;
    private String venue;
    private String neutral_venue;
    private String team1 ;
    private String team2;
    private String toss_winner;
    private String toss_decision;
    private String winner;
    private String result;
    private String result_margin;
    private String eliminator;
    private String method;
    private String umpire1;
    private String umpire2;

    @Override
    public String toString() {
        return "MatchInput{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                ", player_of_match='" + player_of_match + '\'' +
                ", venue='" + venue + '\'' +
                ", neutral_venue='" + neutral_venue + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", toss_winner='" + toss_winner + '\'' +
                ", toss_decision='" + toss_decision + '\'' +
                ", winner='" + winner + '\'' +
                ", result='" + result + '\'' +
                ", result_margin='" + result_margin + '\'' +
                ", eliminator='" + eliminator + '\'' +
                ", method='" + method + '\'' +
                ", umpire1='" + umpire1 + '\'' +
                ", umpire2='" + umpire2 + '\'' +
                '}';
    }
}
