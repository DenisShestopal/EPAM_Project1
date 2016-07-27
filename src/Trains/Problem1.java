package Trains;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Train.Train;
import Locomotive.*;
import Carriage.*;

/**
 * 8.	Транспорт. Определить иерархию подвижного состава железнодорожного транспорта.
 * Создать пассажирский поезд.
 * Посчитать общую численность пассажиров и багажа.
 * Провести сортировку вагонов поезда на основе уровня комфортности.
 * Найти вагоны в поезде, соответствующие заданному диапазону параметров числа пассажиров.
 */

public class Problem1 {

    static void help(){
        System.out.println("Here you can find a list of commands:");
        System.out.println("add_train : adds a train (a locomotive and carriage(s) required).");
        System.out.println("add_locomotive [diesel, electric] [fast, slow] : adds a locomotive of chosen type and class.");
        System.out.println("add_carriage [lux, premium, ordinary] : adds a passengers carriage of chosen class.");
        System.out.println("add_carriage [oil, post, food, cargo] [12] : adds a cargo carriage of chosen type" +
                " of goods and tonnage. While entering 'cargo' it adds a standard cargo carriage.");
        System.out.println("remove_train : removes a train.");
        System.out.println("sort_carriages : for sorting the carriage list. First you will get carriages " +
                "with the higher class.");
        System.out.println("find_carriage [12] : shows all carriages, which has chosen number of seats.");
        System.out.println("print_train : prints a train.");
        System.out.println("print_cargo_weight : prints total wight of cargo.");
        System.out.println("print_weight : prints total trains' weight including cargo.");
        System.out.println("exit : to stop the programme.");
        System.out.println("help : to get a help information.");

    }
    public static void main(String[] args) {

        boolean flag = true;
        Train train = null;
        List<Carriage> array = new ArrayList<Carriage>(0);
        Locomotive locomotive = null;
        help();
        while (flag) {

            Scanner in = new Scanner(System.in);
            System.out.print("> ");
            String str = in.next();

            if (str.equals("add_carriage")) {
                String carriage = in.next();
                if (carriage.toLowerCase().equals("lux"))
                    array.add(new PassengersCarriage(carriage));
                else if (carriage.toLowerCase().equals("premium"))
                    array.add(new PassengersCarriage(carriage));
                else if (carriage.toLowerCase().equals("ordinary"))
                    array.add(new PassengersCarriage(carriage));
                else if (carriage.toLowerCase().equals("oil")) {
                    double cargoWeight = Double.valueOf(in.next());
                    array.add(new CargoCarriage(carriage, cargoWeight));
                } else if (carriage.toLowerCase().equals("food")) {
                    double cargoWeight = Double.valueOf(in.next());
                    array.add(new CargoCarriage(carriage, cargoWeight));
                } else if (carriage.toLowerCase().equals("post")) {
                    double cargoWeight = Double.valueOf(in.next());
                    array.add(new CargoCarriage(carriage, cargoWeight));
                } else if (carriage.toLowerCase().equals("cargo"))
                    array.add(new CargoCarriage());
                else {
                    array.add(new PassengersCarriage());
                }
                System.out.println("Carriage added");

            } else if (str.equals("add_locomotive")) {

                int engineType = (in.next().equals("diesel") ? 0 : 1);
                int speed = (in.next().equals("slow") ? 0 : 1);
                locomotive = new Locomotive(speed, engineType);
                System.out.println("Locomotive added.");


            } else if (str.equals("add_train")) {
                if (locomotive == null || array.size() == 0)
                    System.out.println("For new train creating we need a locomotive and an array of carriages.");
                else {
                    train = new Train(locomotive, array);
                    System.out.println("Train added.");
                }

            } else if (str.equals("remove_train")){
                train = null;
                System.out.println("Train removed");}
            else if (str.equals("print_train"))
                if (train == null) {
                    System.out.println("No train available. Please create one.");
                } else
                    train.printTrain();
            else if (str.equals("print_train_weight"))
                if (train == null) {
                    System.out.println("No train available. Please create one.");
                } else
                train.printTrainWeight();
            else if (str.equals("print_passengers"))
                if (train == null) {
                    System.out.println("No train available. Please create one.");
                } else
                train.printPassengers();
            else if (str.equals("print_cargo_weight"))
                if (train == null) {
                    System.out.println("No train available. Please create one.");
                } else
                train.printCargoWeight();
            else if (str.equals("find_carriage")) {
                if(array.size()==0){
                    System.out.println("No carriages available");
                }
                else{
                int passengers = Integer.parseInt(in.next());
                train.findCarriage(passengers);}
            } else if (str.equals("print_train_length")) {
                train.printTrainLength();
            } else if (str.equals("remove_carriage")) {
                int pos = Integer.parseInt(in.next());
                train.removeCarriage(pos);
            } else if (str.equals("sort_carriages")) {
                if (array.size() == 0) {
                    System.out.println("No carriages available");
                } else
                    train.sortCarriages();
            } else if (str.equals("help")) {
                help();
            } else if (str.equals("exit")) {
                flag = false;
            } else
                System.out.println("No such command available. Please enter 'help' to get help.");

        }

    }
}






