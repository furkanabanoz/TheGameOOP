package OOP;

import java.util.Scanner;

public class Game {
    private Scanner input =new Scanner(System.in);

    public void Start(){
        System.out.println("***** Macere oyunu basladi *****\n\n");
        System.out.print("Lutfen bir isim giriniz : ");
        String playerName=input.next();

        Player player=new Player(playerName);
        System.out.println("Sayin "+player.getName()+" bu karanlik ve sisli adaya hosgeldiniz ! Burada yasananlarin hepsi gercek bir hikayeden alintidir...");
        System.out.println("Lutfen karakter seciniz Sayin "+player.getName()+"\n\n");
        player.selectChar();

        Location location=null;

        while (true){
            player.PlayerInfo();
            System.out.println("\n####### Bolgeler #######\n");
            System.out.println("1-SafeZone ---> Burasi sizin icin guvenli");
            System.out.println("2-ToolStore ---> Silah veya Zirh satin alabilirsiniz");
            System.out.println("3-Cave ---> <award Food> Magara git,Dikkatli ol zombi cikabilir !! ");
            System.out.println("4-Forest ---> <award FireWood> Ormana git,Dikkatli ol vampir cikabilir !! ");
            System.out.println("5-River ---> <award Water> Nehire git,Dikkatli ol ayi cikabilir !! ");
            System.out.println("0-Cikis Yap --> Oyunu Sonlandir");
            System.out.print("Lutfen gitmek istediginiz bolgeyi seciniz : ");
            int selectLocation=input.nextInt();
            switch (selectLocation){
                case 1:
                    location=new SafeHouse(player);
                    System.out.println("\n");
                    break;
                case 2:
                    location=new ToolStore(player);
                    System.out.println("\n");
                    break;
                case 0:
                    location=null;
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;

                default:
                    System.out.println("Lutfen gecerli bir bolge giriniz!!!!");
                    break;
            }
            if(location==null){
                System.out.println("Bu karanlik ve sisli adadan cabuk  vazgectin!!");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }


    }
}
