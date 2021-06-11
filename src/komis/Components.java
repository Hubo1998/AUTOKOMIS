package komis;

public class Components {
    public boolean brakesAreOk;
    public double brakesvalue;
    final static public Double DEFAULT_BRAKES_VALUE=0.1;
    public boolean suspensionIsOk;
    public double suspensionvalue;
    final static public Double DEFAULT_SUSPENSION_VALUE=0.2;
    public boolean engineIsOk;
    public double enginevalue;
    final static public Double DEFAULT_ENGINE_VALUE=1.0;
    public boolean bodyIsOk;
    public double bodyvalue;
    final static public Double DEFAULT_BODY_VALUE=0.5;
    public boolean gearboxIsOk;
    public double gearboxvalue;
    final static public Double DEFAULT_GEARBOX_VALUE=0.5;
    final static public String[] LISTofComponents={"Hamulce","Zawieszenie","Silnik","Karoseria","Skrzynia biegów"};

    public enum Comps {
        gearbox,brakes,engine,body,suspension
    }

    public Components(boolean brakesAreOk,boolean suspensionIsOk,boolean engineIsOk,boolean bodyIsOk,boolean gearboxIsOk) {
        this.brakesAreOk = brakesAreOk;
        this.suspensionIsOk = suspensionIsOk;
        this.engineIsOk = engineIsOk;
        this.bodyIsOk = bodyIsOk;
        this.gearboxIsOk = gearboxIsOk;
    }

    public double valueOf(Comps comps){
        if (comps==Comps.brakes){
            brakesvalue=DEFAULT_BRAKES_VALUE;
            return brakesvalue;
        }else if(comps==Comps.suspension){
            suspensionvalue=DEFAULT_SUSPENSION_VALUE;
            return suspensionvalue;
        }else if(comps==Comps.engine){
            enginevalue=DEFAULT_ENGINE_VALUE;
            return enginevalue;
        }else if(comps==Comps.body){
            bodyvalue=DEFAULT_BODY_VALUE;
            return bodyvalue;
        }else if(comps==Comps.gearbox){
            gearboxvalue=DEFAULT_GEARBOX_VALUE;
            return gearboxvalue;
        }else{
            return 1;
        }
    }
    public void setService(Comps comps){
        if (comps==Comps.brakes){
            this.brakesAreOk=true;
        }else if(comps==Comps.suspension){
            this.suspensionIsOk=true;
        }else if(comps==Comps.engine){
            this.engineIsOk=true;
        }else if(comps==Comps.body){
            this.bodyIsOk=true;
        }else if(comps==Comps.gearbox){
            this.gearboxIsOk=true;
        }
    }
    public boolean isCompOk(Comps comps){
        if (comps==Comps.brakes){
            return brakesAreOk;
        }else if(comps==Comps.suspension){
            return suspensionIsOk;
        }else if(comps==Comps.engine){
            return engineIsOk;
        }else if(comps==Comps.body){
            return bodyIsOk;
        }else if(comps==Comps.gearbox){
            return gearboxIsOk;
        }else{
            return false;
        }
    }

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
