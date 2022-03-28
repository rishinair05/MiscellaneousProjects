/**
Fight: A fight between the winner of the coinflip game and the champion object from the champion class. The contestant can beat the champion if it has a luck stat of over 70 or it has a power greater than that of the Champion. Power is calculated by summing the vitality, strength, intelligence and luck stats of the contestant and champion. Since the champion does not have a luck stat, 50 points are added to the champion's power. The champion may remain undefeated or may succumb to a fierce contestant.
Rishi Nair
*/

//A class called fight that determines a winner between a contestant and the champion. The attributes of this object are the names and stats of the contestant and the champion that are facing off.

public class Fight{
  String name1;
  int vitality1;
  int strength1;
  int intelligence1;  
  int luck1;

  int vitality2;
  int strength2;
  int intelligence2;

  //The Fight class takes the name and stats of the player and the champion.
  public Fight(String initName1, int initVitality1, int initStrength1, int initIntelligence1, int initLuck1,  int initVitality2, int initStrength2, int initIntelligence2){
    name1 = initName1;
    vitality1 = initVitality1;
    strength1 = initStrength1;
    intelligence1 = initIntelligence1;
    luck1 = initLuck1; 
    
    vitality2 = initVitality2;
    strength2 = initStrength2;
    intelligence2 = initIntelligence2;
  }
  
  //A method that displays the winner of the fight. The method used to determine whether the contestant or the champion wins is by adding all four stats of the contestant and by adding 50 to the sum of three stats of the champion. If the contestant has a luck stat greater than 70 or has a higher stat-sum that the champion, he wins.
  public void fightResults(){
    System.out.println(name1 + " will now face the champion in a fight.");
    int power1 = vitality1 + strength1 + intelligence1 + luck1;
    int power2 = vitality2 + strength2 + intelligence2 + 50;

    if (power1 > power2 || luck1 > 70){
      if (power1 > power2){
      System.out.println(name1 + " has won the tournament due to their better stats!");
      }
      else{
      System.out.println(name1 + " has won the tournament due to sheer luck!");
      }

    }
    else{
      System.out.println("The champion remains undefeated due to his superior stats!");
    }     
  }
}