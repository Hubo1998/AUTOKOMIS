package komis;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	Car car1=new Car("Subaru","Impreza",1998,Segment.Premium,999.0,true,true,true,false,false);
	System.out.println(car1.brakesAreOk);
	System.out.println(car1.suspensionIsOk);
	System.out.println(car1.bodyIsOk);
	System.out.println(car1.price);
	car1.repair("body",Mechanic.Janusz,Player.player1);
	System.out.println(car1.price);
	System.out.println(car1.finalPrice);
	car1.repair("suspension",Mechanic.Marian,Player.player1);
		Random rand=new Random();
		int x =rand.nextInt(10)+Mechanic.Janusz.price;
		System.out.println(x);
	System.out.println(Player.player1.cash);
	String[] arr=new String[5];
	for (int i=0;i<5;i++){
		arr[i]='"'+String.valueOf(i)+'"';
		System.out.println(arr[i]);
	}
	//System.out.println(Generate.generateVehicle());
	//System.out.println(Generate.models[Generate.genModel(10)]);
	Generate.genModel(4);
	Car car122=Generate.generateVehicle();
	System.out.println(car122.yearOfProduction+car122.model+car122.producer);
	car122.repair("brakes",Mechanic.Janusz,Player.player1);
	System.out.println(car122.price);
	System.out.println(car122.yearOfProduction);
	Generate.createCarBase();
	System.out.println(Generate.baseOfCars);
	Generate.viewCarBase();
	System.out.println(Generate.baseOfCars.get(1).model);
    }
}
