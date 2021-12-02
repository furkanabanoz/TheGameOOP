package OOP;

public class ToolStore extends NormalLocation{



    public ToolStore(Player player) {
        super(player, "Magaza");
    }


    @Override
    public boolean onLocation(){
        boolean showMenu=true;
       while (showMenu){
           System.out.println("-------- Magazaya hosgeldiniz --------");
           System.out.print("1-Silahlar\n2-Zirhlar\n3-Cikis Yap");
           System.out.println("\nSeciminiz : ");
           int selectCase=Location.input.nextInt();
           while (selectCase <1||selectCase>3){
               System.out.println("Gecersiz deger. Lutfen yeniden secim yapiniz !");
               selectCase=Location.input.nextInt();
           }
           switch (selectCase){
               case 1:
                   printWeapon();
                   buyWeapon();
                   break;
               case 2:
                   printArmor();
                   buyArmor();
                   break;
               case 3:
                   System.out.println("Bir daha bekleriz...");
                   showMenu=false;
                   break;
           }

       }
       return true;
    }

    private void printArmor() {
        System.out.println("---- ARMORLAR ----");
        System.out.println("Paranız : "+this.getPlayer().getMoney());
        for(Armor a:Armor.armors()){
            System.out.println(a.getId()+" <Ad : "+a.getName()+" ,Para : "+a.getPrice()+" ,Zirh : "+a.getBlock());
        }

        System.out.println("0- Cikis yap");
        
    }

    public void printWeapon(){
        System.out.println("---- SILAHLAR ----");
        System.out.println("Paranız : "+this.getPlayer().getMoney());
        for(Weapon w:Weapon.weapons()){
            System.out.println(w.getID()+" <Ad : "+w.getName()+" ,Para : "+w.getPrice()+" ,Hasar : "+w.getDamage());
        }
        System.out.println("0- Cikis yap");


    }
    public void buyWeapon(){

        System.out.println("Lutfen secmek istediginiz silahi giriniz : ");
        int selectGunCase=input.nextInt();
        while (selectGunCase <0||selectGunCase>Weapon.weapons().length) {
            System.out.print("Gecersiz deger. Lutfen yeniden secim yapiniz !");
            selectGunCase = Location.input.nextInt();
        }

        if(selectGunCase != 0){
            Weapon selectedWeapon= Weapon.getWeaponOBJbyID(selectGunCase);
            if (selectedWeapon!=null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli paraniz bulunmamaktadir.");
                }
                else{
                    System.out.println(selectedWeapon.getName()+" silahini satin aldiniz.");
                    int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiye  : "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }
            }

        }

    }
    public void buyArmor(){
        System.out.println("Lutfen secmek istediginiz zirhi giriniz : ");
        int selectArmorCase=input.nextInt();
        while (selectArmorCase <0||selectArmorCase>Armor.armors().length) {
            System.out.print("Gecersiz deger. Lutfen yeniden secim yapiniz !");
            selectArmorCase = Location.input.nextInt();

            if (selectArmorCase != 0){
                Armor selectedArmor = Armor.getArmorOBJbyID(selectArmorCase);

                if (selectedArmor != null) {
                    if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                        System.out.println("Yeterli paraniz bulunmamaktadir.");
                    }
                    else {
                        System.out.println(selectedArmor.getName() + " zirhini satin aldiniz.");
                        int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan bakiye : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setArmor(selectedArmor);

                    }
                }

            }
        }

    }
}

