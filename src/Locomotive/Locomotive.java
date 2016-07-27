package Locomotive;

/**
 * Created by Deniska on 6/29/2016.
 */

enum LocomotivesTypes {
    LOCO_DIESEL_V1, LOCO_DIESEL_V2, LOCO_ELECTRIC_V1, LOCO_ELECTRIC_V2
};

enum LocomotivesNames {LOCO_FAST_DI, LOCO_SLOW_DI, LOCO_FAST_EL, LOCO_SUPERFAST_EL};

public class Locomotive {
    public String name;
    public String type;
    public double length;
    public int weight;

    public Locomotive() {
        this.name = LocomotivesNames.LOCO_FAST_DI.toString();
        this.type = LocomotivesTypes.LOCO_DIESEL_V1.toString();
        this.length = 30.0;
        this.weight = 220;
    }

    public Locomotive(int speed, int engineType) {
        switch (engineType) { // 0 - diesel, 1 - electric
            case 0:
                if (speed == 0) {
                    this.type = LocomotivesTypes.LOCO_DIESEL_V1.toString();
                    this.name = LocomotivesNames.LOCO_SLOW_DI.toString();
                    this.length = 25.0;
                    this.weight = 200;
                } else if (speed == 1) {
                    this.type = LocomotivesTypes.LOCO_DIESEL_V2.toString();
                    this.name = LocomotivesNames.LOCO_FAST_DI.toString();
                    this.length = 28.0;
                    this.weight = 220;
                }
                break;
            case 1:
                if (speed == 0) {
                    this.type = LocomotivesTypes.LOCO_ELECTRIC_V1.toString();
                    this.name = LocomotivesNames.LOCO_FAST_EL.toString();
                    this.length = 32.0;
                    this.weight = 170;
                } else {
                    this.type = LocomotivesTypes.LOCO_ELECTRIC_V2.toString();
                    this.name = LocomotivesNames.LOCO_SUPERFAST_EL.toString();
                    this.length = 35.0;
                    this.weight = 150;
                }
                break;
        }
    }
}
