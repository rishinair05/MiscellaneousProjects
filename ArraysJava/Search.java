import java.util.*;
public class Search{
  int find;
  
  public Search(int initFind){
    find = initFind;
  }

  //A method that executes a linear search through an arrayList.
  public void sequentialSearch(){
    ArrayList<Integer> numbersList = new ArrayList<Integer>();
    numbersList.add(2);
    numbersList.add(3);
    numbersList.add(5);
    numbersList.add(7);
    numbersList.add(11);
    numbersList.add(13);
    numbersList.add(17);
    numbersList.add(19);
    numbersList.add(23);
    numbersList.add(29);
    numbersList.add(31);
    numbersList.add(37);
    numbersList.add(41);
    numbersList.add(43);
    numbersList.add(47);

    boolean inList = false;
    for (int i = 0; i < numbersList.size(); i++){
      if (numbersList.get(i) == find){
        inList = true;
      }
    }
    if (inList){
      System.out.println(find+ " is in the array.");
    }
    else{
      System.out.println(find+ " is not in the array");
    }
  }

  //A method that executes a binary search through an ArrayList.
  public void binarySearch(){
    ArrayList<Integer> numbersList = new ArrayList<Integer>();
    numbersList.add(2);
    numbersList.add(3);
    numbersList.add(5);
    numbersList.add(7);
    numbersList.add(11);
    numbersList.add(13);
    numbersList.add(17);
    numbersList.add(19);
    numbersList.add(23);
    numbersList.add(29);
    numbersList.add(31);
    numbersList.add(37);
    numbersList.add(41);
    numbersList.add(43);
    numbersList.add(47);
    
    int low = 0;
    int mid = 0;
    int high = numbersList.size()-1;
    while (high >= low){
      mid = (low + high)/2;
      if (find == numbersList.get(mid)){
        System.out.println(find + " is in the array");
        break;
      }
      else if (find < numbersList.get(mid)){
        high = mid;
      }
      else {
        low = mid+1;
        if (low == high){
        System.out.println(find + " is not in the array");
        break;
        }
      }
    }
  }

  //A method that prints out a 2D array using an enhanced for-loop.
  public void twoDArrayDisplay(){
    int[][] evenMoreNumbers = {{2, 4, 6}, {4, 8, 16}, {8, 16, 32}};
    for (int[] i : evenMoreNumbers){
      for (int j : i){
        System.out.print(j + " ");
      }
      System.out.println("");
    }
  }
}