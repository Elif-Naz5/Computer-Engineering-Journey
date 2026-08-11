/*Kendisine yollanan 2 sayı arasındaki asal sayıları listeleyen ve ekrana 
yazdıran bir metot yazınız. */
import java.util.Scanner;

public class FindingPrimeNumbers {
    public static void main(String[] args) {
        
        int sayi1,sayi2;

        Scanner giris= new Scanner(System.in);

        System.out.print("Sayı1: ");
        sayi1=giris.nextInt();

        System.out.print("Sayı2: ");
        sayi2=giris.nextInt();

        giris.close();

        asalYazdir(sayi1,sayi2);

    }

    public static void asalYazdir(int sayi1, int sayi2){

        int kalan=0;

    if(sayi1<sayi2){

        for(int i=sayi1;i<=sayi2;i++){
            for(int j=1;j<=i;j++){
                if((i%j==0))
                    kalan++; 

            }

            if(kalan==2)
                System.out.println(i);

            kalan=0;  
        }
     }

    else
        System.out.println("Hatalı giriş!");
     
    }
}