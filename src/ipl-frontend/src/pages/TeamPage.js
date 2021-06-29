import { React, useEffect, useState } from 'react';
import { MatchSmallCard } from '../components/MatchSmallCard'
import { MatchDetailCard } from '../components/MatchDetailCard'
// import { axios } from 'axios';
import { useParams } from 'react-router-dom';


export const TeamPage = () => {

    const [team, setTeam] = useState([]);
    const { teamName } = useParams();
    useEffect(() => {
        const fetchMatches = async () => {
            const response = await fetch(`http://localhost:8080/api/team/${teamName}`);
            const data = await response.json();
            setTeam(data);
            console.log(data);
        }

        // const fetchMatches = async () => {
        //     axios.get('https://ipl-backend-api.herokuapp.com/api/team/Mumbai Indians').then(
        //         (response) =>{
        //             console.log(response);
        //         },(error)=>{
        //             console.log(error);
        //         }
        //     );
        // };


        fetchMatches();

    }, [teamName]);

    if (!team || !team.teamName) {
        return <h1>Team not found</h1>
    }
    return (
        <div className="TeamPage">
            <h1>
                {team.teamName}
            </h1>

            <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
            {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} match={match} />)}
        </div>
    );
}