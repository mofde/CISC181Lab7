package cisc181.lab_7;
//Represents a train car.
public class TrainCar {
    private String cargoType;
    private int weight;
    private TrainCar next;
    public TrainCar(String cargoType, int weight, TrainCar next) {
        this.cargoType = cargoType;
        this.weight = weight;
        this.next = next;
    }
    //getCargoType gets the current cargoType.
    public String getCargoType() {
        return this.cargoType;
    }
    //getWeight gets the current weight.
    public int getWeight() {
        return this.weight;
    }
    //getNext gets the current next TrainCar in the list.
    public TrainCar getNext() {
        return this.next;
    }
    //setCargoType sets the corresponding cargoType attribute to the cargoType value passed to the
    //method.
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
    //setWeight sets the corresponding weight attribute to the weight value passed to the method
    public void setWeight(int weight) {
        this.weight = weight;
    }
    //setNext sets the corresponding next attribute to the next value passed to the method, which is
    //the next TrainCar in the list.
    public void setNext(TrainCar next) {
        this.next = next;
    }
    //unload removes the cargo from the TrainCar and returns the cargo type the TrainCar used to
    //hold.
    public String unload() {
        String old = this.cargoType;
        this.cargoType = "";
        this.weight = 0;
        return old;
    }
    //toString prints "Empty Train Car" if the TrainCar is not carrying a cargo or prints the
    //following in order: "Cargo : ", the weight, " pounds of " and the cargo type.
    public String toString() {
        if (this.cargoType == "") {
            return "Empty Train Car";
        } else {
            return "Cargo : " + this.weight + " pounds of " + this.cargoType;
        }
    }
}