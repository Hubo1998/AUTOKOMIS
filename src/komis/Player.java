package komis;

import java.util.ArrayList;

public class Player {
    public String firstName;
    public Double finalCash;
    public Double cash;
    public ArrayList<Car> playerGarage= new ArrayList<>();
    public ArrayList<String> history=new ArrayList<>();
    public ArrayList<Car> baseOfCars= new ArrayList<>();
    public ArrayList<Client> baseOfClients=new ArrayList<>();
    public int counter;

    Generate generate = new Generate();

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
    public void createCarBase(){
        for (int i=0;i<20;i++){
            baseOfCars.add(generate.generateVehicle());
        }
    }
    public void viewCarBase(){
        for(int i=0;i<baseOfCars.size();i++){
            System.out.println(i+1+". "+baseOfCars.get(i));
        }
    }
    public void buyCar(Car car,Player player){
        if(player.finalCash >car.price){
            for (int i=0;i<baseOfCars.size();i++){
                if(baseOfCars.get(i)==car){
                    System.out.println("Kupiłeś "+baseOfCars.get(i).producer+" "+baseOfCars.get(i).model);
                    Car carholder=baseOfCars.get(i);
                    removeCar(i);
                    player.playerGarage.add(carholder);
                    player.finalCash -=car.price;
                    System.out.println("Podatek 2% od wartości:"+Math.round(car.price*0.02));
                    player.finalCash -=car.price*0.02;
                    player.counter+=1;
                }
            }
        }
    }
    public void sellCar(Integer indexofcar,Player player,Client client){
        int washprice=250;
        if(client.cash>player.playerGarage.get(indexofcar).finalPrice) {
            System.out.println("Sprzedałeś " + player.playerGarage.get(indexofcar).producer + " " + player.playerGarage.get(indexofcar).model + " za " + Math.round(player.playerGarage.get(indexofcar).finalPrice));
            player.finalCash += player.playerGarage.get(indexofcar).finalPrice;
            client.cash -= player.playerGarage.get(indexofcar).finalPrice;
            Car carholder = player.playerGarage.get(indexofcar);
            System.out.println("Pojazd umyto, kwota: "+washprice);
            System.out.println("Podatek 2% od wartości wyniósł:"+Math.round(player.playerGarage.get(indexofcar).finalPrice*0.02));
            player.finalCash -=player.playerGarage.get(indexofcar).finalPrice*0.02;
            player.finalCash -=washprice;
            player.playerGarage.remove(player.playerGarage.get(indexofcar));
            client.clientgarage.add(carholder);
            generate.generateClient();
            generate.generateClient();
            player.counter=+1;
            player.history.add("Klient numer "+client.ID+" kupił samochód od "+player.firstName);
        }else{
            System.out.println("Twojego klienta nie stać na ten samochód, poszukaj innego.");
        }
    }
    public void sellInHarmonyWithMoodOfClient(Integer indexofcar,Player player, Client client){
        if(client.mood== Client.Mood.takeeverythingok){
            if(player.playerGarage.get(indexofcar).isCarOk()) sellCar(indexofcar, player, client);
            else System.out.println("Nie ta klientela");
        }else if (client.mood== Client.Mood.onlysuspension){
            if((player.playerGarage.get(indexofcar).isCarOk())||(!player.playerGarage.get(indexofcar).suspensionIsOk)) sellCar(indexofcar, player, client);
            else System.out.println("Ten klient nie kupi takiego samochodu");
        }else if(client.mood==Client.Mood.takeeverythingbroken) sellCar(indexofcar, player, client);
        else System.out.println("Coś poszło nie tak");
    }
    public void removeCar(int indexOfCar){
        baseOfCars.remove(indexOfCar);
        baseOfCars.add(generate.generateVehicle());
    }

    public void createBaseOfClients(){
        for (int i=0;i<5;i++){
            baseOfClients.add(generate.generateClient());
        }
    }
    public void viewBaseOfClients(){
        System.out.println("Baza potencjalnych klientów:");
        for(int i=0;i<baseOfClients.size();i++){
            System.out.println(i+1+". "+baseOfClients.get(i));
        }
    }
    public void showHistory(){
        if (history.isEmpty()){
            System.out.println("Nie było do tej pory żadnych transakcji");
        }else {
            for(int i=0;i<history.size();i++){
                System.out.println("Transakcja numer "+(i+1)+". "+history.get(i));
            }
        }
    }
}
