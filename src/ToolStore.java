import java.util.Scanner;

public class ToolStore extends NormalLocation {
    Scanner scanner = new Scanner(System.in);

    ToolStore(Player player) {
        super(player, "Dükkan");
    }

    @Override
    public boolean getLocation() {
            System.out.println("Sikkeniz: " + player.getMoney());
            System.out.println("1.Silahlar");
            System.out.println("2.Zırhlar");
            System.out.println("3.Atlar");
            System.out.println("4.Yiyecek");
            System.out.println("5.İçki");
            System.out.println("6.Çıkış");
            System.out.print("Seçiminiz?");
            int set = scanner.nextInt();
            int selItemId;

            switch (set) {
                case 1:
                    selItemId = weaponMenu();
                    buyWeapon(selItemId);
                    break;
                case 2:
                    selItemId = armorMenu();
                    buyArmor(selItemId);
                    break;
                case 3:
                    selItemId = horseMenu();
                    buyHorse(selItemId);
                    break;
                case 4:
                    selItemId = foodMenu();
                    buyFood(selItemId);
                    break;
                case 5:
                    selItemId = drinkMenu();
                    buyDrink(selItemId);
                    break;

                default:

                    break;
            }

            return true;
        }

    public int weaponMenu() {
        System.out.println("1.Kısa Kılıç <Para: 20 - Hasar: 2>");
        System.out.println("2.Uzun Kılıç <Para: 40 - Hasar: 7>");
        System.out.println("3.Balta <Para: 25 - Hasar: 3>");
        System.out.println("4.Çıkış");
        System.out.println("Silah seçiniz ");

        int selWep = scanner.nextInt();
        return selWep;

    }

    public int armorMenu() {
        System.out.println("1.Hafif Zırh <Para: 10 - Koruma: 1>");
        System.out.println("2.Orta Zırh <Para: 15 - Koruma: 2>");
        System.out.println("3.Ağır Zırh <Para: 35 - Koruma: 5>");
        System.out.println("4.Çıkış");
        System.out.println("Zırh Seçiniz ");

        int selArm = scanner.nextInt();
        return selArm;

    }

    public int horseMenu() {
        System.out.println("1.Binek Atı <Para: 30 - Hasar: 1>");
        System.out.println("2.Hafif Zırhlı At <Para: 40 - Hasar: 2>");
        System.out.println("3.Ağır Zırhlı At <Para: 50 - Hasar: 3>");
        System.out.println("4.Çıkış");
        System.out.println("At Seçiniz ");

        int selArm = scanner.nextInt();
        return selArm;

    }

    public int foodMenu() {
        System.out.println("1.Elma <Para: 10 - İyileştirme: 4>");
        System.out.println("2 Pişmiş Tavuk <Para: 15 - İyileştirme 12>");
        System.out.println("3.Kurutulmuş Et <Para: 24 - İyileştirme: 18>");
        System.out.println("4.Çıkış");
        System.out.println("Yiyecek seçiniz ");

        int selFood = scanner.nextInt();
        return selFood;

    }

    public int drinkMenu() {
        System.out.println("1.Bira <Para: 8 - Azalan Sağlık:1> <Artan Mutluluk(Sarhoşluk):1>");
        System.out.println("2.Şarap <Para: 25 - Azalan Sağlık:2> <Artan Mutluluk(Sarhoşluk):5>");
        System.out.println("3.Vodka <Para: 15 - Azalan Sağlık:3> <Artan Mutluluk(Sarhoşluk):4>");
        System.out.println("4.Çıkış");
        System.out.println("İçki Seçiniz ");

        int selDrink = scanner.nextInt();
        return selDrink;

    }

    public void buyDrink(int itemID) {
        int health = 0, fun = 0,money=0;
        String drkName = null;
        switch (itemID) {
            case 1:
                health = 1;
                drkName = "Bira";
                fun = 2;
                money = 8;
                break;
            case 2:
                health = 2;
                drkName = "Şarap";
                fun = 6;
                money = 25;
            case 3:
                health = 3;
                drkName = "Vodka";
                fun = 4;
                money = 15;
                break;
            case 4:
                System.out.println("Dükkandan çıktın");
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }

        if (money > 0) {
            if (player.getMoney() >= money) {
                player.setHealth(player.getHealth()-health);
                player.setMoney(player.getMoney() - money);
                player.setStoned(fun);
                System.out.println(drkName + " İçtiniz sarhoşluk arttı!!");
                System.out.println("Yeni sağlığınız " + player.getHealth()+" Sarhoşluk seviyeniz: "+player.getStoned() + " Kalan sikkeniz: " + player.getMoney());
            } else {
                System.out.println("Sikken yetersiz!");
            }
        }
    }

