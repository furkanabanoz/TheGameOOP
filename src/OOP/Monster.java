package OOP;

public class Monster {
    private String ID;
    private int damage;
    private int healthy;
    private int money;

    public Monster(String ID, int damage, int healthy, int money) {
        this.ID = ID;
        this.damage = damage;
        this.healthy = healthy;
        this.money = money;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
