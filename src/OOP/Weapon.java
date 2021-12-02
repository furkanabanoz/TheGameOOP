package OOP;

public class Weapon {
    private int ID;
    private int damage;
    private int price;
    private String name;

    public Weapon( String name,int ID, int damage, int price) {
        this.ID = ID;
        this.damage = damage;
        this.price = price;
        this.name = name;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList=new Weapon[3];
        weaponList[0]=new Weapon("Tabanca",1,2,15);
        weaponList[1]=new Weapon("Kilic",2,3,35);
        weaponList[2]=new Weapon("Tufek",3,7,45);

        return weaponList;
    }
    public static Weapon getWeaponOBJbyID(int ID){
        for(Weapon w : Weapon.weapons()) {
            if(w.getID()==ID){
                return w;
            }
        }
        return null;
    }





    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
