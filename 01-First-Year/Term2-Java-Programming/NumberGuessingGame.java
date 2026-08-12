/* Sayı tahmin oyunu. 0-100 arasında bir sayı tutulur ve oyuncu beş tahminde sayıyı bilmeye çalışır.
Her tahminden sonra aşağı-yukarı denilerek ipuçları verilir. */

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        
        Scanner giris=new Scanner(System.in);

        Random rastgele=new Random();

        int sayi,isayi,sayac=1;

        isayi=rastgele.nextInt(101);

        System.out.print("Sayı giriniz:");
        sayi=giris.nextInt();

        while(sayi!=isayi){

            if(sayi<isayi){
                System.out.println("Yukarı");
                sayac++;

                System.out.print("Sayı giriniz:");
                sayi=giris.nextInt(); }

            else if(sayi>isayi){

                System.out.println("Aşağı");
                sayac++;

                System.out.print("Sayı giriniz:");
                sayi=giris.nextInt(); }

            if(sayac==5 && sayi!=isayi){
                System.out.println("Tahmin hakkı dolmuştur");
                System.out.println("Istenen sayı:"+isayi);
                break;
            }            
        } 

        giris.close();

        if(sayi==isayi)   {         
            System.out.println("Tekbrikler sayıyı buldunuz");
            System.out.println("Istenen sayı:"+isayi);
        }
    }
    
}