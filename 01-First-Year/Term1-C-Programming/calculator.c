#include<stdio.h>  

main() {
	float a,b;
	float sonuc;
	char islem;
	
	printf("Hesap makinesine hos geldiniz \n");
	printf("Lutfen ilk sayiyi giriniz: ");
	scanf("%f", &a);
	printf("\n");
	
	printf("Lutfen ikinci sayiyi giriniz: ");
	scanf("%f", &b);
	printf("\n");
	
	printf("Lutfen islem seciniz ");
	printf("\n Toplama icin: +, \t Cikarma icin: -,\n Carpma icin: *, \t Bolme icin: / \n");
    scanf(" %c", &islem);   
    
    switch (islem) {
    	case '+':
    		sonuc = a+b;
    		printf("Islem sonucu: %.2f", sonuc);
    		break;
    		
    	case '-':
    		sonuc = a-b;
    		printf("Islem sonucu: %.2f", sonuc);
    		break;
			
		case '*':
    		sonuc = a*b;
    		printf("Islem sonucu: %.2f", sonuc);
    		break;
			
		case '/':
			if (b==0) {
				printf("Tanimsiz islem!");
				break; }
			
			else {
				sonuc = a/b;
    		    printf("Islem sonucu: %.2f", sonuc);
    		    break;	
			}  
			
		default:
		printf("Hatali operator girisi!");
		break;
		  	
	}
	return 0;

}