//3 kişilik bir grubun vize-final sonuçları girilecek. Geçme notu 70 olan dersten geçip geçmedikleri yazılacak.
import java.util.Scanner;

public class GradeEvaluator {
    public static void main(String[] args) {
        
        int dizi[][]= new int[3][2];
       
        double ortalama[]=new double[3];        

        Scanner giris= new Scanner(System.in);

        for(int i=0;i<dizi.length;i++){
           
            System.out.print("Vize notu giriniz: ");
            dizi[i][0]= giris.nextInt();

            System.out.print("Final notu giriniz: ");
            dizi[i][1]=giris.nextInt();
        }

        System.out.println();

        for(int i=0;i<ortalama.length;i++){

            ortalama[i]=(dizi[i][0]*0.4)+(dizi[i][1]*0.6);

           System.out.println((i+1)+". öğrenci ortalama: "+ortalama[i]);

        }
        
        System.out.println();
        System.out.println("Geçme-Kalma Durumu");

        for(int i=0;i<ortalama.length;i++){

            if(ortalama[i]<70)
                System.out.println("Kaldı");

            else{
                System.out.println("Geçti");
            }
        }   
        
        giris.close();
    }
    
}