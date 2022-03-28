//A child class called PC whose parent class is Device.
public class PC extends Device{
  //Private attributes of the class.
  private String GPU;
  private String motherboard;
  private String playMessage;
  private String PCgame;

  //PC's constructor which takes OS, CPU, memory, storage, GPU, and motherboard as inputs.
  public PC(String initOS, String initCPU, int initmemory, int initstorage, String initGPU, String initmotherboard){
    //The super keyword used to invoke immediate constructor of the Device class.
    super(initOS, initCPU, initmemory, initstorage);
    GPU = initGPU;
    motherboard = initmotherboard;
    playMessage = "You can play CSGO on this device.";
  }

  //A method which prints additional PC specs using the variables "GPU" and "motherboard" and the inherited variable "OS."
  public void specs2(){
    System.out.println("You also have a " + GPU + " GPU with an " + motherboard + " motherboard on the " + OS + " PC.");
  }

  //A method that prints out "playMessage."
  public void playPCGame(){
    System.out.println(playMessage);
  }

  //Overloading the method playGame().
  public void playPCGame(String initPCgame){
    PCgame = initPCgame;
    System.out.println(PCgame + " is currently running on the PC.");
  }
}