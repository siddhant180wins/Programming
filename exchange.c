#include<stdio.h>
int main(){
	void exchange(int *a,int *b){
		int temp;
		temp = *a;
		*a = *b;
		*b = temp;
		printf("%d,%d",*a,*b);
	}
	int a = 10,b=20;
	printf("%d,%d",a,b);
	exchange(&a,&b);
	printf("%d,%d",a,b);

}
