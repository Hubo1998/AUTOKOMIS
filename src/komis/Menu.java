package komis;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public Menu(){
    }
    public Scanner scanner=new Scanner(System.in);
    public ArrayList<Player> baseOfPlayers=new ArrayList<>();
    public void startGame(int amount){
        //szybkie startery do testów.
        if (amount==22){
            baseOfPlayers.add(new Player("firstPlayer",100000.0));
            baseOfPlayers.get(0).createCarBase();
            baseOfPlayers.get(0).createBaseOfClients();
            baseOfPlayers.add(new Player("secondPlayer",100000.0));
            baseOfPlayers.get(1).createCarBase();
            baseOfPlayers.get(1).createBaseOfClients();
        } else if(amount==33){
            baseOfPlayers.add(new Player("firstPlayer",100000.0));
            baseOfPlayers.get(0).createCarBase();
            baseOfPlayers.get(0).createBaseOfClients();
            baseOfPlayers.add(new Player("secondPlayer",100000.0));
            baseOfPlayers.get(1).createCarBase();
            baseOfPlayers.get(1).createBaseOfClients();
            baseOfPlayers.add(new Player("thirdPlayer",100000.0));
            baseOfPlayers.get(2).createCarBase();
            baseOfPlayers.get(2).createBaseOfClients();
        }else{
            System.out.println("Wprowadź kwotę pieniędzy dla wszystkich graczy na początek.");
            String cash=scanner.nextLine();
            for(int i=0;i<amount;i++){
                System.out.println("Imię gracza nr "+(i+1));
                String firstName=scanner.nextLine();
                baseOfPlayers.add(new Player(firstName,Double.valueOf(cash)));
                baseOfPlayers.get(i).createCarBase();
                baseOfPlayers.get(i).createBaseOfClients();
            }
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
                    player.viewBaseOfClients();
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
                    player.showHistory();
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
        player.viewCarBase();
        System.out.println("Menu:\n1. Pokaż menu główne\n2. Kup samochód\n3. Sprawdź samochód");
        String inputshowcar=scanner.nextLine();
        switch (inputshowcar) {
            case "2" -> {
                System.out.println("Wpisz numer samochodu, który chciałbyś kupić:");
                try {
                    int inputbuycar = inputWithMinusOne();
                    player.buyCar(player.baseOfCars.get(inputbuycar));
                }catch (NumberFormatException exception){
                    System.out.println("Musisz wpisać numer samochodu");
                }catch (IndexOutOfBoundsException exception){
                    System.out.println("Samochód spoza zakresu");
                }
            }
            case "3" -> {
                System.out.println("Wpisz numer samochodu, który chciałbyś sprawdzić:");
                int inputcheckcar = inputWithMinusOne();
                System.out.println(player.baseOfCars.get(inputcheckcar).producer+" "+player.baseOfCars.get(inputcheckcar).model);
                player.baseOfCars.get(inputcheckcar).carPartsStatus();
            }
            default -> {}
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
                case "2" -> {
                    System.out.println("Wpisz numer samochodu,który chcesz sprawdzić");
                    int inputcheckcar = inputWithMinusOne();
                    System.out.println(player.playerGarage.get(inputcheckcar).producer + " " + player.playerGarage.get(inputcheckcar).model);
                    player.playerGarage.get(inputcheckcar).carPartsStatus();
                    System.out.println("W takim stanie jest Twoje auto");
                }
                case "3" -> {
                    System.out.println("Które auto chciałbyś naprawić? Wybierz numer auta.");
                    int inputcartorepair= inputWithMinusOne();
                    System.out.println(player.playerGarage.get(inputcartorepair).producer + " " + player.playerGarage.get(inputcartorepair).model);
                    player.playerGarage.get(inputcartorepair).carPartsStatus();
                    System.out.println("Który podzespół chciałbyś naprawić?");
                    String inputparttorepair = scanner.nextLine();
                    switch (inputparttorepair) {
                        case "1" -> Mechanicchoice(Components.Comps.brakes, inputcartorepair, player);
                        case "2" -> Mechanicchoice(Components.Comps.suspension, inputcartorepair, player);
                        case "3" -> Mechanicchoice(Components.Comps.engine, inputcartorepair, player);
                        case "4" -> Mechanicchoice(Components.Comps.body, inputcartorepair, player);
                        case "5" -> Mechanicchoice(Components.Comps.gearbox, inputcartorepair, player);
                        default -> System.out.println("Coś nie teges");
                    }
                }
                case "4" -> {
                    System.out.println("Które auto chciałbyś sprzedać?");
                    int inputcartosell = inputWithMinusOne();
                    System.out.println(player.playerGarage.get(inputcartosell).producer + " " + player.playerGarage.get(inputcartosell).model + " za " + Math.round(player.playerGarage.get(inputcartosell).finalPrice));
                    System.out.println("Komu chciałbyś sprzedać auto?");
                    player.viewBaseOfClients();
                    int inputclienttosell = inputWithMinusOne();
                    player.sellInHarmonyWithMoodOfClient(inputcartosell, player.baseOfClients.get(inputclienttosell));
                }
                default -> {}
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
                default -> System.out.println("Coś nie teges");
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
        player.buyAdvertisement(Integer.parseInt(inputAdvertisementchoice));
    }
    public int inputWithMinusOne(){
        int input;
        input = Integer.parseInt(scanner.nextLine())-1;
        return input;
    }
}
