import { React, useEffect, useState } from 'react';
import { MatchSmallCard } from '../components/MatchSmallCard'
import { MatchDetailCard } from '../components/MatchDetailCard'
// import { axios } from 'axios';
import { useParams } from 'react-router-dom';
import './TeamPage.scss';
import { PieChart } from 'react-minimal-pie-chart';

export const TeamPage = () => {

    const [team, setTeam] = useState([]);
    const { teamName } = useParams();
    useEffect(() => {
        const fetchMatches = async () => {
           // const response = await fetch(`http://localhost:8080/api/team/${teamName}`);
            const response = await fetch(`https://ipl-backend-api.herokuapp.com/api/team/${teamName}`);

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
            <div className="teamNameSection">
                <h1 className="teamName">
                    {team.teamName}
                </h1>
            </div>

            <div className="winLossSection">
                Wins / Losses
                <PieChart
                    data={[
                        { title: 'Loss', value: (team.totalMatches - team.totalWins), color: 'rgb(233, 119, 119)' },
                        { title: 'Win', value: team.totalWins, color: 'rgb(41, 240, 101)' },
                        
                    ]}
                />;
            </div>
            <div className="matchDetailSection">
                <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
            </div>
            {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} match={match} />)}
            <div className="more">
                <a href="#">More >  </a>
            </div>
        </div>
    );
}