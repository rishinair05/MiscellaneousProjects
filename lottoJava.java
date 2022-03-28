/**
Name: Rishi Nair
Date: April 22, 2022
Program Description: This program simulates a lottery. The program first generates six random numbers from 1-49 which are the user's quick pick numbers. These numbers are then sorted using selection sort. Subsequently, 6 more numbers from 1-49 are randomly generated for the lottery winning numbers. These numbers are sorted using insertion sort. Using linear search, the program tells how many matching numbers there are between the user's quick pick numbers and the lottery winning number. Based on the number of matching numbers, the user may win a prize. A bonus number is also randomly generated from 1-49. If the bonus number is present in the user's quick pick numbers, the user wins a free ticket.
*/

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

class Main {
//A selection sort algorithm that takes an array and a target integer as input and orders it from smallest to largest value. A selection sort algorithm works by going through all the elements in the array and then finds the smallest element. This element is then placed in the first index of the array. This process repeats until all the elements have been sorted.
  public static void selectionSort(int[] elements){
    for(int j = 0; j < elements.length - 1; j++){
      int minIndex = j;
      for (int k = j + 1; k < elements.length; k++){
        if (elements[k] < elements[minIndex]){
          minIndex = k;
        }
      }
      int temp = elements[j];
      elements[j] = elements[minIndex];
      elements[minIndex] = temp;
    }
  }

//An insertion sort algorithm that takes an array and a target integer as input and orders it from smallest to largest value. An insertion sort algorithm works by comparing the second element in an array to its predacessor element. If the element is smaller than the predacessor element, then it compared to the element before (which repeats until the element is larger than the elements before). If the element is larger than the predaccesor element, then the element is placed in front of the predacessor element. This process is repeated for every element from the second element in the array to the last element.
  public static void insertionSort(int array[]){
    int n = array.length;
    for(int j = 1; j < n; j++){
      int key = array[j];
      int i = j - 1;
      while ((i > -1) && (array [i] > key)){
        array[i+1] = array[i];
        i--;
      }
      array[i+1] = key;
    }
  }

//A linear search algorithm that takes an array and a target number as input and returns "true" if the target number is in the array and "false" if the target number is not in the array. It does this by comparing the target number to every element in the array until it finds a match.
  public static boolean linearSearch(int[] elements, int target){
    for (int j = 0; j < elements.length; j++){
      if (elements[j] == target){
        return true; 
      }
    }
    return false;
  }

//A binary search algorithm that takes a sorted array and a target number as input and returns "true" if the target number is in the array and "false" if the target number is not in the array. It does this by splitting the sorted array in half repeatedly until the target number is found.
  public static boolean binarySearch(int[] elements, int target){
    int low = 0;
    int mid = 0;
    int high = elements.length-1;

    while (high >= low){
      mid = (low + high) / 2;
      if (target < elements[mid]){
        high = mid - 1;
      }
      else if (target == elements[mid]){
        return true;
      }
      else low = mid+1;
    }
    return false;
  }

//A method that takes two arrays as input and outputs an ArrayList of all the shared elements in the two arrays. 
  public static ArrayList<Integer> arrayLinearSearch(int[] elements, int[] targets){
    ArrayList<Integer> matchingNumbers = new ArrayList <Integer>(); //An ArrayList called matchingNumbers is initialized.
    for (int j = 0; j < targets.length; j++){ //A for loop that is set to iterate m times, where m is the number of elements in the target array.
      if (linearSearch(elements, targets[j])){ //The linearSearch() method checks if an element in the target array is in the elements array.
        matchingNumbers.add(targets[j]); //If an element is in both the arrays, it is added to the matchingNumbers ArrayList.
      }
    }
    return matchingNumbers; //Return the ArrayList matchingNumbers.
  }

//A method that tells the user how much money they earned based on the number of matched numbers.
  public static String lottoPrize(int lottoMatches){
    if (lottoMatches == 3){
      return "$10! Congrats!";
    }
    else if (lottoMatches == 4){
      return "$10000! Congrats!";
    }

    else if (lottoMatches == 5){
      return "$1000000! Congrats on the huge prize!";
    }

    else if (lottoMatches == 6){
      return "$10000000! You have won the grand prize!";      
    }

    else{
      return "$0. Better luck next time.";
    }
  }

//A method that checks for duplicate elements in an array.
  public static boolean duplicateCheck(int[] array){
    for (int i = 0; i < array.length; i++){
      for (int j = i + 1; j < array.length; j++){
        if (array[i] == array[j]){
          return true;
        }
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    int[] yourNumbers = new int[6];
    Random rand = new Random();
//Generate an array of 6 random numbers in the interval 1 to 49. This array represents the user's quick pick numbers.
    while (duplicateCheck(yourNumbers)){
      for (int i = 0; i < 6; i++){
      yourNumbers[i] = rand.nextInt(48) + 1;
      }
    }
    
    int[] lottoNumbers = new int[6];
    Random rand2 = new Random();
//Generate an array of 6 random numbers in the interval 1 to 49. This array represents the lotto winning numbers.
    while (duplicateCheck(lottoNumbers)){
      for (int i = 0; i < 6; i++){
      lottoNumbers[i] = rand.nextInt(48) + 1;
      }    
    }

//Generate a bonus number in the interval 1 to 49.
    Random rand3 = new Random();
    int bonusNumber = rand.nextInt(48) + 1;

//Print out the user's numbers.
    System.out.println("Your winning numbers are: " + Arrays.toString(yourNumbers).replace("[", "").replace("]", ""));
//Sort the user's numbers using selection sort. 
    selectionSort(yourNumbers);
//Print out the user's sorted numbers.
    System.out.println("These numbers sorted are: " + Arrays.toString(yourNumbers).replace("[", "").replace("]", ""));
//Print out the lotto winning numbers.
    System.out.println("The winning numbers are: " + Arrays.toString(lottoNumbers).replace("[", "").replace("]", ""));
//Sort the lotto winning numbers using insertion sort.
    insertionSort(lottoNumbers);
//Print out the sorted lotto winning numbers.
    System.out.println("The winning numbers sorted are: " + Arrays.toString(lottoNumbers).replace("[", "").replace("]", ""));
//Using the arrayLinearSearch() method, print out how many numbers were matched and which numbers were matched.
    System.out.println("You have matched " + arrayLinearSearch(yourNumbers, lottoNumbers).size() + " numbers: " + arrayLinearSearch(yourNumbers, lottoNumbers).toString().substring(1, arrayLinearSearch(yourNumbers, lottoNumbers).toString().length() - 1));
//Print out the amount of money won by the user using the lottoPrize() method.
    System.out.println("You have won " + lottoPrize(arrayLinearSearch(yourNumbers, lottoNumbers).size()));
//Print out the bonus number.
    System.out.println("The bonus number is " + bonusNumber);
//Using the binarySearch() method, check if the bonus number is in the user's quick pick numbers. If it is, then the user wins a free lotto ticket.
    if(binarySearch(yourNumbers, bonusNumber)){
      System.out.println("You have won a free ticket since your quick pick numbers has the bonus number!");
    }
    else{
      System.out.println("You have not won a free ticket since your quick pick numbers does not have the bonus number. Better luck next time.");
    }
  }
}