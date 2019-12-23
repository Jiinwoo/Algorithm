import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static Scanner scanner;
    static int [] input;
    static void sort(int[] arr , int start , int end){
        if (start >= end){
            return ;
        }
        int key = start;
        int i = start+1;
        int j = end;
        int temp;
        while(i<=j){
            while(i <=end && arr[i] <=arr[key]){
                i++;
            }
            while( j >start && arr[j] >=arr[key]){
                j--;
            }
            if(i > j){
                temp = arr[j];
                arr[j] = arr[key];
                arr[key] = temp;
            }else{
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        sort(arr,start,j-1);
        sort(arr,j+1,end);
    }
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        input = new int[number];
        for(int i = 0 ; i < number ; i++){
            input[i] = scanner.nextInt();
        }
        sort(input, 0,input.length-1);
        System.out.println(Arrays.toString(input));
    }
}
