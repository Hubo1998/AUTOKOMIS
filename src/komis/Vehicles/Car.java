package komis.Vehicles;

import komis.Components;

public class Car extends Vehicle {
    public Car(String producer, String model, Integer yearOfProduction, Segment segment, Double price, Components components) {
        super(producer,model,yearOfProduction,segment,price,components);
    }
    @Override
    public String toString() {
        return "Samochód osobowy "+producer + " " + model + " " + yearOfProduction + " rok za " + Math.round(finalPrice);
    }
}


