package komis;

public abstract class Components {
    public boolean brakesAreOk;
    final static public Double DEFAULT_BRAKES_VALUE=0.1;
    public boolean suspensionIsOk;
    final static public Double DEFAULT_SUSPENSION_VALUE=0.2;
    public boolean engineIsOk;
    final static public Double DEFAULT_ENGINE_VALUE=1.0;
    public boolean bodyIsOk;
    final static public Double DEFAULT_BODY_VALUE=0.5;
    public boolean gearboxIsOk;
    final static public Double DEFAULT_GEARBOX_VALUE=0.5;
    final static public String[] LISTofComponents={"Hamulce","Zawieszenie","Silnik","Karoseria","Skrzynia biegów"};

    public Components(boolean brakesAreOk,boolean suspensionIsOk,boolean engineIsOk,boolean bodyIsOk,boolean gearboxIsOk) {
        this.brakesAreOk = brakesAreOk;
        this.suspensionIsOk = suspensionIsOk;
        this.engineIsOk = engineIsOk;
        this.bodyIsOk = bodyIsOk;
        this.gearboxIsOk = gearboxIsOk;
    }

    public abstract void repair(String part, Mechanic steve,Player player);
    public void breakSomething(Integer number){
        switch (number){
            case 0 -> brakesAreOk=false;
            case 1 -> suspensionIsOk=false;
            case 2 -> engineIsOk=false;
            case 3 -> bodyIsOk=false;
            case 4 -> gearboxIsOk=false;
            default -> System.out.println("Coś poszło nie tak");
        }
    }
}
