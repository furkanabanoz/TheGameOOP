package OOP;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    private int maxObstacle;
    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int  obsNumber =randomObstacleNumber();
        System.out.println("Suan buradasiniz "+this.getName());
        System.out.println("Dikkatli ol! Burada "+obsNumber+" tane "+this.getObstacle().getName()+" Yasiyor !");
        System.out.println("<S>avas veya <K>ac");
        String selectBattleCase=input.nextLine();
        selectBattleCase=selectBattleCase.toUpperCase();
        if(selectBattleCase.equals("S")){
            if(combat(obsNumber)){
                System.out.println(this.getName()+ " tüm düşmaları yendiniz !");
                return true;
            }
        }
        if (this.getPlayer().getHealthy()<=0) {
            System.out.println("Öldünüz !! GameOver");
            return false;
        }

        return true;

    }
    public boolean combat(int obsNumber){

        for (int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealthy()>0&&this.getObstacle().getHealth()>0){
                System.out.print("<V>ur veya <K>ac : ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println(this.getObstacle().getName()+" size vurdu !");
                        int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy()-obstacleDamage);
                        afterHit();
                    }

                }
                else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealthy()){
                System.out.println("Düşmanı yendiniz ");
                System.out.println(this.getObstacle().getMoney()+" para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getMoney());
                System.out.println("Güncel paranız"+this.getPlayer().getMoney());
            }else{
                return false;
            }

        }
        return true;
    }
    public void afterHit(){
        System.out.println("Caniniz : "+this.getPlayer().getHealthy());
        System.out.println(this.obstacle.getName()+" cani : "+this.getObstacle().getHealth());
        System.out.println();

    }
    public void obstacleStats(int i){
        System.out.println(i+". "+this.getObstacle().getName()+" degerleri");
        System.out.println("----------------------");
        System.out.println("Saglik : "+this.getObstacle().getHealth());
        System.out.println("Hasar : "+this.getObstacle().getDamage());
        System.out.println("Odul : "+this.getObstacle().getMoney());
        System.out.println("----------------------");
    }
    public void playerStats(){
        System.out.println("oyuncu degerleri");
        System.out.println("----------------------");
        System.out.println("Saglik : "+this.getPlayer().getHealthy());
        System.out.println("Silah : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : "+this.getPlayer().getTotalDamage());
        System.out.println("Zırh : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : "+this.getPlayer().getMoney());
        System.out.println("----------------------");

    }
    public int randomObstacleNumber(){
        Random random=new Random();
        return  random.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
