import React from 'react'
import { Link } from 'react-router-dom';


export const MatchSmallCard = ({teamName, match}) => {
    
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeam}`
    return (
        <div className="matchSmallCard">
            <h2>vs 
                <Link to={otherTeamRoute}> {otherTeam}</Link>
            </h2>
            <h3 className="match-result">{match.matchWinner} won by {match.resultMargin} {match.result} </h3>

            <p> at {match.venue}</p>
        </div>
    );

}