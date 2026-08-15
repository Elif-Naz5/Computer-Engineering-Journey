//Tahmin sayısı on beştir. En fazla arka arkaya beş tur oynama hakkı vardır.
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

     public static void main(String[] args) {

        String dizi[]= {"bayrak","diploma","fantastik","portre","klavye","eflatun","kahraman","kalemlik","firavun","mandalina"};
        int oyunSayisi=0,sayac=0;
        String Kcevap="",Bcevap;
        char harf,secenek;

        Scanner giris= new Scanner(System.in);

        do{

        kelimeSec(dizi);
        String cevap= kelimeSec(dizi);

        System.out.println("Kelime "+cevap.length()+" karakterlidir");
        Bcevap= cevap.toUpperCase();

        if(Bcevap.length()==6){
            System.out.println(Bcevap.charAt(0)+"*****");
            Kcevap=Bcevap.charAt(0)+"*****";
        }

        else if(Bcevap.length()==7){
            System.out.println(Bcevap.charAt(0)+"******");
             Kcevap=Bcevap.charAt(0)+"******";
        }

        else if(Bcevap.length()==8){
            System.out.println(Bcevap.charAt(0)+"******"+Bcevap.charAt(7));
            Kcevap=Bcevap.charAt(0)+"******"+Bcevap.charAt(7);
        }

        else if(Bcevap.length()==9){
            System.out.println(Bcevap.charAt(0)+"*******"+Bcevap.charAt(8));
            Kcevap=Bcevap.charAt(0)+"*******"+Bcevap.charAt(8);
        }

        System.out.println();
  

        while((!Kcevap.equals(Bcevap))&&(sayac<15)){

            System.out.print("Harf giriniz: ");
            harf=giris.next().toUpperCase().charAt(0);
            sayac++;

            String degisken=""; 

            int bulunanSayisi=0;
               
            for(int i=0;i<Bcevap.length();i++){

                if(Kcevap.charAt(i)!='*')
                    degisken+=Kcevap.charAt(i);
                 
                else if(harf==Bcevap.charAt(i)){
                    degisken+=harf;
                    bulunanSayisi++;
                    }

                else if(harf!=Bcevap.charAt(i))
                    degisken+="*"; 
                    
             }

             if(bulunanSayisi==0)
                System.out.println("Harf yok");

            Kcevap=degisken;
            System.out.println(Kcevap);
            System.out.println();
        }


        if(Kcevap.equals(Bcevap))
            System.out.println("Tebrikler");

        else
            System.out.println("Üzgünüm bilemediniz");
        
        
        oyunSayisi++;
        sayac=0;
        System.out.println("Tekrar oynamak ister misiniz? (e/h)");
        secenek=giris.next().charAt(0);              

    }while((oyunSayisi<5)&&(secenek=='e'));  
    

    if(oyunSayisi==5)
        System.out.println("Oyun sayısı dolmuştur! Oynadığınız için teşekkür ederim");

    else
        System.out.println("Oyun bitmiştir. Oynadığınız için teşekkür ederim");

    giris.close();
  }

    public static String kelimeSec(String kelimeDizi[]){

        Random rnd= new Random();
        int indis;
        String secilenKelime;
        
        do{
        indis= rnd.nextInt(kelimeDizi.length);
        secilenKelime= kelimeDizi[indis];

        }while(secilenKelime.equals(""));

        kelimeDizi[indis]="";
        

        return secilenKelime;
   }    
}