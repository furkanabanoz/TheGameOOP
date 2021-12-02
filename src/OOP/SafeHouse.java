package OOP;

public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "guvenli ev");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Guvenli evdesiniz !\nCaniniz yenilendi.");
        this.getPlayer().setHealthy(this.getPlayer().getOrginalHealth());
        return true;
    }
}
