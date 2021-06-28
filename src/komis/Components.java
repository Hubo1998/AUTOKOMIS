package komis;

import java.util.Random;

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
        gearbox,brakes,engine,body,suspension,NA
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
    public void setService(Comps comps,Boolean choice){
        if (comps==Comps.brakes){
            this.brakesAreOk=choice;
        }else if(comps==Comps.suspension){
            this.suspensionIsOk=choice;
        }else if(comps==Comps.engine){
            this.engineIsOk=choice;
        }else if(comps==Comps.body){
            this.bodyIsOk=choice;
        }else if(comps==Comps.gearbox){
            this.gearboxIsOk=choice;
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
    public void breaked(Comps comps){
        System.out.println("Zepsuto: "+nameOfComp(comps));
    }
    public void breakSomething(){
        Comps randomComp=rollComp();
        if(!brakesAreOk&!suspensionIsOk&!engineIsOk&!bodyIsOk&!gearboxIsOk) {
            System.out.println("Już nie ma co psuć :/");
        }else if(isCompOk(randomComp)) {
            setService(randomComp,false);
            breaked(randomComp);
        }else{
            breakSomething();
        }
    }
    public String nameOfComp(Comps comps){
        if (comps==Comps.brakes) return "Hamulce";
        else if(comps==Comps.suspension) return "Zawieszenie";
        else if(comps==Comps.engine) return "Silnik";
        else if(comps==Comps.body) return "Karoseria";
        else if(comps==Comps.gearbox) return "Skrzynia biegów";
        else return "Coś nie tak";
    }
    public Comps rollComp(){
        Random rand=new Random();
        int x=rand.nextInt(5);
        switch (x){
            case 0 -> { return Comps.brakes; }
            case 1 -> { return Comps.suspension; }
            case 2 -> { return Comps.engine; }
            case 3 -> { return Comps.body; }
            case 4 -> { return Comps.gearbox; }
            default -> { return Comps.NA; }
        }
    }
}
