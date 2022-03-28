//A child class called Playstation whose parent class is Device.
public class Playstation extends Device{
  private String PSmodel;

  //Playstation's constructor which takes OS, CPU, memory, storage and model as inputs.
  public Playstation(String initOS, String initCPU, int initmemory, int initstorage, String initPSmodel){
    super(initOS, initCPU, initmemory, initstorage);
    PSmodel = initPSmodel;
  }

  //A method that uses the super keyword to invoke the method specs() from the Device class. The method uses an inherited variable from the Device class called console.
  public void specs3(){
    super.specs();
    //Inheriting the console variable in the Device class using the super keyword.
    System.out.println("Cool " + super.console + ".");
  }

  //A method that displays a game which can be played on the Playstation.
  public void playPSGame(){
    System.out.println("You can play Bloodbourne on this device.");
  }
}