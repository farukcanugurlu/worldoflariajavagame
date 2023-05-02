import java.util.Scanner;

public abstract class BattleLoc extends Location{
    Scanner scanner = new Scanner(System.in);
    protected Obstacle obstacle;
    protected String award;
    BattleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;
    }

    public boolean getLocation(){
        int obsCount = obstacle.count();
        System.out.println("Şuan "+this.getName()+" dasınız");
        System.out.println(obsCount+" adet "+obstacle.getName()+" ile karşılaştın");
        System.out.print("<S>avaş veya <K>aç");
        String selCase = scanner.nextLine();
        selCase = selCase.toUpperCase();
        if(selCase.equals("S")){
            if(combat(obsCount)== true){
                System.out.println(this.getName()+" bölgesinde ki tüm düşmanları temizlediniz! ");
                System.out.println("Sağlığınız "+player.getHealth());
                if(this.award.equals("Food")&&player.getInv().isFood() == false){
                    System.out.println("Yiyecek ele geçirildi");
                    player.getInv().setFood(true);
                }
                else if(this.award.equals("Firewood")&&player.getInv().isFirewood() == false){
                    System.out.println("Odun ele geçirildi");
                    player.getInv().setFirewood(true);
                }
                else if(this.award.equals("Water")&&player.getInv().isWater() == false){
                    System.out.println("Su ele geçirildi");
                    player.getInv().setWater(true);
                }
                else if(this.award.equals("Money")){
                    player.setMoney(player.getMoney()+100);
                }
                return true;
            }
            if(player.getHealth()<=0){
                System.out.println("Öldünüz!!");
                return false;
            }
        }
        return true;
    }
    public boolean combat(int obsCount){
        for(int i =0; i < obsCount; i++){
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while(player.getHealth()>0 && obstacle.getHealth()>0){
                System.out.print("<S>aldır veya <K>aç \n");
                String selCase = scanner.nextLine();
                selCase = selCase.toUpperCase();
                if(selCase.equals("S")){
                    System.out.println("Silahını yaratığa indirdin!!");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDemage());
                    afterHit();
                    if(obstacle.getHealth()>0){
                        System.out.println("Yaratık size vurdu!!");
                        player.setHealth(player.getHealth()-(obstacle.getDemage()-player.getInv().getArmor()));
                        afterHit();
                    }
                }
                else{
                    return false;
                }
            }
            if(obstacle.getHealth()<=0 && player.getHealth()>0){
                System.out.println("Yaratık Yok Edildi!!");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Bölgeyi yağmaladınız kazanılan sikke: "+obstacle.getAward());
                System.out.println("Sahip olduğunuz toplam sikke: "+player.getMoney());
                obstacle.setHealth(defObsHealth);
            }
            else{
                return false;
            }
            System.out.println("-----------------");
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Sağlığınız: "+player.getHealth());
        System.out.println(obstacle.getName()+" Sağlığı:"+obstacle.getHealth());
        System.out.println(" ");
    }



    public void playerStats(){
        System.out.println("\nOyuncu Değerleri \n---------");
        System.out.println("Sağlık "+player.getHealth());
        System.out.println("Hasar "+player.getTotalDemage());
        if(player.getInv().getDemage()>0){
            System.out.println(player.getInv().getWeaponName()+" ile yaratığa saldırılıyor!!");

        }
    }

    public void enemyStats(){
        System.out.println("\n"+obstacle.getName()+" değerleri\n----------");
        System.out.println("Sağlık "+obstacle.getHealth());
        System.out.println("Hasar "+obstacle.getDemage());
        System.out.println("Ödül" +obstacle.getAward());
    }
}
