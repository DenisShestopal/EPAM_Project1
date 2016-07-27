package Carriage;

/**
 * Created by Deniska on 6/29/2016.
 */

enum CargoCarriageType {OIL, FOOD, POST};

enum CargoCarriageClass {LARGE, SMALL};

public class CargoCarriage extends Carriage{

        public String cargoType;
        public double cargoWeight;
        //public String carClass;

        public void setCargoWeigth(double weigth) {
            this.cargoWeight = weigth;
        }

        public CargoCarriage() {
            this.carClass = CargoCarriageClass.LARGE.toString();
            this.cargoType = CargoCarriageType.FOOD.toString();
            this.cargoWeight = 0.0;
            this.weight = 46;
        }

        public CargoCarriage(String type, double weight) {//here should be oil, food or post and weight's (double) value
            if (type.equals("oil")) {
                this.carClass = CargoCarriageClass.LARGE.toString();
                this.cargoWeight = weight;
                this.cargoType = CargoCarriageType.OIL.toString();
                this.weight = super.weight + (int) weight;
                this.carClassComp = 5;
            } else if (type.equals("food")) {
                this.carClass = CargoCarriageClass.SMALL.toString();
                this.cargoWeight = weight;
                this.cargoType = CargoCarriageType.FOOD.toString();
                this.weight = super.weight + (int) weight;
                this.carClassComp = 5;
            } else if (type.equals("post")) {
                this.carClass = CargoCarriageClass.SMALL.toString();
                this.cargoWeight = weight;
                this.cargoType = CargoCarriageType.POST.toString();
                this.weight = super.weight + (int) weight;
                this.carClassComp = 4;
            }
        }
}
