package komis;

import java.util.Scanner;

public class Menu {
    public Menu(){
    }
    public Scanner scanner=new Scanner(System.in);
    public boolean showFirstPage(){
        System.out.println("Menu:");
        System.out.println("1. Przeglądaj bazę samochodów do kupienia\n2. Przeglądaj bazę posiadanych samochodów\n3. Przejrzyj potencjalnych klientów\n4. Kup reklamę\n5. Sprawdź stan konta");
        String inputfirstpage=scanner.nextLine();
        switch(inputfirstpage){
            case "1": {
                showCarBase();
                break;
            }
            case "2": {
                checkGarageStatus(Player.player1);
                break;
            }
            case "3": {
                System.out.println("Baza potencjalnych klientów");
                break;
            }
            case "4": {
                System.out.println("Kup reklamę");
                break;
            }
            case "5": {
                System.out.println("Twój stan konta:" + Math.round(Player.player1.cash));
                break;
            }
            case "exit":{
                return false;
            }
            default:return true;
        }
        return true;
    }
    public void showCarBase(){
        System.out.println("To są samochody które możesz kupić:");
        Generate.viewCarBase();
        System.out.println("Menu:\n1. Pokaż menu\n2. Kup samochód");
        String inputshowcar=scanner.nextLine();
        switch (inputshowcar) {
            case "1" -> showFirstPage();
            case "2" -> {
                System.out.println("Wpisz numer samochodu, który chciałbyś kupić:");
                String inputbuycar = scanner.nextLine();
                Generate.buyCar(Generate.baseOfCars.get(Integer.parseInt(inputbuycar) - 1), Player.player1);
            }
        }
    }
    public void checkGarageStatus(Player player){
        System.out.println("To są Twoje samochody:");
        player.checkPlayerGarage();
        System.out.println("1. Menu\n2. Sprawdź stan auta\n3. Napraw auto\n4. Sprzedaj auto");
        String inputcheckgarage=scanner.nextLine();
        switch (inputcheckgarage){
            case "1"->showFirstPage();
            case "2"->{
                System.out.println("Wpisz numer samochodu,który chcesz sprawdzić");
                String inputcheckcar=scanner.nextLine();
                Generate.baseOfCars.get(Integer.parseInt(inputcheckcar)-1).carPartsStatus();
                System.out.println("W takim stanie jest Twoje auto");
            }
            case "3"->{
                System.out.println("Które auto chciałbyś naprawić? Wybierz numer auta.");
                String inputcartorepair=scanner.nextLine();
                Generate.baseOfCars.get(Integer.parseInt(inputcartorepair)-1).carPartsStatus();
                System.out.println("Który podzespół chciałbyś naprawić?");
                String inputparttorepair=scanner.nextLine();
                switch (inputparttorepair) {
                    case "1" -> Mechanicchoice(Components.Comps.brakes, Integer.parseInt(inputcartorepair));
                    case "2" -> Mechanicchoice(Components.Comps.suspension, Integer.parseInt(inputcartorepair));
                    case "3" -> Mechanicchoice(Components.Comps.engine, Integer.parseInt(inputcartorepair));
                    case "4" -> Mechanicchoice(Components.Comps.body, Integer.parseInt(inputcartorepair));
                    case "5" -> Mechanicchoice(Components.Comps.gearbox, Integer.parseInt(inputcartorepair));
                    default -> {
                        System.out.println("Coś nie teges");
                        showFirstPage();
                    }
                }
            }
        }
    }
    public void Mechanicchoice(Components.Comps comps,Integer cartorepair){
        System.out.println("U którego mechanika chciałbyś naprawić auto?");
        System.out.println(comps+" cena u Janusza (100% gwarancji, że się uda, 0% szans na zepsucie czegoś innego cena między "+Math.round(Generate.baseOfCars.get(cartorepair).price*Generate.baseOfCars.get(cartorepair).valueOf(comps)*Mechanic.Janusz.price*0.01)+" - "+Math.round(Generate.baseOfCars.get(cartorepair).price*Generate.baseOfCars.get(cartorepair).valueOf(comps)*(Mechanic.Janusz.price+10))*0.01);
        System.out.println(comps+" cena u Mariana (90% gwarancji, że się uda, 0% szans na zepsucie czegoś innego cena między "+Math.round(Generate.baseOfCars.get(cartorepair).price*Generate.baseOfCars.get(cartorepair).valueOf(comps)*Mechanic.Marian.price*0.01)+" - "+Math.round(Generate.baseOfCars.get(cartorepair).price*Generate.baseOfCars.get(cartorepair).valueOf(comps)*(Mechanic.Marian.price+10))*0.01);
        System.out.println(comps+" cena u Adriana (80% gwarancji, że się uda, 2% szans na zepsucie czegoś innego cena między "+Math.round(Generate.baseOfCars.get(cartorepair).price*Generate.baseOfCars.get(cartorepair).valueOf(comps)*Mechanic.Adrian.price*0.01)+" - "+Math.round(Generate.baseOfCars.get(cartorepair).price*Generate.baseOfCars.get(cartorepair).valueOf(comps)*(Mechanic.Adrian.price+10))*0.01);
        System.out.println("Przemyśl to dobrze, jak się nie uda, trzeba będzie jechać do Janusza");
        String inputmechanicchoice=scanner.nextLine();
        switch(inputmechanicchoice){
            case "1"->repairTime(Mechanic.Janusz,comps,Player.player1.playerGarage.get(cartorepair-1),Player.player1);
            case "2"->repairTime(Mechanic.Marian,comps,Player.player1.playerGarage.get(cartorepair-1),Player.player1);
            case "3"->repairTime(Mechanic.Adrian,comps,Player.player1.playerGarage.get(cartorepair-1),Player.player1);
            default -> {
                System.out.println("Coś nie teges");
                showFirstPage();
            }
        }
    }
    public void repairTime(Mechanic steve, Components.Comps comps,Car car,Player player){
        System.out.println("Naprawiłeś "+car.producer+" "+car.model);
        car.repair(comps,steve,player);
        car.carPartsStatus();
        System.out.println("Aktualny status podzespołów");
    }
}
