package komis;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    public Menu(){
    }
    Generate generate=new Generate();
    public Scanner scanner=new Scanner(System.in);
    public boolean showFirstPage(){
        if(Player.player1.finalCash >=Player.player1.cash*2){
            System.out.println("Udało Ci się podwoić majątek, brawo!");
            System.out.println("Zrobiłeś to w :"+Player.player1.counter+" ruchach.");
            return false;
        }else {
            System.out.println("Twój stan konta: "+Math.round(Player.player1.finalCash));
            System.out.println("Menu:");
            System.out.println("1. Przeglądaj bazę samochodów do kupienia\n2. Przeglądaj bazę posiadanych samochodów\n3. Przejrzyj potencjalnych klientów\n4. Kup reklamę\n5. Sprawdź stan konta\n6. Pokaż historię transakcji");
            String inputfirstpage = scanner.nextLine();
            switch (inputfirstpage) {
                case "1": {
                    showCarBase();
                    break;
                }
                case "2": {
                    checkGarageStatus(Player.player1);
                    break;
                }
                case "3": {
                    System.out.println("Baza potencjalnych klientów:");
                    generate.viewBaseOfClients();
                    break;
                }
                case "4": {
                    buyAdvertisement(Player.player1);
                    break;
                }
                case "5": {
                    System.out.println("Twój stan konta:" + Math.round(Player.player1.finalCash));
                    break;
                }
                case "6":{
                    generate.showHistory(Player.player1);
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
    public void createCarBase(){
        generate.createCarBase();
    }
    public void showCarBase(){
        System.out.println("To są samochody które możesz kupić:");
        generate.viewCarBase();
        System.out.println("Menu:\n1. Pokaż menu\n2. Kup samochód\n3. Sprawdź samochód");
        String inputshowcar=scanner.nextLine();
        switch (inputshowcar) {
            case "1" -> "".isEmpty();
            case "2" -> {
                System.out.println("Wpisz numer samochodu, który chciałbyś kupić:");
                String inputbuycar = scanner.nextLine();
                generate.buyCar(generate.baseOfCars.get(Integer.parseInt(inputbuycar) - 1), Player.player1);
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
        System.out.println("To są Twoje samochody:");
        player.checkPlayerGarage();
        System.out.println("Menu:\n1. Menu\n2. Sprawdź stan auta\n3. Napraw auto\n4. Sprzedaj auto");
        String inputcheckgarage=scanner.nextLine();
        switch (inputcheckgarage){
            case "1"->showFirstPage();
            case "2"->{
                System.out.println("Wpisz numer samochodu,który chcesz sprawdzić");
                String inputcheckcar=scanner.nextLine();
                System.out.println(player.playerGarage.get(Integer.parseInt(inputcheckcar)-1).producer+" "+player.playerGarage.get(Integer.parseInt(inputcheckcar)-1).model);
                player.playerGarage.get(Integer.parseInt(inputcheckcar)-1).carPartsStatus();
                System.out.println("W takim stanie jest Twoje auto");
            }
            case "3"->{
                System.out.println("Które auto chciałbyś naprawić? Wybierz numer auta.");
                String inputcartorepair=scanner.nextLine();
                System.out.println(player.playerGarage.get(Integer.parseInt(inputcartorepair)-1).producer+" "+player.playerGarage.get(Integer.parseInt(inputcartorepair)-1).model);
                player.playerGarage.get(Integer.parseInt(inputcartorepair)-1).carPartsStatus();
                System.out.println("Który podzespół chciałbyś naprawić?");
                String inputparttorepair=scanner.nextLine();
                switch (inputparttorepair) {
                    case "1" -> Mechanicchoice(Components.Comps.brakes, Integer.parseInt(inputcartorepair)-1);
                    case "2" -> Mechanicchoice(Components.Comps.suspension, Integer.parseInt(inputcartorepair)-1);
                    case "3" -> Mechanicchoice(Components.Comps.engine, Integer.parseInt(inputcartorepair)-1);
                    case "4" -> Mechanicchoice(Components.Comps.body, Integer.parseInt(inputcartorepair)-1);
                    case "5" -> Mechanicchoice(Components.Comps.gearbox, Integer.parseInt(inputcartorepair)-1);
                    default -> {
                        System.out.println("Coś nie teges");
                        showFirstPage();
                    }
                }
            }
            case "4"->{
                System.out.println("Które auto chciałbyś sprzedać?");
                String inputcartosell=scanner.nextLine();
                System.out.println(player.playerGarage.get(Integer.parseInt(inputcartosell)-1).producer+" "+player.playerGarage.get(Integer.parseInt(inputcartosell)-1).model+" za "+player.playerGarage.get(Integer.parseInt(inputcartosell)-1).finalPrice);
                System.out.println("Komu chciałbyś sprzedać auto?");
                generate.viewBaseOfClients();
                String inputclienttosell=scanner.nextLine();
                generate.moodOfClient(Integer.parseInt(inputcartosell)-1,Player.player1,generate.baseOfClients.get(Integer.parseInt(inputclienttosell)-1));
            }
        }
    }
    public void Mechanicchoice(Components.Comps comps,Integer cartorepair){
        System.out.println("U którego mechanika chciałbyś naprawić auto?");
        System.out.println(Player.player1.playerGarage.get(cartorepair).nameOfComp(comps)+" cena u Janusza (100% gwarancji, że się uda, 0% szans na zepsucie czegoś innego cena między "+Math.round(Player.player1.playerGarage.get(cartorepair).price*Player.player1.playerGarage.get(cartorepair).valueOf(comps)*Mechanic.Janusz.price*0.01)+" - "+Math.round(Player.player1.playerGarage.get(cartorepair).price*Player.player1.playerGarage.get(cartorepair).valueOf(comps)*(Mechanic.Janusz.price+10)*0.01));
        System.out.println(Player.player1.playerGarage.get(cartorepair).nameOfComp(comps)+" cena u Mariana (90% gwarancji, że się uda, 0% szans na zepsucie czegoś innego cena między "+Math.round(Player.player1.playerGarage.get(cartorepair).price*Player.player1.playerGarage.get(cartorepair).valueOf(comps)*Mechanic.Marian.price*0.01)+" - "+Math.round(Player.player1.playerGarage.get(cartorepair).price*Player.player1.playerGarage.get(cartorepair).valueOf(comps)*(Mechanic.Marian.price+10)*0.01));
        System.out.println(Player.player1.playerGarage.get(cartorepair).nameOfComp(comps)+" cena u Adriana (80% gwarancji, że się uda, 2% szans na zepsucie czegoś innego cena między "+Math.round(Player.player1.playerGarage.get(cartorepair).price*Player.player1.playerGarage.get(cartorepair).valueOf(comps)*Mechanic.Adrian.price*0.01)+" - "+Math.round(Player.player1.playerGarage.get(cartorepair).price*Player.player1.playerGarage.get(cartorepair).valueOf(comps)*(Mechanic.Adrian.price+10)*0.01));
        System.out.println("Przemyśl to dobrze, jak się nie uda, trzeba będzie jechać do Janusza");
        String inputmechanicchoice=scanner.nextLine();
        switch(inputmechanicchoice){
            case "1"->repairTime(Mechanic.Janusz,comps,Player.player1.playerGarage.get(cartorepair),Player.player1);
            case "2"->repairTime(Mechanic.Marian,comps,Player.player1.playerGarage.get(cartorepair),Player.player1);
            case "3"->repairTime(Mechanic.Adrian,comps,Player.player1.playerGarage.get(cartorepair),Player.player1);
            default -> {
                System.out.println("Coś nie teges");
                showFirstPage();
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
