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
        super(components.brakesAreOk, components.suspensionIsOk, components.engineIsOk, components.bodyIsOk, components.gearboxIsOk);
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.segment = segment;
        this.price = price;
        this.finalPrice = price;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + yearOfProduction + " rok za " + Math.round(finalPrice);
    }

    //@Override
    public void repair(Comps comps, Mechanic steve, Player player) {
        double priceRandomized = rand.nextInt(11) + steve.price;
        double priceRandomizedextra = rand.nextInt(11) + Mechanic.Janusz.price;
        int halfOfmechanicprice= (int) Math.round(((price * valueOf(comps)) * (priceRandomized / 100)) / 2);
        int januszprice= (int) Math.round((price * valueOf(comps))*(priceRandomizedextra/100));
        int chanceOfSuccess = rand.nextInt(101);
        int chanceOfBroke = rand.nextInt(101);
        int thingBroken = rand.nextInt(5);
        if (isCompOk(comps)) {
            System.out.println(nameOfComp(comps) + " są sprawne");
        } else if (chanceOfSuccess >= steve.guarantee & player.finalCash - (price * valueOf(comps)) * (priceRandomized / 100) > 0) {
            //w zadaniu nie jest opisane, czy przy niepowodzeniu naprawy ma być pobierana opłata,
            //założyłem, że będzie pobierana połowa kwoty naprawy, która by się zakończyła powodzeniem.
            System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki:"+halfOfmechanicprice+" a dodatkowo Januszowi:"+januszprice);
            player.finalCash -= halfOfmechanicprice;
            player.finalCash -= januszprice;
            setService(comps);
            finalPrice+=(price*valueOf(comps));
            player.counter+=1;
            if (chanceOfBroke <= steve.brokelse) {
                System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                int x=breakSomething(thingBroken);
                System.out.println("Zepsuto:" + nameOfComp(comps));
            }
        } else if (player.finalCash - (price * valueOf(comps)) * (priceRandomized / 100) > 0) {
            player.finalCash -= (price * valueOf(comps)) * (priceRandomized / 100);
            finalPrice += (price * valueOf(comps));
            setService(comps);
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


