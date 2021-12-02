package OOP;

import java.util.Scanner;

public abstract class GameCharacter {
    private String name;
    private String id;
    private int damage;
    private int healthy;
    private  int money;
    protected Scanner input=new Scanner(System.in);


    public GameCharacter(String id,String name, int damage, int healthy, int money) {
        this.id = id;
        this.name=name;
        this.damage = damage;
        this.healthy = healthy;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

