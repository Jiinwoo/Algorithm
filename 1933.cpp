#include <iostream>

using namespace std;

int number;
int array[50][50] = {0,};

int main(){
	
	scanf("%d",&number);
	int x1,h,x2;
	
	for(int i =0; i<number ; i++){
		scanf("%d %d %d",&x1,&h,&x2);
		for(int j = x1 ; j<x2 ; j++){
			for(int k = 0 ; k < h ; k++){
				array[k][j] = 1;
			}
		}
	}
	int height =-1;
	for(int j=0; j<50;j++){
		for(int i=49; i>=0; i--){
			if(array[i][j]==1){
				if(height!=i){
					height = i;
					printf("(%d,%d)",j,i+1);
					break;
				}
				break;
			}
			if(i==0&& height!=-1){
				printf("(%d,0)",j);
				height = -1;
			}
		}

	}
	return 0;
}
