package OOP;

import java.util.Scanner;

public  abstract class Gun {
    private String gunName;
    private String gunID;
    private  int gunDamage;
    private int gunMoney;
    protected Scanner input=new Scanner(System.in);

    public Gun(String gunName, String gunID, int gunDamage, int gunMoney) {
        this.gunName = gunName;
        this.gunID = gunID;
        this.gunDamage = gunDamage;
        this.gunMoney = gunMoney;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }

    public String getGunID() {
        return gunID;
    }

    public void setGunID(String gunID) {
        this.gunID = gunID;
    }

    public int getGunDamage() {
        return gunDamage;
    }

    public void setGunDamage(int gunDamage) {
        this.gunDamage = gunDamage;
    }

    public int getGunMoney() {
        return gunMoney;
    }

    public void setGunMoney(int gunMoney) {
        this.gunMoney = gunMoney;
    }
}

