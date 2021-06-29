import { React, useEffect, useState } from 'react';
import { MatchSmallCard } from '../components/MatchSmallCard'
import { MatchDetailCard } from '../components/MatchDetailCard'
import { useParams } from 'react-router-dom';


export const MatchPage = () => {
     
    const [matches, setMatches] = useState([]);
    const { teamName, year } = useParams();
    useEffect(() => {
        const fetchMatches = async () => {
            const response = await fetch(`http://localhost:8080/api/team/${teamName}/matches?year=${year}`);
            const data = await response.json();
            setMatches(data);
            console.log(data);
        }
        fetchMatches();

    }, [teamName, year]);



    return (
        <div className="MatchPage">
            <h1>
                Match Page
            </h1>
            <h3>
                {matches.map(match => <MatchSmallCard teamName={teamName} match={match} />)}
            </h3>
        </div>
    );
}