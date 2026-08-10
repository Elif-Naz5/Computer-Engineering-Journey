#include <stdio.h>
main () {

	float bakiye,tutar;
	int secenek;
	
	printf("Lutfen bakiye girisi yapiniz: ");
	scanf("%f", &bakiye);
	printf("Lutfen cekilmek istenen tutar girisi yapiniz: ");
	scanf("%f", &tutar);
	
	printf("\n");
	
	if (tutar>bakiye) {
		printf("Yetersiz bakiye! \n "); 
		}
		
	else if ((bakiye>tutar) && (bakiye-tutar<100)) {
		printf("Uyari! Para cekimi gerceklesirse hesabinizda 100 TL den az para kalacaktir. \n");
		printf("Lutfen cekim icin 1'i, iptal icin 0'i tuslayiniz: ");
		scanf("%d", &secenek); 
		
	    if (secenek==1) {
		    printf("Hesabinizdan para cekilmistir. \t Kalan tutar: %.2f \n", bakiye-tutar);
		}
		
	    else if (secenek==0) {
		    printf("Islem iptal edilmistir.");
		}
	}
	else {
		printf("Hesabinizda %.2f TL para kalmistir", bakiye-tutar);
	}
		
	return 0; 
}