/**
Trivia: A game of trivia players between the first and second contestant and the third and fourth contestant. The contestant with the higher intelligence stat wins.
Rishi Nair
*/

//A class called trivia that determines a winner between two contestants. The attributes of this object are the names and stats of the two contestants that are facing off.
public class Trivia{
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

  //The Trivia class takes the name and stats of the two players as input.
  public Trivia(String initName1, int initVitality1, int initStrength1, int initIntelligence1, int initLuck1, String initName2, int initVitality2, int initStrength2, int initIntelligence2, int initLuck2){
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

  //A method that prints out the results of the trivia game. The contestant who has the higher intelligence stat wins.
  public String triviaResults(){
    System.out.println(name1 + " and " + name2 + " will face off in a trivia.");
    if (intelligence1 > intelligence2){
      System.out.println(name1 + " won the trivia due to their superior intellect.");
      return name1;
    }
    else{
      System.out.println(name2 + " won the trivia due to their superior intellect.");
      return name2;
    }
  }

  //Methods that return the stats of the winner when called.
  public int triviaVitality(){
    if (intelligence1 > intelligence2){
      return vitality1;
    }
    else{
      return vitality2;
    }
  }

  public int triviaStrength(){
    if (intelligence1 > intelligence2){
      return strength1;
    }
    else{
      return strength2;
    }
  }

  public int triviaIntelligence(){
    if (intelligence1 > intelligence2){
      return intelligence1;
    }
    else{
      return intelligence2;
    }
  }
  
  public int triviaLuck(){
    if (intelligence1 > intelligence2){
      return luck1;
    }
    else{
      return luck2;
    }
  }
}