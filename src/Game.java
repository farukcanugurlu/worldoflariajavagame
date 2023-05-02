import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);

    public void login(){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Laria'nın fedaisi oyununa hoşgeldiniz..");
        System.out.println("Laria için gereken tüm erzakları toplayıp şehrin ihtiyaçlarını giderebilecek misiniz?..");
        System.out.println("Oyuna başlamak için isminizi giriniz..");
        String playername = scan1.nextLine();
        playername = playername.toUpperCase();
        System.out.println("Valria ya hoşgeldin "+playername);
        player = new Player(playername);
        player.selectCha();
        start();
    }
    public void start(){
        while(true){
            System.out.println();
            System.out.println("===============================================================");
            System.out.println();
            System.out.println("Eylem gerçekleştirmek için bir yer seçin");
            System.out.println("1.Güvenli Ev --> Size ait güvenli bir mekan,düşman yok");
            System.out.println("2.Mağara --> Karşınıza zombi çıkabilir !");
            System.out.println("3.Orman --> Karşınıza ayı çıkabilir !");
            System.out.println("4.Nehir --> Karşınıza vampir çıkabilir !");
            System.out.println("5.Kale --> Karşınıza muhafızlar çıkabilir !");
            System.out.println("6.Dükkan --> Sikke karşılığında araç gereç satın alabilirsiniz !");
            System.out.println("7.Revir --> Sikke karşılığında tedavi olabilirsiniz !");
            System.out.print("Gitmek istediğiniz yer:");
            int selloc= scanner.nextInt();
            while(selloc < 0 || selloc > 7){
                System.out.print("Geçersiz değer girdiniz bir daha giriniz");
                selloc= scanner.nextInt();
            }

            switch (selloc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new River(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new Castle(player);
                    break;
                case 6:
                    location = new ToolStore(player);
                    break;
                case 7:
                    location = new Hospital(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()){
                    System.out.println("Tebrikler Laria için tüm gereçleri topladınız!!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Oyun bitti");
                break;
            }
        }
    }
}
