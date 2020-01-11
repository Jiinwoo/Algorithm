#include<stdio.h>

int main() {
    int a[100] = { 0, };
    int b[100] = { 0, };
    int n, count, l, i, k;                  //count는 숫자가 중복되는 횟수
    a[0] = 1;                               //처음은 1로 시작

    printf("Enter : ");
    scanf("%d", &n);

    printf("%3d\n", a[0]);

    for (int m = 1; m < n; m += 1) {
        i = 0;
        l = 0;
        count = 1;

        while (a[i] != 0) {
            if (a[i + 1] == a[i]) {
                count += 1;
            }
            else {
                b[l] = a[i];
                printf("%3d", b[l]);
                l += 1;

                b[l] = count;
                printf("%3d", b[l]);
                l += 1;
                count = 1;
            }

            i += 1;
        }

        for (k = 1; k < 100; k += 1) {      //배열 복사 모듈
            a[k] = b[k];
            b[k] = 0;
        }
        
        printf("\n");
    }

    return 0;
}
