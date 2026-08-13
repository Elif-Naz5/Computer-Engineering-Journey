// Klavyeden girilen sayı negatif olmadığı sürece sayının faktöriyelini hesaplar.
import java.util.Scanner;

public class FactorialCalculator {
        public static void main(String[] args) {

            int sayi,faktoriyel=1;

            Scanner giris= new Scanner(System.in);

            System.out.print("Sayı giriniz: ");
            sayi=giris.nextInt();

            while(sayi>=0){

                for(int i=1;i<=sayi;i++){

                    faktoriyel=faktoriyel*i;
                }

                System.out.println("Faktöriyel: "+faktoriyel);
                System.out.println();
                faktoriyel=1;

                System.out.print("Sayı giriniz: ");
                sayi=giris.nextInt();
                
            }

            System.out.println("Negatif sayı girişi, hesaplama sonlandırıldı");

            giris.close();        
    }
}