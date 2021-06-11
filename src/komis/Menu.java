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
                Player.player1.checkPlayerGarage();
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
            case "6":{
                System.out.println("exit");
                return false;
            }
            default:return false;
        }
        return true;
    }
    public void showCarBase(){
        System.out.println("To są samochody które możesz kupić:");
        Generate.viewCarBase();
        System.out.println("Menu:\n1. Pokaż menu\n2. Kup samochód");
        String inputshowcar=scanner.nextLine();
        switch (inputshowcar) {
            case "1" -> {
                showFirstPage();
            }
            case "2" -> {
                System.out.println("Wpisz numer samochodu, który chciałbyś kupić:");
                String inputbuycar = scanner.nextLine();
                Generate.buyCar(Generate.baseOfCars.get(Integer.parseInt(inputbuycar) - 1), Player.player1);
            }
        }
    }
}
