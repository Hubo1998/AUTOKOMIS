package komis.Vehicles;

import komis.Components;

public class Moto extends Vehicle {
    public Moto(String producer, String model, Integer yearOfProduction, Segment segment, Double price, Components components) {
        super(producer, model, yearOfProduction, segment, price, components);
    }
    @Override
    public String toString() {
        return "Motocykl "+producer + " " + model + " " + yearOfProduction + " rok za " + Math.round(finalPrice);
    }
}
