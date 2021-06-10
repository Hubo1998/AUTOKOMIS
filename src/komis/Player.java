package komis;

public class Player {
    public String firstName;
    public String lastName;
    public Double cash;

    public Player(String firstName,String lastName,Double cash){
        this.firstName=firstName;
        this.lastName=lastName;
        this.cash=cash;
    }
    static Player player1=new Player("Hubert","Marchwat",1000.0);
}
