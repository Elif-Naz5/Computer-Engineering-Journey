#include<stdio.h>

main() {
	int j,i,k=0;
	char dizi[10];
	
	printf("Kelime giriniz: ");
	gets(dizi);
	printf("\n");
	
	for(i=0;dizi[i]!='\0';i++) k++;
	
	for(i=k;i>0;i--) {
		
		for(j=0;j<i;j++)
		printf("%c",dizi[j]);
		
	printf("\n");
	}
	
	return 0;
}