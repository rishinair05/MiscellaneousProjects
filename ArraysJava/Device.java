//A parent class called Device.
public class Device{
  //Attributes of the class which are all general computer specs.
  String OS;
  String CPU;
  int storage;
  int memory;
  String console = "PS5";
  //A private attribute using the private keyword.
  private String noPlayMessage;

  //Device's constructor which takes in OS, CPU, memory and storage as input.
  public Device(String initOS, String initCPU, int initmemory, int initstorage){
    OS = initOS;
    CPU = initCPU;
    storage = initstorage;
    memory = initmemory;
    noPlayMessage = "I do not know which games the device can play.";
  }

  //A method called specs() which prints out the device's specs.
  public void specs(){
    System.out.println("This " + OS + " device runs on an " + CPU + " CPU with " + storage + "GB of hard drive space and " + memory + "GB of RAM.");
  }

  //An accessor method which returns the private variable "noPlayMessage."
  public String noPlayGame(){
    return this.noPlayMessage;
  }
}