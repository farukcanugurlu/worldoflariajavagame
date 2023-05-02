import java.util.Scanner;

public class Hospital extends NormalLocation{
    Hospital(Player player) {
        super(player,"Revir");
    }

    public boolean getLocation() {

        System.out.println("Şuan revirdesiniz");
        System.out.println("İyileşmek istiyorsanız <S> Ücret <8> ");
        Scanner scan = new Scanner(System.in);
        String iyi = scan.nextLine();
        iyi = iyi.toUpperCase();
        if(iyi.equals("S")) {
            if (player.getMoney() > 8) {
                player.setHealth(player.getHealth() + player.getRhealth() / 4);
                player.setMoney(getPlayer().getMoney() - 8);
                System.out.println("Yaralarınızı sardınız artık daha iyi hissediyorsunuz...");
                if (player.getHealth() > player.getRhealth()) {
                    player.setHealth(player.getRhealth());
                }
                System.out.println("Yeni sağlık " + player.getHealth());
            }
            else{
                System.out.println("Sikkeniz yetersiz!! ");
            }
        }
        return true;

    }
}
