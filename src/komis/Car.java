package komis;

import java.util.Random;

public class Car extends Components {
    public Double price;
    public Double finalPrice;
    final public String model;
    final public String producer;
    final public Integer yearOfProduction;
    final public String carSegment;
    Random rand = new Random();

    public Car(String producer, String model, Integer yearOfProduction, String carSegment, Double price, boolean brakesAreOk, boolean suspensionIsOk, boolean engineIsOk, boolean bodyIsOk, boolean gearboxIsOk) {
        super(brakesAreOk, suspensionIsOk, engineIsOk, bodyIsOk, gearboxIsOk);
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.carSegment = carSegment;
        this.price = price;
        this.finalPrice = price;
    }

    @Override
    public void repair(String part, Mechanic steve, Player player) {
        double priceRandomized = rand.nextInt(11) + steve.price;
        double priceRandomizedextra = rand.nextInt(11) + Mechanic.Janusz.price;
        int chanceOfSuccess = rand.nextInt(100) + 1;
        int chanceOfBroke = rand.nextInt(100) + 1;
        int thingBroken = rand.nextInt(5);
        switch (part) {
            case "brakes" -> {
                if (brakesAreOk) {
                    System.out.println("Hamulce są sprawne");
                } else if (chanceOfSuccess >= steve.guarantee) {
                    //w zadaniu nie jest opisane, czy przy niepowodzeniu naprawy ma być pobierana opłata,
                    //założyłem, że będzie pobierana połowa kwoty naprawy, która by się zakończyła powodzeniem.
                    System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki a dodatkowo Januszowi");
                    player.cash -= ((price * DEFAULT_BRAKES_VALUE) * (priceRandomized / 100)) / 2;
                    player.cash -= (price * DEFAULT_BRAKES_VALUE) * (priceRandomizedextra / 100);
                    if (chanceOfBroke <= steve.brokelse) {
                        System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                        breakSomething(thingBroken);
                        System.out.println("Zepsuto:" + LISTofComponents[thingBroken]);
                    }
                } else if (player.cash - (price * DEFAULT_BRAKES_VALUE) * (priceRandomized / 100) > 0) {
                    player.cash -= (price * DEFAULT_BRAKES_VALUE) * (priceRandomized / 100);
                    finalPrice = finalPrice + (price * DEFAULT_BRAKES_VALUE) * (priceRandomized / 100);
                    brakesAreOk = true;
                    System.out.println("Hamulce naprawione, cena za usługę:" + (price * DEFAULT_BRAKES_VALUE) * (priceRandomized / 100));
                }else{
                    System.out.println("Nie stać Cię");
                }
            }
            case "suspension" -> {
                if (suspensionIsOk) {
                    System.out.println("Zawieszenie jest sprawne");
                } else if (chanceOfSuccess >= steve.guarantee) {
                    System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki a dodatkowo Januszowi");
                    player.cash -= ((price * DEFAULT_SUSPENSION_VALUE) * (priceRandomized / 100)) / 2;
                    player.cash -= (price * DEFAULT_SUSPENSION_VALUE) * (priceRandomizedextra / 100);
                    if (chanceOfBroke <= steve.brokelse) {
                        System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                        breakSomething(thingBroken);
                        System.out.println("Zepsuto:" + LISTofComponents[thingBroken]);
                    }
                } else if (player.cash - (price * DEFAULT_SUSPENSION_VALUE) * (priceRandomized / 100) > 0) {
                    player.cash -= (price * DEFAULT_SUSPENSION_VALUE) * (priceRandomized / 100);
                    finalPrice = finalPrice + (price * DEFAULT_SUSPENSION_VALUE) * (priceRandomized / 100);
                    suspensionIsOk = true;
                    System.out.println("Zawieszenie naprawione, cena za usługę:" + (price * DEFAULT_SUSPENSION_VALUE) * (priceRandomized / 100));
                }else{
                    System.out.println("Nie stać Cię");
                }
            }
            case "engine" -> {
                if (engineIsOk) {
                    System.out.println("Silnik jest sprawny");
                } else if (chanceOfSuccess >= steve.guarantee) {
                    System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki a dodatkowo Januszowi");
                    player.cash -= ((price * DEFAULT_ENGINE_VALUE) * (priceRandomized / 100)) / 2;
                    player.cash -= (price * DEFAULT_ENGINE_VALUE) * (priceRandomizedextra / 100);
                    if (chanceOfBroke <= steve.brokelse) {
                        System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                        breakSomething(thingBroken);
                        System.out.println("Zepsuto:" + LISTofComponents[thingBroken]);
                    }
                } else if (player.cash - (price * DEFAULT_ENGINE_VALUE) * (priceRandomized / 100) > 0) {
                    player.cash -= (price * DEFAULT_ENGINE_VALUE) * (priceRandomized / 100);
                    finalPrice = finalPrice + (price * DEFAULT_ENGINE_VALUE) * (priceRandomized / 100);
                    engineIsOk = true;
                    System.out.println("Silnik naprawiont, cena za usługę:" + (price * DEFAULT_ENGINE_VALUE) * (priceRandomized / 100));
                }else{
                    System.out.println("Nie stać Cię");
                }
            }
            case "body" -> {
                if (bodyIsOk) {
                    System.out.println("Karoseria jest cała okej");
                } else if (chanceOfSuccess >= steve.guarantee) {
                    System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki a dodatkowo Januszowi");
                    player.cash -= ((price * DEFAULT_BODY_VALUE) * (priceRandomized / 100)) / 2;
                    player.cash -= (price * DEFAULT_BODY_VALUE) * (priceRandomizedextra / 100);
                    if (chanceOfBroke <= steve.brokelse) {
                        System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                        breakSomething(thingBroken);
                        System.out.println("Zepsuto:" + LISTofComponents[thingBroken]);
                    }
                } else if (player.cash - (price * DEFAULT_BODY_VALUE) * (priceRandomized / 100) > 0) {
                    player.cash -= (price * DEFAULT_BODY_VALUE) * (priceRandomized / 100);
                    finalPrice = finalPrice + (price * DEFAULT_BODY_VALUE) * (priceRandomized / 100);
                    bodyIsOk = true;
                    System.out.println("Karoseria naprawiona, cena za usługę:" + (price * DEFAULT_BODY_VALUE) * (priceRandomized / 100));
                }else{
                    System.out.println("Nie stać Cię");
                }
            }
            case "gearbox" -> {
                if (gearboxIsOk) {
                    System.out.println("Skrzynia biegów jest sprawna");
                } else if (chanceOfSuccess >= steve.guarantee) {
                    System.out.println("Niestety Twój mechanik nie podołał, jedynym ratunkiem jest Janusz\njednemu musisz zapłacić połowę stawki a dodatkowo Januszowi");
                    player.cash -= ((price * DEFAULT_GEARBOX_VALUE) * (priceRandomized / 100)) / 2;
                    player.cash -= (price * DEFAULT_GEARBOX_VALUE) * (priceRandomizedextra / 100);
                    if (chanceOfBroke <= steve.brokelse) {
                        System.out.println("Jakby tego było mało, Twój mechanik zepsuł coś jeszcze, trzeba będzie to naprawić :S");
                        breakSomething(thingBroken);
                        System.out.println("Zepsuto:" + LISTofComponents[thingBroken]);
                    }
                } else if (player.cash - (price * DEFAULT_GEARBOX_VALUE) * (priceRandomized / 100) > 0) {
                    player.cash -= (price * DEFAULT_GEARBOX_VALUE) * (priceRandomized / 100);
                    finalPrice = finalPrice + (price * DEFAULT_GEARBOX_VALUE) * (priceRandomized / 100);
                    gearboxIsOk = true;
                    System.out.println("Skrzynia biegów naprawiona, cena za usługę:" + (price * DEFAULT_GEARBOX_VALUE) * (priceRandomized / 100));
                }else{
                    System.out.println("Nie stać Cię");
                }
            }
            default -> System.out.println("Brak podanego komponentu");
        }
    }
}

