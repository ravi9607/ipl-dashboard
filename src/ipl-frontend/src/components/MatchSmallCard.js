import React from 'react'
import { Link } from 'react-router-dom';
import './MatchSmallCard.scss'

export const MatchSmallCard = ({teamName, match}) => {
    
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeam}`
    const isMatchWon = teamName === match.matchWinner
    return (
        <div className={isMatchWon ? 'MatchSmallCard won-bg' : 'MatchSmallCard loss-bg'}>
            <h2>vs 
                <Link to={otherTeamRoute}> {otherTeam}</Link>
            </h2>
            <h3>{match.date}</h3>
            <h3 className="match-result">{match.matchWinner} won by {match.resultMargin} {match.result} </h3>
        </div>
    );

}