package komis.Vehicles;

import komis.Components;
import komis.Mechanic;
import komis.Player;

import java.util.Random;

public abstract class Vehicle extends Components {
    final public String model;
    final public String producer;
    final public Integer yearOfProduction;
    final public Car.Segment segment;
    public Double price;
    public Double finalPrice;
    Random rand = new Random();

    public enum Segment {
        Premium, Standard, Budget, NA
    }

    public Vehicle(String producer, String model, Integer yearOfProduction, Car.Segment segment, Double price, Components components) {
        super(components.brakesAreOk, components.suspensionIsOk, components.engineIsOk, components.bodyIsOk, components.gearboxIsOk);
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.segment = segment;
        this.price = price;
        this.finalPrice = price;
    }
    public void repair(Comps comps, Mechanic steve, Player player) {
        double priceRandomized = rand.nextInt(11) + steve.price;
        double priceRandomizedextra = rand.nextInt(11) + Mechanic.Janusz.price;
        int halfOfmechanicprice= (int) Math.round(((price * valueOf(comps)) * (priceRandomized / 100)) / 2);
        int januszprice= (int) Math.round((price * valueOf(comps))*(priceRandomizedextra/100));
        double priceOfWholeWork=(price * valueOf(comps)) * (priceRandomized / 100);
        int chanceOfSuccess = rand.nextInt(101);
        int chanceOfBroke = rand.nextInt(101);
        if (chanceOfSuccess >= steve.guarantee & player.finalCash - priceOfWholeWork > 0) {
            //w zadaniu nie jest opisane, czy przy niepowodzeniu naprawy ma być pobierana opłata,
            //założyłem, że będzie pobierana połowa kwoty naprawy, która by się zakończyła powodzeniem.
            System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki: "+halfOfmechanicprice+" a dodatkowo Januszowi: "+januszprice);
            player.finalCash -= halfOfmechanicprice;
            player.finalCash -= januszprice;
            setService(comps,true);
            finalPrice+=(price*valueOf(comps));
            player.counter+=1;
            if (chanceOfBroke <= steve.brokelse) {
                System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                breakSomething();
            }
        } else if (player.finalCash - priceOfWholeWork > 0) {
            player.finalCash -= priceOfWholeWork;
            finalPrice += (price * valueOf(comps));
            setService(comps,true);
            System.out.println(nameOfComp(comps) + " naprawione, cena za usługę:" + Math.round(price * valueOf(comps) * (priceRandomized / 100)));
            player.counter+=1;
        } else {
            System.out.println("Nie stać Cię");
        }
    }
    public void carPartsStatus(){
        if(brakesAreOk) System.out.println("1. Hamulce OK");
        else System.out.println("1. Hamulce NIE OK");
        if(suspensionIsOk) System.out.println("2. Zawieszenie OK");
        else System.out.println("2. Zawieszenie NIE OK");
        if(engineIsOk) System.out.println("3. Silnik OK");
        else System.out.println("3. Silnik NIE OK");
        if(bodyIsOk) System.out.println("4. Karoseria OK");
        else System.out.println("4. Karoseria NIE OK");
        if(gearboxIsOk) System.out.println("5. Skrzynia biegów OK");
        else System.out.println("5. Skrzynia biegów NIE OK");
    }
    public boolean isCarOk(){
        return brakesAreOk & suspensionIsOk & engineIsOk & bodyIsOk & gearboxIsOk;
    }
}
