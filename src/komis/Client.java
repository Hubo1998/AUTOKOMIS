package komis;

import java.util.ArrayList;

public class Client {
    public int cash;
    public Mood mood;
    public int ID;
    public ArrayList<Car> clientgarage=new ArrayList<>();
    public enum Mood{
        takeeverythingbroken,onlysuspension,takeeverythingok
    }
    public Client(int cash,Mood mood,int ID){
        this.cash=cash;
        this.mood=mood;
        this.ID=ID;
    }
    @Override
    public String toString(){
        if (mood==Mood.takeeverythingbroken){
            return "Klient o aktualnym budżecie " +Math.round(cash)+" i zgodzi się na każde uszkodzenia.";
        } else if(mood==Mood.onlysuspension){
            return "Klient o aktualnym budżecie " +Math.round(cash)+" i zgodzi się tylko na uszkodzenia zawieszenia.";
        } else if(mood==Mood.takeeverythingok){
            return "Klient o aktualnym budżecie " +Math.round(cash)+" i nie zgodzi się na żadne uszkodzenia.";
        }else return "N/A";
    }
}
