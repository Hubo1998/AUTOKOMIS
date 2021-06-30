package komis;

import komis.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Random;

public class Client {
    public int cash;
    public Mood mood;
    public int ID;
    public ArrayList<Vehicle> clientgarage=new ArrayList<>();
    public ArrayList<String> interests=new ArrayList<>();
    public enum Mood{
        takeeverythingbroken,onlysuspension,takeeverythingok
    }
    public Client(int cash,Mood mood,int ID){
        this.cash=cash;
        this.mood=mood;
        this.ID=ID;
        rollProducer();
    }
    @Override
    public String toString(){
        if (mood==Mood.takeeverythingbroken){
            return "Klient o aktualnym budżecie " +Math.round(cash)+" i zgodzi się na każde uszkodzenia.    | Marki którymi jest zainteresowany to: "+interests.get(0)+" i "+interests.get(1);
        } else if(mood==Mood.onlysuspension){
            return "Klient o aktualnym budżecie " +Math.round(cash)+" i zgodzi się tylko na uszkodzenia zawieszenia.    | Marki którymi jest zainteresowany to: "+interests.get(0)+" i "+interests.get(1);
        } else if(mood==Mood.takeeverythingok){
            return "Klient o aktualnym budżecie " +Math.round(cash)+" i nie zgodzi się na żadne uszkodzenia.    | Marki którymi jest zainteresowany to: "+interests.get(0)+" i "+interests.get(1);
        }else return "N/A";
    }
    public void rollProducer(){
        Random rand=new Random();
        int x=rand.nextInt(47);
        int y=rand.nextInt(47);
        while(x==y){
            y=rand.nextInt(47);
        }
        interests.add(Generate.producers[x]);
        interests.add(Generate.producers[y]);
    }
}
