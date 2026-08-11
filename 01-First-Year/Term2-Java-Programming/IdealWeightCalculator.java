import java.util.Scanner;

public class IdealWeightCalculator {
    public static void main(String[] args) {
        
        Scanner giris= new Scanner(System.in);

        double boy,yas,kilo,idealKilo=0,K,mesaj=0;
        char cinsiyet;

        System.out.print("Boyunuzu cm cinsinden giriniz: ");
        boy=giris.nextDouble();

        System.out.print("Yaşınızı giriniz: ");
        yas=giris.nextDouble();

        System.out.println("Kadın:K, Erkek:E");
        System.out.print("Cinsiyetinizi giriniz: ");
        cinsiyet=giris.next().charAt(0);

        System.out.print("Kilonuzu kg cinsinden giriniz: ");
        kilo=giris.nextDouble();

        System.out.println();

        if(cinsiyet=='K'){

            K=0.8;
            idealKilo=(boy-100+(yas/10))*K;

            System.out.println("Ideal kilonuz:"+idealKilo);
        }

        else if(cinsiyet=='E'){

            K=0.9;
            idealKilo=(boy-100+(yas/10))*K;

            System.out.println("Ideal kilonuz:"+idealKilo);
        }


        if(kilo>idealKilo){

            mesaj=kilo-idealKilo;

            System.out.println("Vermeniz gereken kilo: "+mesaj);
        }

        else if(kilo<idealKilo){

            mesaj=idealKilo-kilo;

            System.out.println("Almanız gereken kilo:"+mesaj);

            
        }

        else{
            System.out.println("Tebrikler,ideal kilonuzdasiniz");
        }
        
        giris.close();
}
}