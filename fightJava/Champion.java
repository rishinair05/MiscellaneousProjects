/**
Champion Class: An object created in this class will have a vitality, strength and intelligence stat. Unlike the contestant class, objects in this class will have no name or a luck stat. The champion will face off the contestant winner from the tournament in a fight game. The champion may be left defeated, or undefeated.
Rishi Nair
*/

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Champion{
  //List of attributes of the Champion class.
  int vitality;
  int strength;
  int intelligence;
  
  static int randnum(int max){
    Random rand = new Random();
    return rand.nextInt(max);
  }
  

  //A method that generates a value for the Champion's vitality attribute from 101-200.
  public int vitalityGen(){
    int vitality = randnum(100) + 101;
    return vitality;
  }

  //A method that generates a value for the Champion's strength attribute from 51-100.
  public int strengthGen(){
    int strength = randnum(50) + 51;
    return strength;
  }

  //A method that generates a value for the Champion's intelligence attribute from 51-100.
  public int intelligenceGen(){
    int intelligence = randnum(50) + 51;
    return intelligence;
  }

  //A method that assings randomly generated values using the methods above to the Champion's attributes and prints them out.
  public Champion(){
    vitality = vitalityGen();
    strength = strengthGen();
    intelligence = intelligenceGen();
    System.out.println("The reigning champion has " + vitality + " health, " + strength + " strength, and " +intelligence + " intelligence.");
  }
}