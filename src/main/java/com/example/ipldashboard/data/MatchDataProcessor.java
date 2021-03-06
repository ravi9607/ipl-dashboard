package com.example.ipldashboard.data;

import com.example.ipldashboard.Model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.util.Date;


public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(matchInput.getId());
        match.setCity(matchInput.getCity());

        match.setDate(LocalDate.parse(matchInput.getDate())); ///  update Requied
//        match.setDate(Date.parse(matchInput.getDate())); ///  update Requied

        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());

        String firstInningTeam;
        String secondInningTeam;

        if("bat".equals(matchInput.getToss_decision())){
            firstInningTeam = matchInput.getToss_winner();
            secondInningTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();
        }else {
            secondInningTeam = matchInput.getToss_winner();
            firstInningTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();
        }

        match.setTeam1(firstInningTeam);
        match.setTeam2(secondInningTeam);

        match.setTossDecision(matchInput.getToss_decision());
        match.setTossWinner(matchInput.getToss_winner());
        match.setMatchWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());



        return match;
    }
}