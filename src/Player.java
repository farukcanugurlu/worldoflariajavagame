import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {
    private int demage,health,money,rhealth,stoned;

    public int getStoned() {
        return stoned;
    }

    public void setStoned(int stoned) {
        this.stoned = stoned;
    }

    private String name,cName;
    Inventory inv;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectCha(){
        switch (charMenu()){
            case 1:
                initPlayer("Piyade",5,21,15);
                break;
            case 2:
                initPlayer("Okçu",7,18,20);
                break;
            case 3:
                initPlayer("Şovalye",8,24,5);
                break;
            default:
                initPlayer("Piyade",5,21,15);
                break;
        }
        System.out.println("Karakter:"+getcName()+" Hasar:"+getDemage()+" Sağlık:"+getHealth()+" Sikke:"+getMoney());
    }

    public int getTotalDemage(){
        return this.demage+this.getInv().getDemage()+this.getInv().getHorseDemage()+(this.getStoned()/2);
    }

    public int charMenu(){
        System.out.println("Lütfen karakter seçiniz.");
        System.out.println("1-Piyade \tHasar:5,\tSağlık:21,\tSikke:15");
        System.out.println("2-Okçu   \tHasar:7,\tSağlık:18,\tSikke:20");
        System.out.println("3-Şovalye \tHasar:8,\tSağlık:24,\tSikke:5");
        int charID = scan.nextInt();

        while(charID < 1 || charID >3){
            System.out.println("Geçerli bir id giriniz");
            charID = scan.nextInt();
        }

        return charID;
    }

    public void initPlayer(String cName,int dmg,int hlth,int mny){
        setcName(cName);
        setDemage(dmg);
        setHealth(hlth);
        setMoney(mny);
        setRhealth(hlth);
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getRhealth() {
        return rhealth;
    }

    public void setRhealth(int rhealth) {
        this.rhealth = rhealth;
    }
}
