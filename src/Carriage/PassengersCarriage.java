package Carriage;

/**
 * Created by Deniska on 6/29/2016.
 */

enum PassCarriagesClass {ORDINARY, PREMIUM, LUX};

public class PassengersCarriage extends Carriage{
    public int passengers;

    public PassengersCarriage() {  //here should be type Ordinary, Premium, Lux
        this.height = 4.0;
        this.weight = 56;
        this.length = 26.0;
        this.carClass = PassCarriagesClass.ORDINARY.toString();
        this.passengers = 54;
    }

    public PassengersCarriage(String type) {  //here should be type ordinary, premium, lux
        if (type.equals("ordinary")) {
            this.carClass = PassCarriagesClass.ORDINARY.toString();
            this.carClassComp = 3;
            this.passengers = 54;
            this.height = 4.0;
            this.weight = 56;
            this.length = 26.0;
        } else if (type.equals("premium")) {
            this.carClass = PassCarriagesClass.PREMIUM.toString();
            this.carClassComp = 2;
            this.passengers = 36;
            this.height = 4.2;
            this.weight = 52;
            this.length = 25.0;
        } else if (type.equals("lux")) {
            this.carClass = PassCarriagesClass.LUX.toString();
            this.carClassComp = 1;
            this.passengers = 12;
            this.height = 4.4;
            this.weight = 50;
            this.length = 23.0;
        }
    }


}
