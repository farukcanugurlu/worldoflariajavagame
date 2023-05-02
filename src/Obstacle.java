import java.util.Random;

public class Obstacle {
    private String name;
    private int demage,award,health,maxNumber;

    public Obstacle(String name, int demage,int health,int award, int maxNumber) {
        this.name = name;
        this.demage = demage;
        this.health = health;
        this.award = award;
        this.maxNumber = maxNumber;
    }

    public int  count(){
        Random r = new Random();
        return r.nextInt(this.maxNumber)+1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
