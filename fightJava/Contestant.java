/**
Contestant Class: An object in this class is given a name, a vitality stat, a strength stat, an intellgience stat and a luck stat through a randomized process. These attributes are required for the contestants to compete in the trivia, coinflip and fight games. Out of the four contestants created, one will be left standing after semi-final (trivia) and final (coinflip) matches. This contestant will face off the champion object in a fight game.
Rishi Nair
*/

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Contestant{
  //List of attributes of the Contestant class.
  String name;
  int vitality;
  int strength;
  int intelligence;
  int luck;

  //Possible first and last names of the contestants stored in an array.
  String[] firstNameList = {"Joe", "Bob", "Jill", "Susan", "Pat", "John", "Kevin", "Rob", "Travis", "Lewis"};
  String[] lastNameList = {"Smith", "Gates", "Brown", "Bean", "Orange", "Brock", "Heart", "Mann", "Blue", "Red"};
  
  static int randnum(int max){
    Random rand = new Random();
    return rand.nextInt(max);
  }
  
  //A method that uses the random function to randomly generate a full name for each contestant.
  public String nameGen(){
    String firstName = firstNameList[randnum(firstNameList.length)];
    String lastName = lastNameList[randnum(lastNameList.length)];
    name = firstName + " " + lastName;
    return name;
  }

  //A method that generates a value for the Contestant's vitality attribute from 50-100.
  public int vitalityGen(){
    int vitality = randnum(50) + 51;
    return vitality;
  }

  //A method that generates a value for the Contestant's strength attribute from 1-100.
  public int strengthGen(){
    int strength = randnum(100) + 1;
    return strength;
  }

  //A method that generates a value for the Contestant's intelligence attribute from 1-100.
  public int intelligenceGen(){
    int intelligence = randnum(100) + 1;
    return intelligence;
  }

  //A method that generates a value for the Contestant's luck attribute from 7-98 that are multiples of 7.
  public int luckGen(){
    int luck = randnum(14) + 1;
    luck = luck * 7;
    return luck;
  }

  //A method that assings randomly generated values using the methods above to the Contestant's attributes and prints them out.
  public Contestant(){
    name = nameGen();
    vitality = vitalityGen();
    strength = strengthGen();
    intelligence = intelligenceGen();
    luck = luckGen();
    System.out.println(name + " has " + vitality + " health, " + strength + " strength, " +intelligence + " intelligence, and " + luck + " luck.");
  }
} 