package Train;

import Carriage.*;
import Locomotive.*;

import java.util.*;

/**
 * Created by Deniska on 6/29/2016.
 */
public class Train{

    Locomotive locomotive;
    List<Carriage> carriageList;
    double trainLength = 0;

    public Train() {
        this.locomotive = new Locomotive();
        this.carriageList = new ArrayList<Carriage>(1);
        this.trainLength = this.trainLength + locomotive.length;
    }

    public Train(Locomotive locomotive, List<Carriage> carriageList) {
        this.locomotive = locomotive;
        this.carriageList = carriageList;
        for (Carriage car : this.carriageList) {
            this.trainLength = this.trainLength + car.length;
        }
        this.trainLength = this.trainLength + locomotive.length;
    }

    public void printTrain() {
        System.out.print("Your train consists of train: " + locomotive.name + " of type: " + locomotive.type + "\n");
        System.out.print("Carriages: ");
        for (Carriage car : carriageList) {
            System.out.print(car.carClass + "\t");
            if (car instanceof CargoCarriage)
                System.out.print("("+((CargoCarriage) car).cargoType+")"+"\t");
        }
        System.out.println("\n");
    }

    public void printTrainWeight() {
        int w = 0;
        for (Carriage car : carriageList) {
            w += car.weight;
        }
        System.out.println("Train weight is: " + (locomotive.weight + w) + " tons");
    }

    public void printPassengers() {
        int pass = 0;
        for (Carriage car : carriageList) {
            if (car instanceof PassengersCarriage) {
                pass += ((PassengersCarriage) car).passengers;
            }
        }
        System.out.println("Passengers count is : " + pass);
    }

    public void printCargoWeight() {
        double cargoWeight = 0.0;
        for (Carriage car : carriageList) {
            if (car instanceof CargoCarriage) {
                cargoWeight += ((CargoCarriage) car).cargoWeight;
            }
        }
        System.out.println("Total cargo weight is : " + cargoWeight + " tons.");

    }

    public void sortCarriages(){
        Collections.sort(carriageList);
        System.out.println("Carriages are sorted.");

    }


    public void findCarriage(int passengers) {
        int number = 1;
        int k = 0;
        for (Carriage car : carriageList) {
            if (car instanceof PassengersCarriage && ((PassengersCarriage) car).passengers == passengers) {
                System.out.print("Carriages №№ " + number + " ");
                k += 1;
            }
            number += number;
        }
        if (k > 0)
            System.out.println(" satisfy your request.\t");
        else
            System.out.println("None of carriages satisfy your request.");

    }

    public void printTrainLength() {
        System.out.println("Train length is :" + this.trainLength + " meters. ");
    }

    public void removeCarriage(int pos) {
        if (pos >= 1 && pos < carriageList.size()) {
            carriageList.remove(pos - 1);
            System.out.println("Carriage № " + pos + "was removed.");
        } else if (carriageList.size() == 0) {
            System.out.println("There are no carriages in this train.");
        } else
            System.out.println("No such carriage found. Please enter a value between 1 and " + carriageList.size());

    }

}