    public void buyArmor(int itemID) {
        int koruma = 0, money = 0;
        String armName = null;
        switch (itemID) {
            case 1:
                koruma = 1;
                armName = "Hafif Zırh";
                money = 10;
                break;
            case 2:
                koruma = 2;
                armName = "Orta Zırh";
                money = 15;
                break;
            case 3:
                koruma = 5;
                armName = "Ağır Zırh";
                money = 35;
                break;
            case 4:
                System.out.println("Dükkandan çıktın");
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }

        if (money > 0) {
            if (player.getMoney() >= money) {
                player.getInv().setArmor(koruma);
                player.getInv().setArmorName(armName);
                player.setMoney(player.getMoney() - money);
                System.out.println(armName + " Adlı Zırhı başarıyla satın aldınız");
                System.out.println("Yeni zırhınız: " + player.getInv().getArmor() + " Kalan sikkeniz: " + player.getMoney());
            } else {
                System.out.println("Sikken yetersiz!");
            }
        }
    }

    public void buyWeapon(int itemID) {
        int demage = 0, money = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                demage = 2;
                wName = "Kısa Kılıç";
                money = 20;
                break;
            case 2:
                demage = 7;
                wName = "Uzun Kılıç";
                money = 40;
                break;
            case 3:
                demage = 3;
                wName = "Balta";
                money = 25;
                break;
            case 4:
                System.out.println("Dükkandan çıktın");
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }
        if (money > 0) {
            if (player.getMoney() >= money) {
                player.getInv().setDemage(demage);
                player.getInv().setWeaponName(wName);
                player.setMoney(player.getMoney() - money);
                System.out.println(wName + " Adlı Silahı başarıyla satın aldınız");
                System.out.println("Yeni hasarınız: " + player.getTotalDemage() + " Kalan sikkeniz: " + player.getMoney());
            } else {
                System.out.println("Sikken yetersiz!");
            }
        }
    }

    public void buyHorse(int itemID) {
        int demage = 0, money = 0;
        String hName = null;
        switch (itemID) {
            case 1:
                demage = 1;
                hName = "Binek Atı";
                money = 30;
                break;
            case 2:
                demage = 2;
                hName = "Hafif Zırhlı At";
                money = 40;
                break;
            case 3:
                demage = 4;
                hName = "Ağır Zırhlı At";
                money = 80;
                break;
            case 4:
                System.out.println("Dükkandan çıktın");
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }
        if (money > 0) {
            if (player.getMoney() >= money) {
                player.getInv().setHorseDemage(demage);
                player.setMoney(player.getMoney() - money);
                System.out.println(hName + " Atı başarıyla satın aldınız");
                System.out.println("Yeni hasarınız: " + player.getTotalDemage() + " Kalan sikkeniz: " + player.getMoney());
            } else {
                System.out.println("Sikken yetersiz!");
            }
        }
    }

    public void buyFood(int itemID) {
        int heal = 0, money = 0;
        System.out.println("Sağlığınız: "+player.getHealth());
        String fName = null;
        switch (itemID) {
            case 1:
                heal = 4;
                fName = "Elma";
                money = 10;
                break;
            case 2:
                heal = 12;
                fName = "Pişmiş Tavuk";
                money = 15;
                break;
            case 3:
                heal = 18;
                fName = "Kurutulmuş Et";
                money = 24;
                break;
            case 4:
                System.out.println("Dükkandan çıktın");
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }
        if (money > 0) {
            if (player.getMoney() >= money) {
                player.setHealth(player.getHealth() + heal);
                if(player.getHealth()> player.getRhealth()){
                    player.setHealth(player.getRhealth());
                }
                player.setMoney(player.getMoney() - money);
                System.out.println(fName + " yiyeceğini başarıyla satın aldınız");
                System.out.println("Yeni sağlığınız: " + player.getHealth() + " Kalan sikkeniz: " + player.getMoney());
                }
            else {
                System.out.println("Sikken yetersiz!");
            }
        }


    }

}
