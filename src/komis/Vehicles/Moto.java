package komis.Vehicles;

import komis.Components;
import komis.Mechanic;
import komis.Player;

public class Moto extends Vehicle {
    public Moto(String producer, String model, Integer yearOfProduction, Segment segment, Double price, Components components) {
        super(producer, model, yearOfProduction, segment, price, components);
    }
    @Override
    public String toString() {
        return "Motocykl "+producer + " " + model + " " + yearOfProduction + " rok za " + Math.round(finalPrice);
    }
    @Override
    public void repair(Comps comps, Mechanic steve, Player player) {
        double priceRandomized = rand.nextInt(11) + steve.price*0.75; //tańsze naprawy moto *0.75
        double priceRandomizedextra = rand.nextInt(11) + Mechanic.Janusz.price*0.75;
        int halfOfmechanicprice= (int) Math.round(((price * valueOf(comps)) *0.75* (priceRandomized / 100)) / 2);
        int januszprice= (int) Math.round((price * valueOf(comps))*0.75*(priceRandomizedextra/100));
        double priceOfWholeWork=(price * valueOf(comps)) *0.75* (priceRandomized / 100);
        int chanceOfSuccess = rand.nextInt(101);
        int chanceOfBroke = rand.nextInt(101);
        if (chanceOfSuccess >= steve.guarantee & player.finalCash - priceOfWholeWork > 0) {
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
}
