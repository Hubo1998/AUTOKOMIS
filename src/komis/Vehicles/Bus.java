package komis.Vehicles;

import komis.Components;

public class Bus extends Vehicle {
    public Integer luggageSpace;

    public Bus(String producer, String model, Integer yearOfProduction, Segment segment, Double price,Integer luggageSpace, Components components) {
        super(producer, model, yearOfProduction, segment, price, components);
        this.luggageSpace=luggageSpace;
    }
    @Override
    public String toString() {
        return "Samochód dostawczy " + producer + " " + model + " przestrzeń bagażowa "+luggageSpace+" | " + yearOfProduction + " rok za " + Math.round(finalPrice);
    }
}
