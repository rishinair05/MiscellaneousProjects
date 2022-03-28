import java.util.*;
import java.util.ArrayList;
import java.util.Random;

//A class called Team.
public class Team{
//The atributes of the Team class is the team's full name, its city, its animal-themed name, its ranking, the number of wins, losses, the last game's score, the team's total points and points scored on the team, the team's stats (offensive rating, defensive rating, team chemistry, coach rating and overall rating). 
  String name;
  String city;
  String animal;
  int rank;
  int wins;
  int losses;
  int scoreFor;
  int scoreAgainst;
  int totalScoreFor;
  int totalScoreAgainst;

  int offensiveRating;
  int defensiveRating;
  int teamChemistry;
  int coachRating;
  int overallRating;

  static int randnum(int max){
    Random rand = new Random();
    return rand.nextInt(max);
  }

//genStat() generates a random integer from 50 to 100. This method is used to generate the teams's stats.
  static int genStat(){
    return randnum(51) + 50;
  }

//The constructor of the class takes the team's city and animal-themed name as inputs. The team's rank, wins, losses, scoreFor, scoreAgainst, totalScoreFor and totalScoreAgainst attributes are initialized at 0. The team's offensiveRating, defensiveRating, teamChemistry and coachRating is randomly generated using the genStat() method.
  public Team(String initCity, String initAnimal){
    name = initCity + " " + initAnimal;
    city = initCity;
    animal = initAnimal;
    rank = 0;
    wins = 0;
    losses = 0;
    scoreFor = 0;
    scoreAgainst = 0;
    totalScoreFor = 0;
    totalScoreAgainst = 0;

    offensiveRating = genStat();
    defensiveRating = genStat();
    teamChemistry = genStat();
    coachRating = genStat();

    overallRating = (offensiveRating + defensiveRating + teamChemistry + coachRating)/40;
  }

//An overloaded constructor which creates an instance of the Team object where all the attributes are input through the constructor.
  public Team(String initCity, String initAnimal, int initRank, int initWins, int initLosses, int initScoreFor, int initScoreAgainst, int initTotalScoreFor, int initTotalScoreAgainst, int initOffensiveRating, int initdefensiveRating, int initTeamChemistry, int initCoachRating){
    name = initCity + " " + initAnimal;
    city = initCity;
    animal = initAnimal;
    rank = initScoreFor;
    wins = initWins;
    losses = initLosses;
    scoreFor = initScoreFor;
    scoreAgainst = initScoreAgainst;
    totalScoreFor = initTotalScoreFor;
    totalScoreAgainst = initTotalScoreAgainst;
    offensiveRating = initOffensiveRating;
    defensiveRating = initdefensiveRating;
    teamChemistry = initTeamChemistry;
    coachRating = initCoachRating;
    overallRating = (offensiveRating + defensiveRating + teamChemistry + coachRating)/40;
  }

//play() simulates a game between two teams. Based on the team's stats and randomly generated numbers, the points of each team are generated. Based on which team has more points (if its a tie, the game is played again) a winner and loser is declared.
  public int[] play(Team opponent){ 
    scoreFor = ((randnum(3) + 10) * overallRating) + offensiveRating - opponent.defensiveRating + randnum(30);
    scoreAgainst = ((randnum(3) + 10) * opponent.overallRating) + opponent.offensiveRating - defensiveRating + randnum(30);
    opponent.scoreFor = scoreAgainst;
    opponent.scoreAgainst = scoreFor;

    if (scoreFor > scoreAgainst){
      wins = wins + 1;
      opponent.losses = opponent.losses + 1;
    }

    else if (scoreFor == scoreAgainst){
      play(opponent);
    }

    else{
      losses = losses + 1;
      opponent.wins = opponent.wins + 1;
    }

    System.out.println(name + " " + scoreFor + ", " + opponent.name + " " + scoreAgainst);
    
    int[] scoreBoard = {scoreFor, scoreAgainst};
    totalScoreFor = totalScoreFor + scoreFor;
    totalScoreAgainst = totalScoreAgainst + scoreAgainst;
    opponent.totalScoreFor = opponent.totalScoreFor + scoreAgainst;
    opponent.totalScoreAgainst = opponent.totalScoreAgainst + scoreFor;
    return scoreBoard;
  }

//A playoff game which acts in a very similar way to play(), but instead of returning the scores, it returns the winner (who continues to play the next playoff game).
  public Team playoff(Team opponent){
    scoreFor = ((randnum(3) + 10) * overallRating) + offensiveRating - opponent.defensiveRating + randnum(30);
    scoreAgainst = ((randnum(3) + 10) * opponent.overallRating) + opponent.offensiveRating - defensiveRating + randnum(30);
    System.out.println(name + " " + scoreFor + ", " + opponent.name + " " + scoreAgainst);
    
    if (scoreFor > scoreAgainst){
      Team homeTeam = new Team(city, animal, rank, wins, losses, scoreFor, scoreAgainst, totalScoreFor, totalScoreAgainst, offensiveRating, defensiveRating, teamChemistry, coachRating);
      return homeTeam;
    }

    else if (scoreFor == scoreAgainst){
      playoff(opponent);
    }

    else{
      return opponent;
    }
    return null;
  }

  
  public int getWins(){
    return wins;
  }

  public int getLosses(){
    return losses;
  }

  public int getTotalScoreFor(){
    return totalScoreFor;
  }

  public int getTotalScoreAgainst(){
    return totalScoreAgainst;
  }
}