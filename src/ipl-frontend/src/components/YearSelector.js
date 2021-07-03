import React from 'react'
import { Link } from 'react-router-dom';
import './YearSelector.scss';

export const YearSelector = ({teamName}) => {

    let years = [];
    for(let i = 2020;i>=2008;i--){
        years.push(i);
    }
 
    return(
        <ol className="YearSelector">
            <h2>Select Year</h2>
            {years.map(year => (
                <li key = {year} className="Years">
                    <Link to={`/teams/${teamName}/matches/${year}`}>{year}</Link>
                </li>
            ))}
        </ol>
    )
}