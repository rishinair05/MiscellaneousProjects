/**
Name: Rishi Nair
Date: May 16, 2022
Program Description: 8 basketball teams are generated with stats that can increase or decrease their chance of wining a game. The 8 teams face each other twice in a 14 week season. The 8 teams then participate in a Single Elimination Tournament playoff based on their ranking. 
*/

import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

class Main {

//randnum() uses the Random library to generate a random integer.
  static int randnum(int max){
    Random rand = new Random();
    return rand.nextInt(max);
  }

//mergeSortWins() sorts an ArrayList of teams from most wins to least wins. The sorting algorithm used is a recursive merge sort algorithm. 
  public static void mergeSortWins(List<Team> elements){
    int n = elements.size();
    List<Team> temp = new ArrayList<>(Arrays.asList(null, null, null, null, null, null, null, null));
    mergeSortHelper(elements, 0, n - 1, temp);
    Collections.reverse(elements);

    Team tempTeam = null;
    for(int b = 0; b < elements.size(); b++){
      for(int c = 0; c < elements.size(); c++){
        if(elements.get(b).wins == elements.get(c).wins){
          if(elements.get(b).totalScoreFor > elements.get(c).totalScoreFor && b > c){
            tempTeam = elements.get(b);
            elements.set(b, elements.get(c));
            elements.set(c, tempTeam);
          }
        }
      }
    }
  }

//mergeSortHelper() is a recursive utlity function used by mergeSortWins().
  private static void mergeSortHelper(List<Team> elements, int from, int to, List<Team> temp){
    if (from < to){
      int middle = (from + to) / 2;
      mergeSortHelper(elements, from, middle, temp);
      mergeSortHelper(elements, middle + 1, to, temp);
      merge(elements, from, middle, to, temp);
    }
  }

//merge() is a utlity function used by mergeSortHelper().
  private static void merge(List<Team> elements, int from, int mid, int to, List<Team> temp){
    int i = from;
    int j = mid + 1;
    int k = from;

    while (i <= mid && j <= to){
      if (elements.get(i).wins < elements.get(j).wins){
        temp.set(k, elements.get(i));
        i++;
      }
      else{
        temp.set(k, elements.get(j));
        j++;
      }
      k++;
    }

    while (i <= mid){
      temp.set(k, elements.get(i));
      i++;
      k++;
    }

    while (j <= to){
      temp.set(k, elements.get(j));
      j++;
      k++;
    }

    for (k = from; k <= to; k++){
      elements.set(k, temp.get(k));
    }
  }

//displayStats() displays the rankings of all 8 teams as well as their wins, losses, total goals and total goals scored against them.
  public static void displayStats(List<Team> ranks){
    System.out.println("place - team - win - loss - for - against");
    System.out.println("1st - " + ranks.get(0).name + " - " + ranks.get(0).wins + " - " + ranks.get(0).losses + " - " + ranks.get(0).totalScoreFor + " - " + ranks.get(0).totalScoreAgainst);
    System.out.println("2nd - " + ranks.get(1).name + " - " + ranks.get(1).wins + " - " + ranks.get(1).losses + " - " + ranks.get(1).totalScoreFor + " - " + ranks.get(1).totalScoreAgainst);
    System.out.println("3rd - " + ranks.get(2).name + " - " + ranks.get(2).wins + " - " + ranks.get(2).losses + " - " + ranks.get(2).totalScoreFor + " - " + ranks.get(2).totalScoreAgainst);
    System.out.println("4th - " + ranks.get(3).name + " - " + ranks.get(3).wins + " - " + ranks.get(3).losses + " - " + ranks.get(3).totalScoreFor + " - " + ranks.get(3).totalScoreAgainst);
    System.out.println("5th - " + ranks.get(4).name + " - " + ranks.get(4).wins + " - " + ranks.get(4).losses + " - " + ranks.get(4).totalScoreFor + " - " + ranks.get(4).totalScoreAgainst);
    System.out.println("6th - " + ranks.get(5).name + " - " + ranks.get(5).wins + " - " + ranks.get(5).losses + " - " + ranks.get(5).totalScoreFor + " - " + ranks.get(5).totalScoreAgainst);
    System.out.println("7th - " + ranks.get(6).name + " - " + ranks.get(6).wins + " - " + ranks.get(6).losses + " - " + ranks.get(6).totalScoreFor + " - " + ranks.get(6).totalScoreAgainst);
    System.out.println("8th - " + ranks.get(7).name + " - " + ranks.get(7).wins + " - " + ranks.get(7).losses + " - " + ranks.get(7).totalScoreFor + " - " + ranks.get(7).totalScoreAgainst);
  }
  
