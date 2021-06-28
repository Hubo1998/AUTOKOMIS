package komis;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public Menu(){
    }
    Generate generate=new Generate();
    public Scanner scanner=new Scanner(System.in);
    public ArrayList<Player> baseOfPlayers=new ArrayList<>();
    public void createPlayers(int amount){
        System.out.println("Wprowadź kwotę pieniędzy dla wszystkich graczy na początek.");
        String cash=scanner.nextLine();
        for(int i=0;i<amount;i++){
            System.out.println("Imię gracza nr "+(i+1));
            String firstName=scanner.nextLine();
            baseOfPlayers.add(new Player(firstName,Double.valueOf(cash)));
        }
    }
    public boolean showFirstPage(Player player){
        if(player.finalCash >=player.cash*2){
            System.out.println("Udało Ci się podwoić majątek, brawo!");
            System.out.println("Zrobiłeś to w :"+player.counter+" ruchach.");
            return false;
        }else {
            System.out.println(player.firstName+", twój ruch\nMasz na koncie "+Math.round(player.finalCash));
            System.out.println("Menu główne:");
            System.out.println("1. Przeglądaj bazę samochodów do kupienia\n2. Przeglądaj bazę posiadanych samochodów\n3. Przejrzyj potencjalnych klientów\n4. Kup reklamę\n5. Sprawdź stan konta\n6. Pokaż historię transakcji");
            String inputfirstpage = scanner.nextLine();
            switch (inputfirstpage) {
                case "1": {
                    showCarBase(player);
                    break;
                }
                case "2": {
                    checkGarageStatus(player);
                    break;
                }
                case "3": {
                    generate.viewBaseOfClients();
                    break;
                }
                case "4": {
                    buyAdvertisement(player);
                    break;
                }
                case "5": {
                    player.checkCash();
                    break;
                }
                case "6":{
                    generate.showHistory(player);
                    break;
                }
                case "exit": {
                    return false;
                }
                default:
                    return true;
            }
        }
        return true;
    }
    public void showCarBase(Player player){
        System.out.println("To są samochody które możesz kupić:");
        generate.viewCarBase();
        System.out.println("Menu:\n1. Pokaż menu główne\n2. Kup samochód\n3. Sprawdź samochód");
        String inputshowcar=scanner.nextLine();
        switch (inputshowcar) {
            case "1" -> {}
            case "2" -> {
                System.out.println("Wpisz numer samochodu, który chciałbyś kupić:");
                String inputbuycar = scanner.nextLine();
                generate.buyCar(generate.baseOfCars.get(Integer.parseInt(inputbuycar) - 1), player);
            }
            case "3" -> {
                System.out.println("Wpisz numer samochodu, który chciałbyś sprawdzić:");
                String inputcheckcar = scanner.nextLine();
                System.out.println(generate.baseOfCars.get(Integer.parseInt(inputcheckcar)-1).producer+" "+generate.baseOfCars.get(Integer.parseInt(inputcheckcar)-1).model);
                generate.baseOfCars.get(Integer.parseInt(inputcheckcar)-1).carPartsStatus();
            }
        }
    }
    public void checkGarageStatus(Player player){
        if(player.playerGarage.isEmpty()){
            System.out.println("Nie masz samochodów w garażu");
        }else {
            System.out.println("To są Twoje samochody:");
            player.checkPlayerGarage();
            System.out.println("Menu:\n1. Pokaż menu główne\n2. Sprawdź stan auta\n3. Napraw auto\n4. Sprzedaj auto");
            String inputcheckgarage = scanner.nextLine();
            switch (inputcheckgarage) {
                case "1" -> showFirstPage(player);
                case "2" -> {
                    System.out.println("Wpisz numer samochodu,który chcesz sprawdzić");
                    String inputcheckcar = scanner.nextLine();
                    System.out.println(player.playerGarage.get(Integer.parseInt(inputcheckcar) - 1).producer + " " + player.playerGarage.get(Integer.parseInt(inputcheckcar) - 1).model);
                    player.playerGarage.get(Integer.parseInt(inputcheckcar) - 1).carPartsStatus();
                    System.out.println("W takim stanie jest Twoje auto");
                }
                case "3" -> {
                    System.out.println("Które auto chciałbyś naprawić? Wybierz numer auta.");
                    String inputcartorepair = scanner.nextLine();
                    System.out.println(player.playerGarage.get(Integer.parseInt(inputcartorepair) - 1).producer + " " + player.playerGarage.get(Integer.parseInt(inputcartorepair) - 1).model);
                    player.playerGarage.get(Integer.parseInt(inputcartorepair) - 1).carPartsStatus();
                    System.out.println("Który podzespół chciałbyś naprawić?");
                    String inputparttorepair = scanner.nextLine();
                    switch (inputparttorepair) {
                        case "1" -> Mechanicchoice(Components.Comps.brakes, Integer.parseInt(inputcartorepair) - 1, player);
                        case "2" -> Mechanicchoice(Components.Comps.suspension, Integer.parseInt(inputcartorepair) - 1, player);
                        case "3" -> Mechanicchoice(Components.Comps.engine, Integer.parseInt(inputcartorepair) - 1, player);
                        case "4" -> Mechanicchoice(Components.Comps.body, Integer.parseInt(inputcartorepair) - 1, player);
                        case "5" -> Mechanicchoice(Components.Comps.gearbox, Integer.parseInt(inputcartorepair) - 1, player);
                        default -> {
                            System.out.println("Coś nie teges");
                            showFirstPage(player);
                        }
                    }
                }
                case "4" -> {
                    System.out.println("Które auto chciałbyś sprzedać?");
                    String inputcartosell = scanner.nextLine();
                    System.out.println(player.playerGarage.get(Integer.parseInt(inputcartosell) - 1).producer + " " + player.playerGarage.get(Integer.parseInt(inputcartosell) - 1).model + " za " + Math.round(player.playerGarage.get(Integer.parseInt(inputcartosell) - 1).finalPrice));
                    System.out.println("Komu chciałbyś sprzedać auto?");
                    generate.viewBaseOfClients();
                    String inputclienttosell = scanner.nextLine();
                    generate.moodOfClient(Integer.parseInt(inputcartosell) - 1, player, generate.baseOfClients.get(Integer.parseInt(inputclienttosell) - 1));
                }
            }
        }
    }
    public void Mechanicchoice(Components.Comps comps,Integer cartorepair,Player player){
        if(player.playerGarage.get(cartorepair).isCompOk(comps)){
            System.out.println(player.playerGarage.get(cartorepair).nameOfComp(comps)+" są sprawne");
        }else{
            System.out.println("U którego mechanika chciałbyś naprawić auto?");
            System.out.println(player.playerGarage.get(cartorepair).nameOfComp(comps)+" cena u Janusza ("+Mechanic.Janusz.guarantee+"% gwarancji, że się uda, "+Mechanic.Janusz.brokelse+"% szans na zepsucie czegoś innego cena między "+Math.round(player.playerGarage.get(cartorepair).price*player.playerGarage.get(cartorepair).valueOf(comps)*Mechanic.Janusz.price*0.01)+" - "+Math.round(player.playerGarage.get(cartorepair).price*player.playerGarage.get(cartorepair).valueOf(comps)*(Mechanic.Janusz.price+10)*0.01));
            System.out.println(player.playerGarage.get(cartorepair).nameOfComp(comps)+" cena u Mariana ("+Mechanic.Marian.guarantee+"% gwarancji, że się uda, "+Mechanic.Marian.brokelse+"% szans na zepsucie czegoś innego cena między "+Math.round(player.playerGarage.get(cartorepair).price*player.playerGarage.get(cartorepair).valueOf(comps)*Mechanic.Marian.price*0.01)+" - "+Math.round(player.playerGarage.get(cartorepair).price*player.playerGarage.get(cartorepair).valueOf(comps)*(Mechanic.Marian.price+10)*0.01));
            System.out.println(player.playerGarage.get(cartorepair).nameOfComp(comps)+" cena u Adriana ("+Mechanic.Adrian.guarantee+"% gwarancji, że się uda, "+Mechanic.Adrian.brokelse+"% szans na zepsucie czegoś innego cena między "+Math.round(player.playerGarage.get(cartorepair).price*player.playerGarage.get(cartorepair).valueOf(comps)*Mechanic.Adrian.price*0.01)+" - "+Math.round(player.playerGarage.get(cartorepair).price*player.playerGarage.get(cartorepair).valueOf(comps)*(Mechanic.Adrian.price+10)*0.01));
            System.out.println("Przemyśl to dobrze, jak się nie uda, trzeba będzie jechać do Janusza");
            String inputmechanicchoice=scanner.nextLine();
            switch(inputmechanicchoice){
                case "1"->repairTime(Mechanic.Janusz,comps,player.playerGarage.get(cartorepair),player);
                case "2"->repairTime(Mechanic.Marian,comps,player.playerGarage.get(cartorepair),player);
                case "3"->repairTime(Mechanic.Adrian,comps,player.playerGarage.get(cartorepair),player);
                default -> {
                    System.out.println("Coś nie teges");
                    showFirstPage(player);
                }
            }
        }
    }
    public void repairTime(Mechanic steve, Components.Comps comps,Car car,Player player){
        System.out.println(car.producer+" "+car.model+" u Mechanika");
        car.repair(comps,steve,player);
        System.out.println(car.producer+" "+car.model);
        System.out.println("Aktualny status podzespołów");
        car.carPartsStatus();
    }
    public void buyAdvertisement(Player player){
        System.out.println("Wybierz reklamę którą chcesz kupić:\n1. Reklama w gazecie\n2. Reklama w internecie");
        String inputAdvertisementchoice=scanner.nextLine();
        Random rand=new Random();
        int counter=0;
        int newspaperprice=1000;
        int internetprice=250;
        switch(inputAdvertisementchoice){
            case "1"->{
                player.finalCash -=newspaperprice;
                for (int i=0;i<rand.nextInt(5);i++) {
                    generate.generateClient();
                    counter+=1;
                }
                System.out.println("Zapłaciłeś: "+newspaperprice+"\nPrzybyło "+counter+" nowych klientów");
                player.counter+=1;
            }
            case "2"->{
                player.finalCash -=internetprice;
                generate.generateClient();
                System.out.println("Zapłaciłeś: "+internetprice+"\nPrzybył jeden nowy klient");
                player.counter+=1;
            }
        }
    }
}
