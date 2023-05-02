public class Inventory {
    private boolean water,food,firewood;
    private String weaponName,armorName;
    private int demage,armor,horseDemage;

    public int getHorseDemage() {
        return horseDemage;
    }

    public void setHorseDemage(int horseDemage) {
        this.horseDemage = horseDemage;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Inventory() {
        this.water=false;
        this.food=false;
        this.firewood=false;
        this.demage=0;
        this.armor=0;
        this.weaponName=null;
        this.armorName=null;
    }
}
