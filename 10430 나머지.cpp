#include <iostream>

using namespace std;

int main(){
	int a,b,c;
	scanf("%d %d %d", &a,&b,&c);
	int year =1;
	while(1){
		if((year%15)+1==a && ((year%28)+1)==b && ((year%19)+1)==c){
			printf("%d\n", year);
			break;
		} 
	} 
	return 0;
}
