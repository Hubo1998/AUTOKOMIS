package komis;

import komis.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    public String firstName;
    public Double finalCash;
    public Double cash;
    public ArrayList<Vehicle> playerGarage= new ArrayList<>();
    public ArrayList<String> history=new ArrayList<>();
    public ArrayList<Vehicle> baseOfCars= new ArrayList<>();
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
    public void buyCar(Vehicle vehicle){
        if(finalCash >(vehicle.price+vehicle.price*0.02)){
            for (int i=0;i<baseOfCars.size();i++){
                if(baseOfCars.get(i)==vehicle){
                    System.out.println("Kupiłeś "+baseOfCars.get(i).producer+" "+baseOfCars.get(i).model);
                    Vehicle carholder=baseOfCars.get(i);
                    removeCar(i);
                    playerGarage.add(carholder);
                    finalCash -=vehicle.price;
                    System.out.println("Podatek 2% od wartości:"+Math.round(vehicle.price*0.02));
                    finalCash -=vehicle.price*0.02;
                    counter+=1;
                }
            }
        }
    }
    public void sellCar(Integer indexofcar,Client client){
        int washprice=250;
        if(client.cash>playerGarage.get(indexofcar).finalPrice) {
            System.out.println("Sprzedałeś " + playerGarage.get(indexofcar).producer + " " + playerGarage.get(indexofcar).model + " za " + Math.round(playerGarage.get(indexofcar).finalPrice));
            finalCash += playerGarage.get(indexofcar).finalPrice;
            client.cash -= playerGarage.get(indexofcar).finalPrice;
            Vehicle carholder = playerGarage.get(indexofcar);
            System.out.println("Pojazd umyto, kwota: "+washprice);
            System.out.println("Podatek 2% od wartości wyniósł:"+Math.round(playerGarage.get(indexofcar).finalPrice*0.02));
            finalCash -=playerGarage.get(indexofcar).finalPrice*0.02;
            finalCash -=washprice;
            playerGarage.remove(playerGarage.get(indexofcar));
            client.clientgarage.add(carholder);
            generate.generateClient();
            generate.generateClient();
            counter=+1;
            history.add("Klient numer "+client.ID+" kupił samochód od "+firstName);
        }else{
            System.out.println("Twojego klienta nie stać na ten samochód, poszukaj innego.");
        }
    }
    public void sellInHarmonyWithMoodOfClient(Integer indexofcar, Client client){
        if(client.mood== Client.Mood.takeeverythingok){
            if(playerGarage.get(indexofcar).isCarOk()) sellCar(indexofcar, client);
            else System.out.println("Nie ta klientela");
        }else if (client.mood== Client.Mood.onlysuspension){
            if((playerGarage.get(indexofcar).isCarOk())||(!playerGarage.get(indexofcar).suspensionIsOk)) sellCar(indexofcar, client);
            else System.out.println("Ten klient nie kupi takiego samochodu");
        }else if(client.mood==Client.Mood.takeeverythingbroken) sellCar(indexofcar, client);
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
    public void buyAdvertisement(int choice){
        Random rand=new Random();
        int newspaperprice=1000;
        int internetprice=250;
        int counterOfClients=0;
        switch(choice){
            case 1->{
                finalCash -=newspaperprice;
                for (int i=0;i<rand.nextInt(5);i++) {
                    baseOfClients.add(generate.generateClient());
                    counterOfClients+=1;
                }
                System.out.println("Zapłaciłeś: "+newspaperprice+"\nPrzybyło "+counterOfClients+" nowych klientów");
                counter+=1;
            }
            case 2->{
                finalCash -=internetprice;
                baseOfClients.add(generate.generateClient());
                System.out.println("Zapłaciłeś: "+internetprice+"\nPrzybył jeden nowy klient");
                counter+=1;
            }
        }
    }
}
