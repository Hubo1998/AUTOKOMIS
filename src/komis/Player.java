package komis;

import java.util.ArrayList;

public class Player {
    public String firstName;
    public Double finalCash;
    public Double cash;
    public ArrayList<Car> playerGarage= new ArrayList<>();
    public ArrayList<String> history=new ArrayList<>();
    public int counter;

    public Player(String firstName,Double cash){
        this.firstName=firstName;
        this.finalCash = cash;
        this.counter=0;
        this.cash = cash;
    }

    public void checkPlayerGarage(){
        for(int i=0;i<playerGarage.size();i++){
            System.out.println(i+1+". "+playerGarage.get(i));
        }
    }
    public void checkCash(){
        System.out.println("Twój stan kontaa : "+Math.round(finalCash));
    }
}
