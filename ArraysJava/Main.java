/**
Name: Rishi Nair
Date: Feburary 23
Program Description: This program can:
1. Search for an integer in an ArrayList using a linear search.
2. Search for an integer in an ArrayList using a binary search.
3. Print a 2D array using an enhanced for-loop.
4. Display the specs of 4 devices and the games that can be run on the device.
*/

import java.util.*;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //Printing out options for the user.
    System.out.println("Welcome! Please try any of the following functions:");
    System.out.println("1: Sequential search through an ArrayList.");
    System.out.println("2: Binary search through an ArrayList.");
    System.out.println("3: Print values in a 2D Array using an enhanced for-loop.");
    System.out.println("4: Display some devices and their specs.");
    System.out.println("");

    //Getting user input for which function to execute.
    Scanner myObj1 = new Scanner(System.in);
    System.out.print("Please enter a method: ");
    int userMethod = myObj1.nextInt();

    if (userMethod == 1){
      //Executing a linear search for the integer "12" in an ArrayList. Creating an object named "sequential1" using the Search class.
      int find1 = 12;
      Search sequential1;
      sequential1 = new Search(find1);
      //The results of the search is printed through the sequentialSearch() method. 
      sequential1.sequentialSearch();
    }
      
    else if (userMethod == 2){
      //Executing a binary search for the integer "12" in an ArrayList. Creating an object named "sequential 2" using the Search class.
      int find2 = 23;
      Search binary1;
      binary1 = new Search(find2);
      //The results of the search is printed through the binarySearch() method.
      binary1.binarySearch();
    }
      
    else if (userMethod == 3){
      //Creating an object named "twoDArray" using the Search class.
      Search twoDArray1;
      twoDArray1 = new Search(0);
      //Printing a 2D array using the twoDArrayDisplay method.
      twoDArray1.twoDArrayDisplay();
    }

    else if (userMethod == 4){
      //Creating an object named "unknown" using the Device class. The inputs are all "unknown" or 0 for this device.
      Device unknown;
      unknown = new Device("Unkown", "Unkown", 0, 0);
      //Using the method specs() which prints the device's specs.
      unknown.specs();
      //Using the method noPlayGame() to print a statement about which games the device can play.
      System.out.println(unknown.noPlayGame());
      System.out.println("");

      //Creating an object named "gaming" using the Laptop class. The inputs are the specs of the PC.
      PC gaming;
      gaming = new PC("Windows", "i9-12900k", 32, 2000, "RTX-3900", "ASUS ROG MAXIMUS Z690 HERO");
      //Print out the specs of the PC using the method specs() which was inherited from the Device class.
      gaming.specs();
      //Printing additional specs of the PC.
      gaming.specs2();
      //Naming a game (CSGO) which can be played on a PC.
      gaming.playPCGame();
      //Printing a statement which states which game is currently played on the PC.
      gaming.playPCGame("World of Warcraft");
      System.out.println("");

      //Creating an object named "iphone" using the Phone class. The inputs are the specs of the phone.
      Phone iphone;
      iphone = new Phone("IOS", "A14", 4, 512, "Apple", "Dual 12MP", "iPhone 12");
      //Printing the specs of the PC using the toString() method.
      System.out.println(iphone);
      //Using the mutator method, latestModel, to change the value of the "model" variable in the iphone object.
      iphone.latestModel();
      //Using the printLatestModel() method to print the latest iphone model.
      iphone.printLatestModel();
      //Using the method noPlayGame() to print a statement about which games the device can play.
      System.out.println(iphone.noPlayGame());
      System.out.println("");

      //Creating an object named "playstation5" using the Playstation class. The inputs are the specs of the playstation.
      Playstation playstation5;
      playstation5 = new Playstation("playstation", "Custom 8-core AMD Zen 2", 16, 825, "PS5");
      //Printing the specs of the playstation.
      playstation5.specs3();
      playstation5.playPSGame();
    }
      
    else {
      System.out.println("Your input is not valid. Please input an integer from 1-4.");
    }
  }
}