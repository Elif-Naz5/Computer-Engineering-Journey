import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ForbesDataAnalyzer {
    
    public static Scanner giris= new Scanner(System.in);
    public static String bilgiler[]= new String[30];
    public static List<String> liste;
    public static String dosyaAdi="forbes30.txt";
    public static void main(String[] args) {

        dosyaOku();
        int secim=0;
        System.out.println("-------FORBES TOP30 LİSTESİ HOŞGELDİNİZ-------");
            System.out.println("[1] Veri Çek "+" API den dolayı yüklenmesi uzun sürebilir");
            System.out.println();
            System.out.println("[2] Listele");
            System.out.println("a) Serveti 100 milyardan az olanların isimlerini listele");
            System.out.println("b) Endüstri kısmı teknoloji olanların isimlerini ve şirketlerini listele");
            System.out.println("c) Ülkesi United States olanların isimlerini listele");
            System.out.println("d) Hepsini listele");
            System.out.println();
            System.out.println("[3] Güncelle");
            System.out.println("a) Seçilen kaydın endüstri bilgisini güncelle");
            System.out.println();
            System.out.println("[4] Sil");
            System.out.println("a) Seçilen ülkeye göre kayıt sil");
            System.out.println();
            System.out.println("[5] İstatistik");
            System.out.println("a) Kadın-Erkek sayısını bul");
            System.out.println("b) Ortalama serveti bul");
            System.out.println();
            System.out.println("[6] Tarih-Saat Bilgisi (Veriler gerçek zamanlıdır)");
            System.out.println();
            System.out.println("[7] Çıkış");

        do{
            System.out.print("Seçim giriniz:");
            secim=giris.nextInt();
            giris.nextLine();

            if((secim>0)&&(secim<8)){          
            
            switch(secim){
                
                case 1:
                    veriCek();
                    break;
                    

                case 2:
                    String secenek2;
                    System.out.print("Alt menü seçiniz (a,b,c,d): "); 
                    secenek2=giris.nextLine().toLowerCase();
                     
                    if(secenek2.equals("a")) {
                        Menu2_Servet();
                        System.out.println();
                        break;  }  
                    else if(secenek2.equals("b")) {
                        Menu2_Endustri();
                        System.out.println();
                        break; }
                    else if(secenek2.equals("c")) {
                        Menu2_Ulke();
                        System.out.println();
                        break; } 
                    else if(secenek2.equals("d")) {
                        Menu2_Hepsi();
                        System.out.println();
                        break; }
                    else {
                        System.out.println("Hatalı alt menü girişi!");  
                        break; }    
                    
                case 3:
                    String secenek3;
                    System.out.print("Alt menü seçiniz (a): ");
                    secenek3=giris.nextLine().toLowerCase();

                    if(secenek3.equals("a")) {
                        Menu3_endustriDegistirme();
                        break;  }
                    else {
                        System.out.println("Hatalı alt menü girişi!");
                        break; }

                case 4:
                    String secenek4;
                    System.out.print("Alt menü seçiniz (a): ");
                    secenek4=giris.nextLine().toLowerCase();

                    if(secenek4.equals("a")){
                        Menu4_ulkeSil();
                        break;  }
                    else{
                        System.out.println("Hatalı alt menü girişi!");
                        break;  }

                case 5:
                    String secenek5;
                    System.out.print("Alt menü seçiniz (a,b): ");
                    secenek5=giris.nextLine().toLowerCase();

                    if(secenek5.equals("a")){
                        Menu5_cinsiyet();
                        break; } 
                    else if(secenek5.equals("b")){
                        Menu5_ortalama();
                        break; }
                    else{
                        System.out.println("Hatalı alt menü girişi!");
                        break;  }

                case 6:
                   Menu6_tarihSaat();
                   break;

                case 7:
                    System.out.println("Çıkış yapılıyor, ziyaretiniz için teşekkür ederim");
                    break;
                }
            }

            else
                System.out.println("Hatalı seçim girişi,yeniden giriniz!");

            }while(secim!=7);     
    }

    public static void veriCek(){
        
        try{
            String urlString= "https://forbes400.onrender.com/api/forbes400?limit=30";

            URI uri= URI.create(urlString);
            URL url= uri.toURL();
            String satir;

            HttpURLConnection baglanti=(HttpURLConnection) url.openConnection(); 
            baglanti.setRequestMethod("GET");

            BufferedReader oku= new BufferedReader( new InputStreamReader(baglanti.getInputStream()));

            StringBuilder insaa= new StringBuilder();

            while((satir=oku.readLine())!=null){
                 insaa.append(satir);  }

            oku.close();  
            
            String json=insaa.toString();

            String parcalar[] = json.split("\"rank\":"); 
            FileWriter fw= new FileWriter(dosyaAdi, false);
            
            for(int i=1;i<=30;i++){
             
            String sira=parcaGetir(parcalar[i],"\"position\":"); 
            sira = sira.replace(",", "");
            sira.trim();   

            String servet= parcaGetir(parcalar[i],"\"finalWorth\":");
            servet = servet.replace(",", "");
            servet.trim(); 

            String adSoyad= parcaGetir(parcalar[i],"\"personName\":\"");
            String gelirKaynagi= parcaGetir(parcalar[i],"\"source\":\"");
            String endustri= parcaGetir(parcalar[i],"\"industries\":[\"");           
            String ulke= parcaGetir(parcalar[i],"\"countryOfCitizenship\":\"");
            String cinsiyet=parcaGetir(parcalar[i],"\"gender\":\"");  

           bilgiler[i-1] = sira + ";" +adSoyad + ";" +cinsiyet + ";" + ulke + ";" + gelirKaynagi + ";" + endustri + ";" + servet;

            fw.write(bilgiler[i-1]+"\n");                                
        }
         fw.close();
         dosyaOku();
         System.out.println("Veri başarıyla çekildi");
         System.out.println();  }

        catch(Exception hata1){
            System.out.println("veriÇek metodunda hata olustu");
            System.out.println(hata1.toString());  }
    }

    public static String parcaGetir(String veri, String anahtar){

        int index=veri.indexOf(anahtar);

        if(index==-1)
            return null;
        else{
            int basla=index+anahtar.length();
            int bitis=veri.indexOf("\"",basla);

            return veri.substring(basla,bitis); }
     }

     public static List<String> dosyaOku(){

        try{
            dosyaAdi="forbes30.txt";

            File dosya = new File(dosyaAdi);
            Path filePath = dosya.toPath();

            liste = Files.readAllLines(filePath,Charset.defaultCharset());
    }
        catch(IOException ioException){
            System.out.println("dosyaOku metodunda hata olustu");
            System.out.println(ioException.toString());   }

        return liste;  
    }


    public static void Menu2_Servet(){

        for(int i=0;i<liste.size();i++){

            String satir=liste.get(i);
            String ayristirma[]=satir.split(";");

            String servet=ayristirma[6];
            double sservet=Double.parseDouble(servet);

            if(sservet<100000.000)
                System.out.println(ayristirma[0]+"  "+ayristirma[1]+" "+sservet);  }
}

   public static void Menu2_Endustri(){

    for(int i=0;i<liste.size();i++){

        String satir=liste.get(i);
        String ayristirma[]=satir.split(";");

        String endustri=ayristirma[5];

       if(endustri.equals("Technology"))
            System.out.println(ayristirma[0]+"  "+ayristirma[1]+"  "+endustri+"  "+ayristirma[4]);     }
}

    public static void Menu2_Ulke(){

     for(int i=0;i<liste.size();i++){

        String satir=liste.get(i);
        String ayristirma[]=satir.split(";");

        String ulke=ayristirma[3];

       if(ulke.equals("United States"))
          System.out.println(ayristirma[0]+"  "+ayristirma[1]);    }
    }

    public static void Menu2_Hepsi(){

    for(int i=0;i<liste.size();i++){

        String satir=liste.get(i);
        String ayristirma[]=satir.split(";");

        System.out.println(ayristirma[0]+"  "+ayristirma[1]+"  "+ayristirma[2]+"  "+ayristirma[3]+"  "+ayristirma[4]+"  "+ayristirma[5]+"  "+ayristirma[6]); }      
    } 


    public static void Menu3_endustriDegistirme(){   

        try{
        String degisecekEndustri,yeniEndustri,cevap;

        System.out.print("Değişecek endüstriyi giriniz: ");
        degisecekEndustri=giris.nextLine();

        System.out.print("Yeni endüstriyi giriniz: ");
        yeniEndustri=giris.nextLine();
         System.out.println();

        for(int i=0;i<liste.size();i++){

            String satir=liste.get(i);
            String ayristirma[]=satir.split(";");

            String endustrii=ayristirma[5];

            if(endustrii.equals(degisecekEndustri)){

                System.out.println(ayristirma[0]+";"+ayristirma[1]+";"+ayristirma[2]+";"+ayristirma[3]+";"+ayristirma[4]+";"+ayristirma[5]+";"+ayristirma[6]);
                System.out.print("Değişecek kayıt bu mu? (e,h)");
                cevap=giris.nextLine().toLowerCase();

                if(cevap.equals("e")){
                    String yeniSatir= ayristirma[0]+";"+ayristirma[1]+";"+ayristirma[2]+";"+ayristirma[3]+";"+ayristirma[4]+";"+yeniEndustri+";"+ayristirma[6];
                    liste.set(i,yeniSatir);
                    System.out.println("Başarıyla güncellendi"); 
                    System.out.println("Yeni satır: "+yeniSatir);
                    System.out.println();   }   
                else{
                    System.out.println("Kayıt aynı kaldı");
                    System.out.println(); }
                } 
            }  
             FileWriter fw = new FileWriter(dosyaAdi, false);
            
            for (String stringListe : liste) {
                fw.write(stringListe +"\n");
            }
            fw.close();
            dosyaOku();

            }catch(IOException ioException){
                System.out.println("Menu_3 kısmında hata oluştu");
                System.out.println(ioException.toString());   }
        }

        
        public static void Menu4_ulkeSil(){

            try{
                String silinecekUlke,cevap;

                System.out.print("Silinecek ülkeyi giriniz: ");
                silinecekUlke=giris.nextLine();
                System.out.println();

                for(int i=0;i<liste.size();i++){

                    String satir=liste.get(i);
                    String ayristirma[]=satir.split(";");

                    String ulke= ayristirma[3];

                    if(ulke.equals(silinecekUlke)){

                        System.out.println(ayristirma[0]+";"+ayristirma[1]+";"+ayristirma[2]+";"+ayristirma[3]+";"+ayristirma[4]+";"+ayristirma[5]+";"+ayristirma[6]);
                        System.out.print("Silinecek kayıt bu mu? (e,h): ");
                        cevap=giris.nextLine().toLowerCase();

                        if(cevap.equals("e")){
                            String yeniSatir="";
                            liste.set(i,yeniSatir);
                            System.out.println("Başarıyla silindi"); 
                            System.out.println();  }
                        else{
                            System.out.println("Kayıt aynen kaldı"); 
                            System.out.println();    }   
                    }
                }

            FileWriter fw = new FileWriter(dosyaAdi, false);
            
              for (String stringListe : liste) {

                if(!stringListe.equals(""))
                  fw.write(stringListe +"\n");
             }
            fw.close();
            dosyaOku();
        
         }catch(IOException ioException2){
                System.out.println("Menu_4 kısmında hata oluştu");
                System.out.println(ioException2.toString());   }
        }


        public static void Menu5_cinsiyet(){

            int kadin=0,erkek=0;

            for(int i=0;i<liste.size();i++){

              String satir=liste.get(i);
              String ayristirma[]=satir.split(";");

              String cinsiyet=ayristirma[2];

            if(cinsiyet.equals("F"))
                kadin++;
            else if(cinsiyet.equals("M"))
                erkek++; }

            System.out.println("Kadın sayısı: "+kadin);
            System.out.println("Erkek sayısı: "+erkek);  
            System.out.println();
        }

        public static void Menu5_ortalama(){

            double ortalama=0.0,toplam=0.0,para=0.0;

            for(int i=0;i<liste.size();i++){

              String satir=liste.get(i);
              String ayristirma[]=satir.split(";");

              String paraString= ayristirma[6];
              para=Double.parseDouble(paraString);

              toplam+=para;   }
              ortalama=toplam/liste.size();

              System.out.println("Ortalama servet: "+ortalama+" milyar dolar"); 
              System.out.println(); 
        }

        public static void Menu6_tarihSaat(){

            Date TarihSaat= new Date();
            System.out.println("Güncel tarih-saat: "+TarihSaat.toString());
            System.out.println();
        }
}