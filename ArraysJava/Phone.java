//A child class called Phone whose parent class is Device.
public class Phone extends Device{
  //Private attributes of the class.
  private String brand;
  private String camera;
  private String model;

  //Phone's constructor which takes OS, CPU, memory, storage, brand, camera and model as inputs.
  public Phone(String initOS, String initCPU, int initmemory, int initstorage, String initbrand, String initcamera, String initmodel){
    super(initOS, initCPU, initmemory, initstorage);
    brand = initbrand;
    camera = initcamera;
    model = initmodel;
  }

  //A mutator method which changes the value of the private variable "model."
  public void latestModel(){
      model = "IPhone 13";
    }

  //A method that prints out the latest model of the iphone. Meant to be executed after latestModel() is executed.
  public void printLatestModel(){
    System.out.println("The latest model of the iPhone is the " + model + ".");
  }

  //The toString() method which prints the specs of the phone.
  public String toString(){
    return "This " + brand + " " + model + " has " + storage + "GB of storage, runs on the " + CPU + " chip and has a " + camera + " camera.";
  }

  //Overriding the noPlayGame() method to print a different message.
  public String noPlayGame(){
    return "You cannot play any PC games on this device. However, there are plently of mobile games to enjoy.";
  }
}