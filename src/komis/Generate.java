package komis;

import java.util.ArrayList;
import java.util.Random;

public class Generate {
    public static final String[] producers={"Volkswagen","Audi","Bentley","Lamborghini","Skoda","Seat","Porsche","Toyota","Lexus","Jaguar","Land Rover","Tata","Mitsubishi","Nissan","Renault","Dacia","Hyundai","Kia","Honda","Volvo","Ford","Mercedes","SMART","BMW","MINI","Rolls Royce","Chrysler","Dodge","JEEP","Abarth","Alfa Romeo","FIAT","Maserati","Citroen","DS","Peugeot","Opel","Vauxhal","Aston Martin","Mazda","Subaru","Mclaren","Tesla","Daewoo","Acura","Lotus","Bugatti"};
    public static final String[] models={"Tiguan","Amarok","Arteon","Caddy","Caravelle","Crafter","Golf","Passat","Sharan","T-Cross","T-Roc","Tiguan","Touran","Transporter","up!","Bora","Corrado","Fox","Jetta","Lupo","Vento","Scirocco","Phaeton","Eos","A1","A2","A3","A4","A5","A6","A7","A8","E-tron","Q2","Q3","Q7","Q5","Q8","R8","100","200","80","90","TT","Bentayga","Brooklands","Continental","Mulsanne","Arnage","Azure","Aventador","Huracan","Urus","Veneno","Diablo","Gallardo","Miura","Murcielago","Fabia","Kamiq","Karoq","Kodiaq","Octavia","Scala","Superb","100","Felicia","Rapid","Yeti","Roomster","Favorit","Alhambra","Arona","Ateca","Ibiza","Tarraco","Altea","Arosa","Cordoba","Exeo","Inca","Malaga","Mii","Toledo","911","Boxster","Cayenne","Cayman","Macan","Panamera","Taycan","968","959","Carrera GT","914","928","924","Aygo","C-HR","Camry","Corolla","GT86","Highlander","Hilux","Land Cruiser","Prius","Proace","RAV4","Sienna","Supra","Yaris","Avensis","Auris","Avalon","Carina","Celica","Corolla Verso","Hiace","Paseo","Verso","Tundra","CT","ES","IS","LC","LS","LX","NX","RC","RX","RX L","UX","GS","GX","HS","S.C.","E-Pace","F-Pace","F-Type","I-Pace","XE","XF","XJ","E-Type","S-Type","X-Type","XJ8","XJR","XJS","XK","XK8","XKR","Defender","Discovery","Discovery Sport","Range Rover","Range Rover Evoque","Range Rover Sport","Range Rover Velar","Freelander","Indigo","Nano","Safari","Indica","Xenon","ASX","Eclipse Cross","L200","Outlander","Space Star","Carisma","Colt","Diamante","Eclipse","Fto","Galant","Grandis","L300","l400","Lancer","Mirage","Montero","Santamo","Space Gear","Space Runner","Sigma","Space Wagon","370Z","GT-R","Juke","Leaf","Micra","Navara","NV200","Qashqai","X-Trail","200SX","Almera","Altima","Cherry","Cube","Interstar","Maxima","Murano","Note","NP300","Pathfinder","Patrol","Pick Up","Pixo","Primera","Pulsar","Sentra","Skyline","Terrano","Tiida","Titan","Trade","Urvan","Xterra","Captur","Clio","Espace","Kadjar","Kangoo","Koleos","Master","Megane","Talisman","Trafic","ZOE","Fluence","Laguna","Modus","Safrane","Latitude","Scenic","Thalia","Twingo","Twizy","Vel Satis","Wind","Dokker","Duster","Lodgy","Logan","Sandero","i10","i20","i30","ix20","Kona","Santa Fe","Tucson","Accent","Excel","Galloper","Genesis","Getz","Grand Santa Fe","Grandeur","i40","ix35","ix55","Matrix","Pony","Santamo","Scoupe","Sonata","Starex","Stellar","Terracan","Tiburon","Trajet","Veloster","Ceed","Niro","Picanto","Proceed","Rio","Sorento","Soul","Sportage","Stinger","Stonic","Xceed","Carens","Cerato","Clarus","Joice","Magentis","Optima","Pregio","Pride","Retona","Sedona","Venga","Civic","CR-V","e","HR-V","Jazz","NSX","Accord","City","CR-Z","Element","Integra","Legend","Logo","Odyssey","Pilot","Prelude","Ridgeline","S2000","Stream","Vamos","S60","S90","V60","V90","XC40","XC60","XC90","240","340","440","460","480","740","745","760","780","850","940","960","C30","C70","S40","S70","S80","V40","V50","V70","XC70","Ecosport","Edge","Escape","Explorer","Fiesta","Flex","Focus","Galaxy","Ka Plus","Kuga","Mondeo","Mustang","Puma","Ranger","S-Max","Tourneo","Transit","B-Max","C-Max","Cougar","Courier","Escort","Express","Falcon","Festiva","Freestar","Fusion","GT","Ka","Maverick","Orion","Probe","Scorpio","Sierra","Taunus","Taurus","Tempo","Thunderbird","Transit","Windstar","AMG GT","Citan","CLA","CLS","EQC","EQV","GLA","GLB","GLC","GLE","GLS","Klasa A","Klasa B","Klasa C","Klasa E","Klasa G","Klasa S","Klasa V","Klasa X","Maybach","SL","SLC","Sprinter","Vito","CL","190","CLC","CLK","GLK","Klasa GL","Klasa M","Klasa R","SLK","SLS","Viano","W111","W123","W124","Forfour","Fortwo","Roadster","i3","i8","Seria 1","Seria 2","Seria 3","Seria 4","Seria 5","Seria 6","Seria 7","Seria 8","X1","X2","X3","X4","X5","X6","X7","Z4","Z3","Z8","Z1","Cabrio","Clubman","Countryman","Mini","Coupe","One","Paceman","Roadster","Ghost","Phantom","Wraith","Corniche","Silver Seraph","Pacifica","Aspen","Cirrus","Concorde","Crossfire","Daytona","Neon","Laser","Saratoga","Stratus","Sebring","Voyager","Vision","Avenger","Caravan","Challenger","Charger","Durango","Journey","Nitro","Ram","B 250","Caliber","Daytona","Dynasty","Interpid","Magnum","Neon","Shadow","Spirit","Stealth","Stratus","Viper","Cherokee","Compass","Grand Cherokee","Renegade","Wrangler","Commander","Liberty","Patriot","Wagoneer","500","124 Spider","Grande Punto","Punto","Punto Evo","Giulia","Stelvio","Giulietta Nuova","145","146","147","155","156","159","164","166","2000","33","4C","75","8C Competizione","Brera","GT","GTV","MiTo","Spider","Sprint","500","500L","500X","Ducato","Panda","Tipo","125","125p","126p","127","128","130","133","Albea","Bertone X1/9","Brava","Bravo","Cinquecento","Coupe","Croma","Doblo","Fiorino","Freemont","Fullback","Idea","Linea","Marea","Multipla","Palio","Punto","Qubo","Regata","Scudo","Sedici","Seicento","Siena","Stilo","Strada","Talento","Tempra","Ulysse","Uno","Ghibli","Gran Cabrio","GranTurismo","Levante","Quatroporte","Biturbo","Coupe","Gransport","MC12","Spyder","Berlingo","C-Elysee","C1","C3","C3 Aircross","C4","C4 Cactus","C4 Spacetourer","C5 Aircross","Jumper","Spacetourer","C2","C3 Picasso","C4 Aircross","C5","C6","C8","CX","DS.","Evasion","Jumpy","Nemo","Saxo","Xantia","Xsara Picasso","Xsara","3","3 Crossback","7","4","5","2008","208","3008","308","5008","508","Boxer","Expert","Partner","Rifter","Traveller","107","108","204","205","206","207","301","306","307","405","406","407","607","807","Bipper","RCZ","Astra","Combo","Corsa","Crossland/Crossland X","Grandland X","Insignia","Mokka","Movano","Vivaro","Zafira","Adam","Agila","Ampera","Antara","Ascona","Calibra","Antra","Campo","Cascada","Commodore","Frontera","GT","Kadett","Karl","Manta","Meriva","Monterey","Monza","Omega","Rekord","Senator","Signum","Sintra","Speedster","Tigra","Vectra","Rapide","V12 Vantage","V8 Vantage","Cygnet","DB5","DB7","DB9","DBS","V12 Vanquish","2","3","6","CX-3","CX-30","CX-5","CX-8","MX-30","MX-5","323","5","626","CX-7","CX-9","MPV","MX-3","MX-6","Premacy","Protege","RX-7","RX-8","Tribute","Xedos","Forester","Impreza","Outback","XV","BRZ","Justy","Baja","Legacy","Levorg","M70","SVX","Trezia","Tribeca","Vivio","WRX STI","XT","Cabrio","Coupe","Model 3","Model S","Model X","Espero","Evanda","Kalos","Lanos","Leganza","Lublin","Matiz","Musso","Nexia","Nubira","Rezzo","Tacuma","Tico","MDX","TL","TSX","CL","CSX","EL","Interga","NSX","RDX","RL","RSX","SLX","Vigor","Elise","Europa","Evora","Exige S","Esprit","Chiron","Veyron 16.4","EB 118","EB 218"};
    public ArrayList<Car> baseOfCars= new ArrayList<>();
    public ArrayList<Client> baseOfClients=new ArrayList<>();
    public final static Integer DEFAULT_YEAR_STARER=1990;

