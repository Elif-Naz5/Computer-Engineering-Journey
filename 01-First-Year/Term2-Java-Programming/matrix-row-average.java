/*   Satır ve sütun sayısı klavyeden girilecek iki boyutlu sayısal diziye 0-100 arasında rastgele sayılardan değer 
atanacaktır. Değer atandıktan sonra her bir satırın aritmetik ortalamasını bulup ekrana yazdıran programı yazınız. */

import java.util.Random;
import java.util.Scanner;

public class diziAritmetikOrtalama {
    
    public static void main(String[] args) {
        
        int satir,sutun,toplam=0;
        double ortalama=0.0;

        Scanner giris= new Scanner(System.in);
        Random rastgele=new Random();

        System.out.print("Satır sayısı giriniz: ");
        satir=giris.nextInt();

        System.out.print("Sütun sayısı giriniz: ");
        sutun=giris.nextInt();

        int dizi[][]=new int[satir][sutun];

        for(int i=0;i<dizi.length;i++){
            for(int j=0;j<dizi[i].length;j++){

            dizi[i][j]=rastgele.nextInt(101); 

            }
        }

        for(int i=0;i<dizi.length;i++){
            for(int j=0;j<dizi[i].length;j++){

                System.out.print(dizi[i][j]+"\t");

            }
            System.out.println();
        }

        for(int i=0;i<dizi.length;i++){
            for(int j=0;j<dizi[i].length;j++){

               toplam+=dizi[i][j];
               ortalama=(double) toplam/dizi[i].length;

            }
        System.out.println((i+1)+". satırın aritemtik ortalamsı:"+ortalama);
        toplam=0;
        ortalama=0.0;
        }

        giris.close();   
    }
}