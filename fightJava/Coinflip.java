/**
Coinflip: A game played between the winners of the trivia game. This game is purely luck based and each of the contestants have a 50% chance of winning. The winner will go on to face the champion in a fight.
Rishi Nair
*/

import java.util.*;
import java.util.Random;
import java.util.Scanner;

//A class called trivia that determines a winner between two contestants. The attributes of this object are the names and stats of the two contestants that are facing off.
public class Coinflip{
  String name1;
  int vitality1;
  int strength1;
  int intelligence1;  
  int luck1;
  String name2;
  int vitality2;
  int strength2;
  int intelligence2;  
  int luck2;

  static int randnum(int max){
    Random rand = new Random();
    return rand.nextInt(max);
  }

  //Assigns a random number between 0 and 1 to a variable called coin.
  int coin = randnum(2);

  //The Coinflip class takes the names and stats of the two players as input.
  public Coinflip(String initName1, int initVitality1, int initStrength1, int initIntelligence1, int initLuck1, String initName2, int initVitality2, int initStrength2, int initIntelligence2, int initLuck2){
    name1 = initName1;
    vitality1 = initVitality1;
    strength1 = initStrength1;
    intelligence1 = initIntelligence1;
    luck1 = initLuck1;
    name2 = initName2;
    vitality2 = initVitality2;
    strength2 = initStrength2;
    intelligence2 = initIntelligence2;
    luck2 = initLuck2;
  }

  //A method that prints out the results of the coinflip game. If the coin lands on 0, the winner of the first trivia game wins, else, the other contestant wins.
  public String coinflipResults(){
    System.out.println(name1 + " and " + name2 + " will face off in a coinflip.");
    System.out.println(name1 + " bets on heads and " + name2 + " bets on tails.");
    if (coin == 0){
      System.out.println("The coin lands on heads!");
      System.out.println(name1 + " won the coinflip.");
      return name1;
    }
    else {
      System.out.println("The coin lands on tails!");
      System.out.println(name2 + " won the coinflip.");
      return name2;
    }
  }

  //Methods that return the stats of the winner when called.
  public int coinflipVitality(){
    if (coin == 0){
      return vitality1;
    }
    else{
      return vitality2;
    }
  }

  public int coinflipStrength(){
    if (coin == 0){
      return strength1;
    }
    else{
      return strength2;
    }
  }

  public int coinflipIntelligence(){
    if (coin == 0){
      return intelligence1;
    }
    else{
      return intelligence2;
    }
  }
  
  public int coinflipLuck(){
    if (coin == 0){
      return luck1;
    }
    else{
      return luck2;
    }
  }
}