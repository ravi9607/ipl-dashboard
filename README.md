# IPL Dashboard (SPRING BOOT AND REACT)

Browse your favorite IPL teams and access their past games details, wins and losses ratios - accessible by team and tournament year.

## API

![Swagger Page](/src/Swagger.png)

   ### GET REQUESTS
    Home Page - https://ipl-backend-api.herokuapp.com/api/team
    Team Page - https://ipl-backend-api.herokuapp.com/api/team/${Team_Name}
    Match Page- https://ipl-backend-api.herokuapp.com/api/team/${Team_Name}/matches?year=${Year}



## Screenshots

### Home Page (https://ipl-dashboard-project.netlify.app/)

![Home Page Page](/src/homePage.png)

### Team Page (https://ipl-dashboard-project.netlify.app/#/teams/${Team_Name})

![Team Page Page](/src/TeamPage.png)

### Matches Page (https://ipl-dashboard-project.netlify.app/#/teams/${Team_Name}/matches/${Year})

![Matches Page](/src/matchPage.png)

## Technologies

* Spring Boot
* Spring Batch
* Java Persistence API, Repositories and JPQL
* HSQL DB
* React JS

## Data Set Used
https://www.kaggle.com/patrickb1912/ipl-complete-dataset-20082020/metadata
