#include <iostream>

using namespace std;

int main(){
	int a,b,c;
	scanf("%d %d %d", &a,&b,&c);
	int year =0;
	while(1){
		year++;
		if((year-a)%15 ==0 && (year-b)%28==0 && (year-c)%19==0){
			printf("%d",year);
			break;
		}
		
	} 
	return 0;
}
