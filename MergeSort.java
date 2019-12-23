import com.sun.scenario.effect.Merge;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    static Scanner sc ;
    static int [] input;
    static int [] sortedArray;
    static void merge(int [] arr, int m, int middle , int n){

        int leftArrayIndex = m;
        int rightArrayIndex = middle + 1;
        int k=m;
        while(leftArrayIndex <=middle && rightArrayIndex <=n){
            if(arr[leftArrayIndex] <= arr[rightArrayIndex]){
                sortedArray[k] = arr[leftArrayIndex++];
            }else{
                sortedArray[k] = arr[rightArrayIndex++];
            }
            k++;
        }
        if(leftArrayIndex > middle){
            for(int i = rightArrayIndex ; i<=n ; i++,k++){
                sortedArray[k] = arr[i];
            }
        }else{
            for(int i = leftArrayIndex ; i<=middle ; i++,k++){
                sortedArray[k] = arr[i];
            }
        }
        for(int t=m;t<=n;t++) {
            arr[t] = sortedArray[t];
        }



        System.out.println("병합 정렬 후  : "+Arrays.toString(sortedArray));
    }
    static void mergeSort(int []  arr , int startIndex , int lastIndex){
        //종료조건
        if(startIndex<lastIndex){
            //분할
            int middleIndex = (startIndex + lastIndex)/2;
            mergeSort(arr, startIndex , middleIndex);
            mergeSort(arr,middleIndex + 1 , lastIndex);
            //정복
            merge(arr,startIndex,middleIndex,lastIndex);
        }
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int number = sc.nextInt();
        input = new int[number];
        sortedArray = new int[number];
        for(int i = 0 ; i < number ; i++){
            input[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(input));
        System.out.println(input.length);
        mergeSort(input,0,input.length-1);
        System.out.println(Arrays.toString(sortedArray));
    }
}
