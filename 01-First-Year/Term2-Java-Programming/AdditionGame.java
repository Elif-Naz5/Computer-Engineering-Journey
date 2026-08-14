//Toplama işlemini pekiştiren puanlı oyun programı
import java.util.Random;
import java.util.Scanner;

public class AdditionGame {
    public static void main(String[] args) {

        Scanner giris=new Scanner(System.in);

        Random rastgele= new Random();

        int sayi1,sayi2,toplam=0,cevap;
        int d=0,y=0,puan=0;
        char secenek;

        System.out.println("-----Hoş Geldiniz-----");
        System.out.println("Doğru: 5 puan");
        System.out.println("Yanlıs: -2 puan");
        System.out.println();

        do{
            sayi1=rastgele.nextInt(100)+1;
            sayi2=rastgele.nextInt(100)+1;

            System.out.println("Sayı1= "+sayi1+ " ve Sayı2= "+sayi2);
            System.out.print("Toplamları nedir? ");
            cevap=giris.nextInt();

            toplam=sayi1+sayi2;

            if(toplam==cevap) {
                System.out.println("Tebrikler bildiniz");
                d++;
                puan+=5;
            }

            else{
                System.out.println("Üzgünüm bilemediniz");
                y++;
                puan-=2;
            }

            System.out.println("Tekrar oynamak ister misiniz? (e/E yeniden oynamak icin) ");
            secenek=giris.next().charAt(0);      
            System.out.println(); 

        }while(secenek=='e'|| secenek=='E');

        giris.close();

        System.out.println("Dogru cevap sayısı: "+d);
        System.out.println("Yanlış cevap sayısı: "+y);
        System.out.println("Puan: "+puan);
    
    }
    
}