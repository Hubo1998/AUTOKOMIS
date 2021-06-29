package komis;


public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        System.out.println("Wprowadź ilość graczy");
        String inputamount = menu.scanner.nextLine();
        menu.startGame(Integer.parseInt(inputamount));
        boolean breaker = true;
        while (breaker) {
            for (int i = 0; i < menu.baseOfPlayers.size(); i++) {
                int countercounter = menu.baseOfPlayers.get(i).counter;
                while (countercounter == menu.baseOfPlayers.get(i).counter) {
                    if (!menu.showFirstPage(menu.baseOfPlayers.get(i))) {
                        breaker = false;
                        break;
                    }
                }
                if (!breaker){
                    break;
                }
            }
        }
    }
}
