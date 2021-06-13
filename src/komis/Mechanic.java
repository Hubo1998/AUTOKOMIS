package komis;

public class Mechanic {
    public Integer price;
    public Integer guarantee;
    public Integer brokelse;

    public Mechanic(Integer price,Integer guarantee,Integer brokelse){
        this.price=price;
        this.guarantee=guarantee;
        this.brokelse=brokelse;
    }
    static Mechanic Janusz=new Mechanic(65,100,0);
    static Mechanic Marian=new Mechanic(45,90,0);
    static Mechanic Adrian=new Mechanic(35,80,2);
}
