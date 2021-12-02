package OOP;
import java.util.Scanner;

public class Player  {
    private Inventory inventory;
    private int damage;
    private int orginalHealth;
    private int healthy;
    private int money;
    private String name;
    private String charName;

    private Scanner input =new Scanner(System.in);


    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }


    public void selectChar(){
        GameCharacter[] charList ={new Samurai(),new Archery(),new Knight()};
        System.out.println("-------------KARAKTERLER--------------");
        for (GameCharacter gameCharacter:charList){

            System.out.println("Id : "
                    +gameCharacter.getId()+" Karakter : "
                    +gameCharacter.getName()+" Hasar : "
                    +gameCharacter.getDamage()+" Can : "
                    +gameCharacter.getHealthy()+" Para : "
                    +gameCharacter.getMoney());
        }
        System.out.println("--------------------------------------\n\n");
        System.out.print("Lutfen secmek istediginiz karakteri giriniz : ");
        int select=input.nextInt();

        switch (select){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archery());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }

    }
    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealthy(gameCharacter.getHealthy());
        this.setOrginalHealth(gameCharacter.getHealthy());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());


    }
    public void PlayerInfo(){
        System.out.println("Silahiniz :"
                +this.getInventory().getWeapon().getName()
                +"\nZirhiniz :"
                +this.getInventory().getArmor().getName()
                +" \nHasariniz : "
                +this.getTotalDamage()
                +"\nBloklamaniz : "
                +this.getInventory().getArmor().getBlock()
                +"\nCaniniz : "
                +this.getHealthy()+
                "\nParaniz : "
                +this.getMoney());
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public  int getTotalDamage(){
        return damage+this.inventory.getWeapon().getDamage();
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
        if(healthy<0){
            healthy=0;
        }
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }
}
