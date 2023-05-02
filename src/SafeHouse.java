import java.util.Scanner;

public class SafeHouse extends NormalLocation {
    private int safehousenum=0;

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    public boolean getLocation() {
            System.out.println("Şuan güvenli evdesiniz");
            return true;
    }


}
