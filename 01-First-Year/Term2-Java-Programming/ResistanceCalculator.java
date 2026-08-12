import java.util.Scanner;

public class ResistanceCalculator {

    public static void main(String[] args) {
        
        Scanner giris=new Scanner(System.in);

        double direnc1,direnc2,esdegerDirenc;
        String tur;

        System.out.print("1. direnci giriniz: ");
        direnc1 =giris.nextDouble();

        System.out.print("2. direnci giriniz: ");
        direnc2=giris.nextDouble();

        giris.nextLine();

        System.out.print("Devre türünü seçiniz: (s,p)");
        tur=giris.nextLine();

        giris.close();

        switch(tur){

            case"s":
            esdegerDirenc=direnc1+direnc2;
            System.out.println(esdegerDirenc);
            break;

            case"p":esdegerDirenc=(direnc1*direnc2)/(direnc1+direnc2);
            System.out.println(esdegerDirenc);
            break;

            default:
                System.out.println("Hatalı devre türü!");
                break;
           }    
        } 
    }