  public static void main(String[] args) {
//Two ArrayList called cities and animals that includes the possible cities and animal-themed names of the teams.
    List<String> cities = new ArrayList<> (Arrays.asList("Toronto", "New York", "Los Angeles", "Chicago", "Boston", "Philadelphia", "San Francisco", "Miami", "New Orleans", "Detroit", "Memphis", "Dallas"));
    List<String> animals = new ArrayList<> (Arrays.asList("Tigers", "Grizzlies", "Rams", "Eagles", "Cardinals", "Penguins", "Bucks", "Hornets", "Bulls", "Hawks", "Blue Jays", "Dolphins"));

//Randomly generate the names of the teams. Once a city/animal name has been used, it is removed from the ArrayList so that there are no duplicates.
    int i = randnum(cities.size() - 1);
    int j = randnum(cities.size() - 1);
    Team team1 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

    i = randnum(cities.size() - 1);
    j = randnum(cities.size() - 1);  
    Team team2 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

    i = randnum(cities.size() - 1);
    j = randnum(cities.size() - 1);
    Team team3 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

    i = randnum(cities.size() - 1);
    j = randnum(cities.size() - 1);
    Team team4 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

    i = randnum(cities.size() - 1);
    j = randnum(cities.size() - 1);
    Team team5 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

    i = randnum(cities.size() - 1);
    j = randnum(cities.size() - 1);
    Team team6 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

    i = randnum(cities.size() - 1);
    j = randnum(cities.size() - 1);
    Team team7 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

    i = randnum(cities.size() - 1);
    j = randnum(cities.size() - 1);
    Team team8 = new Team(cities.get(i), animals.get(j));
    cities.remove(i);
    animals.remove(j);

//Two arrayLists called allTeams and ranks that contain the eight teams. 
    List<Team> allTeams = new ArrayList<> (Arrays.asList(team1, team2, team3, team4, team5, team6, team7, team8));
    List<Team> ranks = new ArrayList<> (Arrays.asList(team1, team2, team3, team4, team5, team6, team7, team8));

//Simulate matches over a period of 14 weeks. A nested for-loop which repeats the section of the code inside the for-loop a total of 14 times. In the for-loop, all possible game matchups are played twice. Each team plays once a week.
    for(int k = 0; k < 7; k++){
      for(int l = 0; l < 2; l++){
        System.out.println(" ");
        System.out.println("Week" + " " + ((k+1)*2+(l-1)));
        allTeams.get(0).play(allTeams.get(k+1));
        if(k < 6){
          allTeams.get(7).play(allTeams.get(6-k));
          }
        if(k == 0){
          allTeams.get(2).play(allTeams.get(3));
          allTeams.get(4).play(allTeams.get(5));
        }
        if(k == 1){
          allTeams.get(1).play(allTeams.get(3));
          allTeams.get(4).play(allTeams.get(6));
        }
        if(k == 2){
          allTeams.get(1).play(allTeams.get(5));
          allTeams.get(2).play(allTeams.get(6));
        }
        if(k == 3){
          allTeams.get(1).play(allTeams.get(6));
          allTeams.get(2).play(allTeams.get(5));
        }
        if(k == 4){
          allTeams.get(1).play(allTeams.get(4));
          allTeams.get(3).play(allTeams.get(6));
        }
        if(k == 5){
          allTeams.get(2).play(allTeams.get(4));
          allTeams.get(3).play(allTeams.get(5));
        }
        if(k == 6){
          allTeams.get(1).play(allTeams.get(2));
          allTeams.get(3).play(allTeams.get(4));
          allTeams.get(5).play(allTeams.get(6));
        }
//Use mergeSortWins() to sort the ranks arrayList by wins in descending order.
        mergeSortWins(ranks);
//Use displayStats() to display the current team standings for the week.
        System.out.println("Week " + ((k+1)*2+(l-1)) + " Standings");
        displayStats(ranks);
      }
    }
//The eight teams play a Single Elimination Tournament with quarter, semi and final matches. The teams who advance/win the tournament are declared after every match.
    System.out.println(" ");
    System.out.println("Playoffs");
    System.out.println("Week 1");
    Team winner1 = ranks.get(0).playoff(ranks.get(7));
    System.out.println(winner1.name + " advances to the semi-finals!");
    Team winner2 = ranks.get(1).playoff(ranks.get(6));
    System.out.println(winner2.name + " advances to the semi-finals!");
    Team winner3 = ranks.get(2).playoff(ranks.get(5));
    System.out.println(winner3.name + " advances to the semi-finals and will play the " + winner2.name + "!");
    Team winner4 = ranks.get(3).playoff(ranks.get(4));
    System.out.println(winner4.name + " advances to the semi-finals and will play the " + winner1.name + "!");
    System.out.println(" ");
    System.out.println("Week 2");
    Team winner5 = winner1.playoff(winner4);
    System.out.println(winner5.name + " advances to the finals!");
    Team winner6 = winner2.playoff(winner3);
    System.out.println(winner6.name + " advances to the finals and will play the " + winner5.name + "!");
    System.out.println(" ");
    System.out.println("Week 3");
    Team finalWinner = winner5.playoff(winner6);
    System.out.println(finalWinner.name + " are the new champions!");
  }
}