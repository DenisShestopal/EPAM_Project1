package Carriage;

/**
 * Created by Deniska on 6/29/2016.
 */

public class Carriage implements Comparable<Carriage>{
    public double height;
    public int weight;
    public double length;
    public String carClass;
    public int carClassComp;

    public Carriage() {
        this.height = 4.0;
        this.length = 25.0;
        this.weight = 36;
    }

    public int compareTo(Carriage car){
        if(this.carClassComp < car.carClassComp){
            return -1;
        }
        else if(this.carClassComp > car.carClassComp){
            return 1;
        }
        return 0;
    }
}
