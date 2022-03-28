/**
Name: Rishi Nair
Date: June 15, 2022
Program Description: In this program, the user plays against the computer, called "the Terminator" in a fighting game. The user and the Terminator can play 1 of 3 abilities each round. The game goes on until one of players loses all their health or if the game reaches 10 rounds, in which case a tie is declared.
*/

#include <iostream>
#include <cmath> 
#include <cstdlib>
#include <fstream>
using namespace std;

//A parent class called fighter that represents the player's character. Its attributes include the player's username, and stats (health, strength, intelligence, and agility).
class Fighter {
  public:
    double health;
    int strength;
    int agility;
    int intelligence;
    string username;

    int baseStat = 50;

//Constructor for the Fighter class.
    Fighter(string initUsername){
      username = initUsername;
      health = 100;
      strength = baseStat;
      agility = baseStat;
      intelligence = baseStat;
    }

//Methods punch(), stab() and heal() that are used during the fight by either the player or the computer.
    int punch(){
      return 25*(strength/50);
    }

    int stab(){
      return 25*(agility/50);
    }

    void heal(){
      health = health + 25*(intelligence/50);
    }
};

//A child class called Terminator whose parent class is the Fighter class.
class Terminator : public Fighter{
  public:
    //The constructor for the Terminator class.
    Terminator(string initUsername) : Fighter(initUsername){
      username = initUsername;
      health = 125;
      agility = baseStat + 25;
      strength = baseStat + 25;
      intelligence = baseStat + 25;
    }

//An overriden heal() that is weaker than the Fighter's heal().
    void heal(){
      health = health + 10;
    }
};

//A recursive function that counts down from an input integer.
void countdown(int initNumber){
  if (initNumber > 0){
    cout << initNumber;
    cout << " ";
    countdown(initNumber - 1);
  }
}

int main() {
//Print statements that welcome the player into the game.
  cout << "Welcome to the ultimate fighting game! \n";
  cout << "In this game, you will fight the terminator, the strongest fighter in the world. \n";
  cout << "\n";
  string name; 
  cout << "Please enter your name: ";
  cin >> name;

  Fighter player(name);
  cout << "\n";

//Welcomes the user to the game and prints out the player's stats.
  cout << "Hello " << name << "! Welcome to the ultimate fighting game. \n";
  cout << "Your stats are: \n";
  cout << "Health: " << player.health << "\n";
  cout << "Strength: " << player.agility << "\n";
  cout << "Agility: " << player.strength << "\n";
  cout << "Intelligence: " << player.intelligence << "\n";

  bool repeat = true;

  while(repeat){
//The player can pick a stat buff.
    string superStat;
    cout << "Pick one super stat (this stat will be twice its current value). Please use lowercase letters: ";
    cin >> superStat;
    cout << "\n";

//Applies a stat buff to one of the player's stat.
    if(superStat == "health"){
      player.health = player.health * 2;
      cout << "Your new health: " << player.health << "\n";
      repeat = false;
    }
    else if(superStat == "strength"){
      player.strength = player.strength * 2;
      cout << "Your new strength: " << player.strength << "\n";
      repeat = false;
    }
    else if(superStat == "agility"){
      player.agility = player.agility * 2;
      cout << "Your new agility: " << player.agility << "\n";
      repeat = false;
    }
    else if(superStat == "intelligence"){
      player.intelligence = player.intelligence * 2;
      cout << "Your new intelligence: " << player.intelligence << "\n";
      repeat = false;
    }  
  }


//Prints out the rules of the game.
  Terminator computer("The Terminator");
  cout << "The terminator is much stronger than you but is not skilled at fighting. \n";
  cout << "You have 3 moves. Punch, stab and heal. Punch and stab deal damage to the enemy and heal increases your health. The more strength you have, the more damage punch does to the Terminator. The more agility you have, the more damage stab does to the Terminator. The more intelligence you have, the more health you regain by when using heal \n";
  cout << "\n";

  cout << "The Terminator's health: " << computer.health << "\n";
  string playerMove;
  for(int i = 0; i < 11; i++){
    if(i == 10){
      cout << "You and the Terminator are very tired. You both call a draw.";
      break;
    }

//Gets input from the user of what their move should be. Based on the user's selected move, a method from the fighter's class is executed.
    cout << "Your move (please input punch, stab or heal): ";
    cin >> playerMove;
    cout << "\n";
    if (playerMove == "punch"){
      computer.health = computer.health - player.punch();
    }
    else if (playerMove == "stab"){
      computer.health = computer.health - player.stab();
    }
    else if (playerMove == "heal"){
      player.heal();
    }
    else{
      cout << "You are too clumsy and failed to execute a legit move. \n";
    }

//The Terminator cycles through the three moves.
    if (i%3 == 0){
      player.health = player.health - computer.punch();
      cout << "The Terminator punches you! \n";
    }
    else if (i%3 == 1){
      player.health = player.health - computer.stab();
      cout << "The Terminator stabs you! \n";
    }
    else if (i%3 == 2){
      computer.heal();
      cout << "The Terminator heals. \n";
    }

//Prints out the player's and the terminator's health at the end of each round.
    cout << "Your health: " << player.health << "\n";
    cout << "The Terminator's health: " << computer.health << "\n";

//If the terminator's health is less than or equal to 0, then player wins. If the player's health is less than or equal to 0, then the terminator wins.
    if(computer.health <= 0){
      cout << "\n";
      cout << "You have beat the Terminator!!! Congratulations! \n";
      break;
    }
    if(player.health <= 0){
      cout << "You have lost to the Terminator. Better luck next time. \n";
      break;
    }
  }

  cout << " \n";
  cout << "Thank you for playing! \n";
  cout << "Game closing in: ";

  //Using the countdown() method and an array of integers, a countdown to close the game is initiated.
  int countdownStart[5] = {10, 9, 8, 7, 6};
  for(int k = 0; k < 5; k++){
    cout << countdownStart[k];
    cout << " ";
  }
  countdown(5);
}