    public void createCarBase(){
        for (int i=0;i<20;i++){
            baseOfCars.add(generateVehicle());
        }
    }
    public void viewCarBase(){
        for(int i=0;i<baseOfCars.size();i++){
            System.out.println(i+1+". "+baseOfCars.get(i));
        }
    }

    public Car generateVehicle(){
        Random rand=new Random();
        int x=genProducer();
        //nie wymyśliłem sposobu na generowanie roku, w zależności od modelu i marki, myślę, że już chyba nie ma co przesadzać. Po prostu losuje liczbę od 1990 do 2020 roku.
        int yearOfProduction=rand.nextInt(30)+DEFAULT_YEAR_STARER;
        boolean brakes=trueorFalse();
        boolean suspension=trueorFalse();
        boolean engine=trueorFalse();
        boolean body=trueorFalse();
        boolean gearbox=trueorFalse();
        Car.Segment segment=genSegment(x);
        double value=genPrice(segment,yearOfProduction,brakes,suspension,engine,body,gearbox);
        return new Car(producers[x],models[genModel(x)],yearOfProduction,segment,value,new Components(brakes,suspension,engine,body,gearbox));
    }

    public boolean trueorFalse(){
        //80% szans, że podzespół będzie sprawny.
        Random rand=new Random();
        int x=rand.nextInt(101);
        return x < 80;
    }
    public Integer genProducer(){
        Random rand=new Random();
        return rand.nextInt(47);
    }
    public Integer genModel(Integer random) {
        //Miałem bazę danych z pojazdami i ich modelami, wszystko skopiowałem i modele są odpowiednio przypisane do marek samochodów. Pewnie mało to profesjonalne no ale nic nie poradzę, jest jak jest ;)
        Random rand = new Random();
        int y;
        switch (random) {
            case 0 -> y = rand.nextInt(24);
            case 1 -> y = rand.nextInt(20) + 24;
            case 2 -> y = rand.nextInt(6) + 44;
            case 3 -> y = rand.nextInt(8) + 50;
            case 4 -> y = rand.nextInt(13) + 58;
            case 5 -> y = rand.nextInt(13) + 71;
            case 6 -> y = rand.nextInt(13) + 84;
            case 7 -> y = rand.nextInt(24) + 97;
            case 8 -> y = rand.nextInt(15) + 121;
            case 9 -> y = rand.nextInt(16) + 136;
            case 10 -> y = rand.nextInt(8) + 152;
            case 11 -> y = rand.nextInt(5) + 160;
            case 12 -> y = rand.nextInt(22) + 165;
            case 13 -> y = rand.nextInt(33) + 187;
            case 14 -> y = rand.nextInt(22) + 220;
            case 15 -> y = rand.nextInt(5) + 242;
            case 16 -> y = rand.nextInt(28) + 247;
            case 17 -> y = rand.nextInt(22) + 275;
            case 18 -> y = rand.nextInt(20) + 297;
            case 19 -> y = rand.nextInt(28) + 317;
            case 20 -> y = rand.nextInt(40) + 345;
            case 21 -> y = rand.nextInt(38) + 385;
            case 22 -> y = rand.nextInt(3) + 423;
            case 23 -> y = rand.nextInt(21) + 426;
            case 24 -> y = rand.nextInt(8) + 447;
            case 25 -> y = rand.nextInt(5) + 455;
            case 26 -> y = rand.nextInt(13) + 460;
            case 27 -> y = rand.nextInt(20) + 473;
            case 28 -> y = rand.nextInt(9) + 493;
            case 29 -> y = rand.nextInt(5) + 502;
            case 30 -> y = rand.nextInt(22) + 507;
            case 31 -> y = rand.nextInt(42) + 529;
            case 32 -> y = rand.nextInt(10) + 571;
            case 33 -> y = rand.nextInt(26) + 581;
            case 34 -> y = rand.nextInt(5) + 607;
            case 35 -> y = rand.nextInt(27) + 612;
            case 36 -> y = rand.nextInt(36) + 639;
            case 37 -> y = rand.nextInt(36) + 639;
            case 38 -> y = rand.nextInt(9) + 675;
            case 39 -> y = rand.nextInt(23) + 684;
            case 40 -> y = rand.nextInt(16) + 707;
            case 41 -> y = rand.nextInt(2) + 723;
            case 42 -> y = rand.nextInt(3) + 725;
            case 43 -> y = rand.nextInt(13) + 728;
            case 44 -> y = rand.nextInt(13) + 741;
            case 45 -> y = rand.nextInt(5) + 754;
            case 46 -> y = rand.nextInt(4) + 759;
            default -> y = 0;
        }
        //System.out.println(y);
        return y;
    }
    public Car.Segment genSegment(Integer random){
        switch (random) {
            case 0, 7, 10, 12, 13, 14, 16, 18, 19, 20, 22, 24, 26, 28, 30, 33, 35, 36, 37, 39, 40 -> {
                return Car.Segment.Standard;
            }
            case 1, 2, 3, 6, 8, 9, 21, 23, 25, 27, 29, 32, 34, 38, 41, 42, 44, 45, 46 -> {
                return Car.Segment.Premium;
            }
            case 4, 5, 11, 15, 17, 31, 43 -> {
                return Car.Segment.Budget;
            }
            default -> {
                return Car.Segment.NA;
            }
        }
    }
    public Double genPrice(Car.Segment segment, Integer yearOfprod, boolean brakes, boolean suspension, boolean engine, boolean body, boolean gearbox ){
        Random rand=new Random();
        double price=5000.0;
        int multiplier=yearOfprod-DEFAULT_YEAR_STARER+1;
        double finalPrice;
        double costs=0.0;
        if (segment== Car.Segment.Premium){
            //z racji segmentu premium mnożnik między 1.85-2.15
            double randomizer=rand.nextInt(30)+185;
            price*=(randomizer/100)*multiplier;
        } else if (segment== Car.Segment.Standard){
            //z racji segmentu standard mnożnik między 0.9-1.1
            double randomizer=rand.nextInt(20)+90;
            price*=(randomizer/100)*multiplier;
        } else if (segment== Car.Segment.Budget){
            //z racji segmentu standard mnożnik między 0.5-0.65
            double randomizer=rand.nextInt(15)+50;
            price*=(randomizer/100)*multiplier;
        }
        //jeśli coś jest zepsute, zmniejsza się wartość maksymalnie o 1/3 wartości podzespołu.
        if (!brakes){
            double brakesrandomizer=rand.nextInt(20)+13;
            costs+=(brakesrandomizer/1000)*price;
        }
        if(!suspension){
            double suspensionrandomizer=rand.nextInt(50)+16;
            costs+=(suspensionrandomizer/1000)*price;
        }
        if(!engine){
            double enginerandomizer=rand.nextInt(277)+56;
            costs+=(enginerandomizer/1000)*price;
        }
        if(!body){
            double bodyrandomizer=rand.nextInt(130)+37;
            costs+=(bodyrandomizer/1000)*price;
        }
        if(!gearbox){
            double gearboxrandomizer=rand.nextInt(130)+37;
            costs+=(gearboxrandomizer/1000)*price;
        }
        finalPrice=price-costs;
        return finalPrice;
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
    public void removeCar(int indexOfCar){
        baseOfCars.remove(indexOfCar);
        baseOfCars.add(generateVehicle());
    }

    public void createBaseOfClients(){
        for (int i=0;i<5;i++){
            generateClient();
        }
    }
    public void viewBaseOfClients(){
        for(int i=0;i<baseOfClients.size();i++){
            System.out.println(i+1+". "+baseOfClients.get(i));
        }
    }

    public void generateClient(){
        baseOfClients.add(new Client(genCash(),genMood()));
    }

    public Double genCash(){
        Random rand=new Random();
        return (double) rand.nextInt((baseOfClients.size() + 1) * 10000);
    }

    public Client.Mood genMood(){
        Random rand=new Random();
        int x=rand.nextInt(100);
        if(x>90){
            return Client.Mood.takeeverythingbroken;
        }else if(x>70){
            return Client.Mood.onlysuspension;
        }else {
            return Client.Mood.takeeverythingok;
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
            player.playerGarage.remove(indexofcar);
            client.clientgarage.add(carholder);
            player.counter=+1;
        }else{
            System.out.println("Twojego klienta nie stać na ten samochód, poszukaj innego.");
        }
    }
    public void moodOfClient(Integer indexofcar,Player player, Client client){
        if(client.mood== Client.Mood.takeeverythingok){
            if(player.playerGarage.get(indexofcar).isCarOk()) sellCar(indexofcar, player, client);
            else System.out.println("Nie ta klientela");
        }else if (client.mood== Client.Mood.onlysuspension){
            if((player.playerGarage.get(indexofcar).isCarOk())||(!player.playerGarage.get(indexofcar).suspensionIsOk)) sellCar(indexofcar, player, client);
            else System.out.println("Ten klient nie kupi takiego samochodu");
        }else if(client.mood==Client.Mood.takeeverythingbroken) sellCar(indexofcar, player, client);
            else System.out.println("Coś poszło nie tak");
    }
}
