package cisc181.lab_7;
//Represents a train.
public class Train {
    private TrainCar head;
    public Train() {
        this.head = null;
    }
    //attachAtEnd attaches a TrainCar to the end of the Train.
    public void attachAtEnd(String cargo, int weight) {
        if (this.head == null) {
            this.head = new TrainCar(cargo, weight, null);
        } else {
            TrainCar current = this.head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            TrainCar traincar = new TrainCar(cargo, weight, null);
            current.setNext(traincar);
        }
    }
    //attachAtFront attaches a TrainCar to the front of the Train.
    public void attachAtFront(String cargo, int weight) {
        if (this.head == null) {
            this.head = new TrainCar(cargo, weight, null);
        } else {
            TrainCar traincar = new TrainCar(cargo, weight, this.head);
            this.head = traincar;
        }
    }
    //countTrainCars counts the total number of TrainCars.
    public int countTrainCars() {
        int count = 0;
        TrainCar current = this.head;
        while (current != null) {
            count = count + 1;
            current = current.getNext();
        }
        return count;
    }
    //countEmptyTrainCars counts the total number of empty TrainCars.
    public int countEmptyTrainCars() {
        int count = 0;
        TrainCar current = this.head;
        while (current != null) {
            if (current.getCargoType() == "") {
                count = count + 1;
                current = current.getNext();
            } else {
                current = current.getNext();
            }
        }
        return count;
    }
    //totalWeight calculates the total weight of cargo that the Train is carrying.
    public int totalWeight() {
        int total = 0;
        TrainCar current = this.head;
        while (current != null) {
            total = total + current.getWeight();
            current = current.getNext();
        }
        return total;
    }
    //unloadCargo transverses the Train and unloads all the TrainCars that have that type of cargo
    //passed to the method.
    public int unloadCargo(String cargo) {
        int count = 0;
        TrainCar current = this.head;
        while (current != null) {
            if (current.getCargoType() == cargo) {
                count = count + 1;
                current.setCargoType("");
                current.setWeight(0);
                current = current.getNext();
            } else {
                current = current.getNext();
            }
        }
        return count;
    }
    //loadCargo loads the first empty TrainCar with the cargo. If there are no empty TrainCars, a
    //TrainCar is created, loaded and attached to the end of the Train.
    public void loadCargo(String cargo, int weight) {
        TrainCar current = this.head;
        while (current != null) {
            if (current.getCargoType() == "") {
                current.setCargoType(cargo);
                current.setWeight(weight);
                break;
            } else {
                current = current.getNext();
            }
        }
        if (current == null) {
            attachAtEnd(cargo, weight);
        }
    }
    //removeFromFront removes the first TrainCar from the train and returns the cargo that it held.
    //If there are no TrainCars, the method should return null.
    public String removeFromFront() {
        if (this.head == null) {
            return null;
        } else {
            TrainCar current = this.head;
            String cargo = this.head.getCargoType();
            current = current.getNext();
            this.head = current;
            return cargo;
        }
    }
    //insertCargoAfter inserts a TrainCar after the TrainCar with the second string passed to the
    //method, which is PreviousCargo.
    public void insertCargoAfter(String CurrentCargo, int weight, String PreviousCargo) {
        TrainCar current = this.head;
        while (current.getCargoType() != PreviousCargo) {
            if (current.getNext() == null) {
                TrainCar trainCar = new TrainCar(CurrentCargo, weight, null);
                current.setNext(trainCar);
                break;
            }
            current = current.getNext();
        }
        if (current.getCargoType() == PreviousCargo) {
            TrainCar traincar = new TrainCar(CurrentCargo, weight, current.getNext());
            traincar.setNext(current.getNext());
            current.setNext(traincar);
        }
    }
    //toString prints the toString values of each TrainCar in the Train starting at the first train.
    //If there are no TrainCars, it should print "Empty Train".
    public String toString() {
        if (this.head == null) {
            return "Empty Train";
        } else {
            TrainCar current = this.head;
            StringBuilder str = new StringBuilder();
            while (current != null) {
                str.append(current.toString()).append("\n");
                current = current.getNext();
            }
            return str.toString();
        }
    }
}