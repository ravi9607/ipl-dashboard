import { React, useEffect, useState } from 'react';
// import { axios } from 'axios';
import { TeamTile } from '../components/TeamTile';

import './HomePage.scss';

export const HomePage = () => {

    const [teams, setTeams] = useState([]);
    useEffect(() => {
        const fetchTeams = async () => {
            // const response = await fetch(`http://localhost:8080/api/team`);
            const response = await fetch(`https://ipl-backend-api.herokuapp.com/api/team`);

            const data = await response.json();
            setTeams(data);
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


        fetchTeams();

    }, []);

   
    return (
        <div className="HomePage">
            <div className="headingSection">
                <h1 className="heading">IPL DASHBOARD</h1>
            </div>
            <div className="TeamGridSection">
                {
                    teams.map(team => 
                    <div key={team.id} className="TeamGrid">
                        <TeamTile teamName={team.teamName} />

                    </div> )

                }
            </div>
        </div>   
    );
}