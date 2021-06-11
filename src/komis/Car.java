package komis;

import java.util.Random;

public class Car extends Components {
    final public String model;
    final public String producer;
    final public Integer yearOfProduction;
    final public Segment segment;
    public Double price;
    public Double finalPrice;
    Random rand = new Random();

    public enum Segment {
        Premium,
        Standard,
        Budget,
        NA
    }

    public Car(String producer, String model, Integer yearOfProduction, Segment segment, Double price, Components components) {
        super(components);
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.segment = segment;
        this.price = price;
        this.finalPrice = price;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + yearOfProduction + " rok za " + Math.round(price);
    }

    //@Override
    public void repair(Comps comps, Mechanic steve, Player player) {
        double priceRandomized = rand.nextInt(11) + steve.price;
        double priceRandomizedextra = rand.nextInt(11) + Mechanic.Janusz.price;
        int chanceOfSuccess = rand.nextInt(101);
        int chanceOfBroke = rand.nextInt(101);
        int thingBroken = rand.nextInt(5);
        if (isCompOk(comps)) {
            System.out.println(comps + " są sprawne");
        } else if (chanceOfSuccess >= steve.guarantee) {
            //w zadaniu nie jest opisane, czy przy niepowodzeniu naprawy ma być pobierana opłata,
            //założyłem, że będzie pobierana połowa kwoty naprawy, która by się zakończyła powodzeniem.
            System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki a dodatkowo Januszowi");
            player.cash -= ((price * valueOf(comps)) * (priceRandomized / 100)) / 2;
            player.cash -= (price * valueOf(comps)) * (priceRandomizedextra / 100);
            if (chanceOfBroke <= steve.brokelse) {
                System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                breakSomething(thingBroken);
                System.out.println("Zepsuto:" + LISTofComponents[thingBroken]);
            }
        } else if (player.cash - (price * valueOf(comps)) * (priceRandomized / 100) > 0) {
            player.cash -= (price * valueOf(comps)) * (priceRandomized / 100);
            finalPrice += (price * valueOf(comps));
            setService(comps);
            System.out.println(comps + " naprawione, cena za usługę:" + Math.round(price * valueOf(comps) * (priceRandomized / 100)));
        } else {
            System.out.println("Nie stać Cię");
        }
    }
    public void carPartsStatus(){
        if(brakesAreOk) System.out.println("Hamulce OK");
        else System.out.println("Hamulce NIE OK");
        if(suspensionIsOk) System.out.println("Zawieszenie OK");
        else System.out.println("Zawieszenie NIE OK");
        if(engineIsOk) System.out.println("Silnik OK");
        else System.out.println("Silnik NIE OK");
        if(bodyIsOk) System.out.println("Karoseria OK");
        else System.out.println("Karoseria NIE OK");
        if(gearboxIsOk) System.out.println("Skrzynia biegów OK");
        else System.out.println("Skrzynia biegów NIE OK");
        }

}


