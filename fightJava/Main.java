/**
Name: Rishi Nair
Date: January 7, 2022
Program Description: In this program, 4 contestant objects are created using the Contestant Class and a champion object is created using the Champion class. Through a series of 2 games (a trivia and a coinflip), the contestants fight each other until there is one contestant left. The winner out of the 4 contestants face the champion in a fight game. Dependings on the results of the final game, either a contestant wins or the champion wins.  
*/

class Main {
  public static void main(String[] args){
    //Create 4 objects using the Contestant class and one object using the Champion class.
    System.out.println("");
    Contestant contestant1 = new Contestant();
    Contestant contestant2 = new Contestant();
    Contestant contestant3 = new Contestant();
    Contestant contestant4 = new Contestant();
    Champion champion = new Champion();
    System.out.println("");

    //Creating two new objects called trivia1 and trivia2 using the trivia class. The winner of each trivia game is printed through the triviaResults() method and the winner's stats are stored in a set of variables.
    Trivia trivia1;
    trivia1 = new Trivia(contestant1.name, contestant1.vitality, contestant1.strength, contestant1.intelligence, contestant1.luck, contestant2.name, contestant2.vitality, contestant2.strength, contestant2.intelligence, contestant2.luck);
    String winner1 = trivia1.triviaResults();
    int winner1Vitality = trivia1.triviaVitality();
    int winner1Strength = trivia1.triviaStrength();
    int winner1Intelligence = trivia1.triviaIntelligence();
    int winner1Luck = trivia1.triviaLuck();
    System.out.println("");

    Trivia trivia2;
    trivia2 = new Trivia(contestant3.name, contestant3.vitality, contestant3.strength, contestant3.intelligence, contestant3.luck, contestant4.name, contestant4.vitality, contestant4.strength, contestant4.intelligence, contestant4.luck);
    String winner2 = trivia2.triviaResults();
    int winner2Vitality = trivia2.triviaVitality();
    int winner2Strength = trivia2.triviaStrength();
    int winner2Intelligence = trivia2.triviaIntelligence();
    int winner2Luck = trivia2.triviaLuck();
    System.out.println("");

    //Creating a new object called coinflip1 that makes the winners of the trivia games face each other in a coinflip game. The winner of the coinflip is printed through the coinflipResults() method and the winner's stats are stored in a set of variables.
    Coinflip coinflip1;
    coinflip1 = new Coinflip(winner1, winner1Vitality, winner1Strength, winner1Intelligence, winner1Luck, winner2, winner2Vitality, winner2Strength, winner2Intelligence, winner2Luck);
    String winner3 = coinflip1.coinflipResults();
    int winner3Vitality = coinflip1.coinflipVitality();
    int winner3Strength = coinflip1.coinflipStrength();
    int winner3Intelligence = coinflip1.coinflipIntelligence();
    int winner3Luck = coinflip1.coinflipLuck();
    System.out.println("");

    //Creating a new object called fight1 that makes the winner of the coinflip games face a champion object in a fight. The winner of the fight is printed through the fightResults() method.
    Fight fight1;
    fight1 = new Fight(winner3, winner3Vitality, winner3Strength, winner3Intelligence, winner3Luck, champion.vitality, champion.strength, champion.intelligence);
    fight1.fightResults();

  }
}