package komis;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	Car car1=new Car("Subaru","Impreza",1998,"Premium",999.0,true,true,true,false,false);
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
    }
}
