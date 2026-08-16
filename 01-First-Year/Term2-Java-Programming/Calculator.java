import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        
        double sayi1,sayi2;
        char operator;

        Scanner giris= new Scanner(System.in);

        System.out.print("Ilk sayıyı giriniz: ");
        sayi1=giris.nextDouble();

        System.out.print("Ikinci sayıyı giriniz: ");
        sayi2=giris.nextDouble();

        System.out.print("Operatör giriniz: ");
        operator=giris.next().charAt(0);

        giris.close();

        hesapMakinesi(sayi1,sayi2,operator);
        
    }

    public static void hesapMakinesi(double sayi1, double sayi2, char operator){

        double sonuc;

        switch(operator){

            case '+':
                sonuc=sayi1+sayi2;
                System.out.print(sonuc);
                break;

            case '-':
                sonuc=sayi1-sayi2;
                System.out.print(sonuc);
                break;

            case '*':
                sonuc=sayi1*sayi2;
                System.out.print(sonuc);
                break;

            case '/':
                if(sayi2!=0.0){
                    sonuc=sayi1/sayi2;
                    System.out.print(sonuc);
                    break;
                }
                else{
                    System.out.print("Hatalı işlem talebi");
                    break;
                }

            default:
                System.out.println("Hatalı operatör seçimi");
                System.out.println("Toplama: +");
                System.out.println("Çıkarma: -");
                System.out.println("Çarpma: *");
                System.out.println("Bölme: /");
                break;
        }
    }
    
}