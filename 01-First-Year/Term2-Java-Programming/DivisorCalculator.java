import java.util.Scanner;

public class DivisorCalculator {
    public static void main(String[] args) {

        Scanner giris= new Scanner(System.in);

        int sayi,adet=0;

        System.out.print("Sayı giriniz: ");
        sayi=giris.nextInt();

        for(int i=1;i<=sayi;i++){

            if(sayi%i==0){
                System.out.println(i);
                adet++;
            }
        }

        giris.close();

        System.out.println();
        System.out.println(adet+" tane tam böleni vardır"); 
    }
}