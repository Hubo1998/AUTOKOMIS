package komis;

import java.util.ArrayList;

public class Player {
    public String firstName;
    public String lastName;
    public Double finalCash;
    public Double cash;
    public ArrayList<Car> playerGarage= new ArrayList<>();
    public ArrayList<String> history=new ArrayList<>();
    public int counter;

    public Player(String firstName,String lastName,Double cash){
        this.firstName=firstName;
        this.lastName=lastName;
        this.finalCash = cash;
        this.counter=0;
        this.cash = cash;
    }
    static Player player1=new Player("Hubert","Marchwat",100000.0);

    public void checkPlayerGarage(){
        for(int i=0;i<playerGarage.size();i++){
            System.out.println(i+1+". "+playerGarage.get(i));
        }
    }
    public void checkCash(){
        System.out.println(Math.round(this.finalCash));
    }
}
