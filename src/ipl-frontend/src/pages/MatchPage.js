import { React, useEffect, useState } from 'react';
import { MatchDetailCard } from '../components/MatchDetailCard'
import { useParams } from 'react-router-dom';
import './MatchPage.scss';
import { YearSelector } from '../components/YearSelector'

export const MatchPage = () => {

    const [matches, setMatches] = useState([]);
    const { teamName, year } = useParams();
    useEffect(() => {
        const fetchMatches = async () => {
            //const response = await fetch(`http://localhost:8080/api/team/${teamName}/matches?year=${year}`);
            const response = await fetch(`https://ipl-backend-api.herokuapp.com/api/team/${teamName}/matches?year=${year}`);

            const data = await response.json();
            setMatches(data);
            console.log(data);
        }
        fetchMatches();

    }, [teamName, year]);



    return (
        <div className="MatchPage">
            <div >
                <YearSelector teamName={teamName} />
            </div>
            <div>
                <h1>
                    {teamName} matches in {year}
                </h1>
                <h3>
                    {matches.map(match => <MatchDetailCard key={match.id} teamName={teamName} match={match} />)}
                </h3>
            </div>
        </div>
    );
}