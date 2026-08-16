/*Aşağıdaki ölçütleri temel alarak öğrencinin bir kursa kabul edilmeye uygun olup olmadığını 
belirleyen programı yazınız. Şartlar şu şekildedir; 
Öğrencinin Matematik Notu >=65 olmalı, 
Öğrencinin Fizik Notu >=55 olmalı, 
Öğrencinin Kimya Notu >=50 olmalı, 
Her üç dersten notları toplam >=190 olmalı veya Matematik ve Fizik Toplamı >=140 olmalı */

import java.util.Scanner;

public class CourseEligibilityChecker {
    public static void main(String[] args) {

        Scanner giris= new Scanner(System.in);

        int matematik,fizik,kimya;
        int toplam1=0,toplam2=0;

        System.out.print("Matematik notunu giriniz: ");
        matematik=giris.nextInt();

        System.out.print("Fizik notunu giriniz: ");
        fizik=giris.nextInt();

        System.out.print("Kimya notunu giriniz: ");
        kimya=giris.nextInt();

        if((matematik>=65)&&(fizik>=55)&&(kimya>=50)){

            toplam1=matematik+fizik+kimya;
            toplam2=matematik+fizik;

            if((toplam1>=190)||(toplam2>=140)){

                System.out.println("Tebrikler, kursa kabul edildiniz");
            }

            else{
                System.out.println("Üzgünüz,ders toplamlarını sağlayamıyorsunuz");
            }

        }

        else{
            System.out.println("Üzgünüz,minimum ders notlarını sağlayamıyorsunuz");
        }

        giris.close();
    }
    
}