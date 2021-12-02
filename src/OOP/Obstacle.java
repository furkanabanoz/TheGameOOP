package OOP;

public class Obstacle {
    private int Id;
    private int Damage;
    private int health;
    private String name;
    private int money;
    private int orginalHealth;

    public Obstacle(int id, int damage, int health,String name,int money) {
        this.Id = id;
        this.Damage = damage;
        this.health = health;
        this.orginalHealth = health;
        this.name=name;
        this.money=money;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0)
            health=0;
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }
}

