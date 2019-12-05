import java.util.Arrays;
import java.util.Scanner;

public class Base64 {
    private static Scanner scan;
    static byte []  ASCIIbyte;
    static int  equalCount;
    static byte [] ASCIIdecodebyte;

    public static String byteArrayToBinaryString(byte[] b){
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<b.length; ++i){
            sb.append(byteToBinaryString(b[i]));
        }
        return sb.toString();
    }
    /*byte to 이진수 변환*/
    public static String byteToBinaryString(byte n) {
        StringBuilder sb = new StringBuilder("00000000");
        for (int bit = 0; bit < 8; bit++) {
            if (((n >> bit) & 1) > 0) {
                sb.setCharAt(7 - bit, '1');
            }
        }
        return sb.toString();
    }
    /*디코드*/
    public static String decodeByteArrayToBinaryString(byte[] b){
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<b.length; ++i){
            sb.append(decodeByteToBinaryString(b[i]));
        }
        return sb.toString();
    }
    /*byte to 이진수 변환*/
    public static String decodeByteToBinaryString(byte n) {
        StringBuilder sb = new StringBuilder("000000");
        int k = 0;

        if(n>=65 && n<=90) n = (byte)(n-65);
        else if(n>=97 && n<=122) n =(byte)(n-71);
        else if(n>=48 && n<=57)  n= (byte)(n+4);
        else if(n==43) n = (byte)(62);
        else if(n==47) n = (byte)(63);

        System.out.println(n);
        for (int bit = 0; bit < 6; bit++) {
            if (((n >> bit) & 1) > 0) {
                sb.setCharAt(5 - bit, '1');
            }
        }
        return sb.toString();
    }
    /*6bit to ASCII 변환*/
    public static char[] bit6ArrayToString(String[] str){
        char [] asc = new char[str.length];
        for(int i = 0 ; i < str.length ; i++){
            asc[i] = bit6ToString(str[i]);
        }
        return asc;
    }
    public static char bit6ToString(String n) {
        char temp ='0'-48;
        for(int i = 0 ; i <6 ; i++){
            temp += (n.toCharArray()[i]-48)*((Math.pow(2,5-i)));
        }
        if(temp >= 0 && temp<=25){
            temp += 65;
        }else if(temp >= 26 && temp <=51){
            temp += 71;
        }else if(temp >=52 && temp<=61){
            temp -= 4;
        }else if(temp == 62){
            temp -= 19;
        }else if(temp == 63){
            temp -=16;
        }


        return temp ;
    }
    /*8bit to ASCII 변환*/
    public static char[] bit8ArrayToString(String[] str){
        char [] asc = new char[str.length];
        for(int i = 0 ; i < str.length ; i++){
            asc[i] = bit8ToString(str[i]);
        }
        return asc;
    }
    public static char bit8ToString(String n) {
        char temp =0;
        for(int i = 0 ; i <8 ; i++){
            temp += (n.toCharArray()[i]-48)*((Math.pow(2,7-i)));
        }



        return temp ;
    }
    public static void  main (String [] args){

        scan = new Scanner(System.in);
        int temp = 0;
        System.out.println("문자열 입력 : ");
        String string = scan.nextLine();
        char[] ASCII = string.toCharArray();
        ASCIIbyte = new byte[ASCII.length];
        for(int i = 0 ; i <ASCII.length;i++){
            ASCIIbyte[i] = (byte) ASCII[i];
            System.out.println(ASCIIbyte[i]);
        }
        System.out.println(byteArrayToBinaryString(ASCIIbyte));
        String Binary = byteArrayToBinaryString(ASCIIbyte);
        if(Binary.length() %6 == 0){

        }else{

            temp = 6 - (Binary.length() % 6);
            for(int i = 0 ; i <temp ; i++){
                Binary = Binary.concat("0");
            }
            System.out.println(Binary);
        }
        String [] Binary6bit = new String[Binary.length()/6];
        for(int i = 0 ; i < Binary6bit.length ; i++){
            Binary6bit[i] = Binary.substring(i*6,(i+1)*6);
            System.out.println(Binary6bit[i]);
            //
        }
        char [] incoded = bit6ArrayToString(Binary6bit);

        char [] result = new char[incoded.length + temp/2];
        int j =0;
        for(j=0 ; j <incoded.length ; j++){
            result[j] = incoded[j];
        }
        for(;j<result.length;j++){
            result[j]  = 61;
        }
        System.out.println(result);
        // Decoder
        equalCount = 0;
        for(int i= 0; i<result.length ; i++){
            if(result[i] == '='){
                equalCount++;
            }
        }
        char [] notInequalArray = Arrays.copyOfRange(result,0,result.length-equalCount);
        System.out.println(notInequalArray);

        ASCIIdecodebyte = new byte[notInequalArray.length];

        for(int i =0 ;i <ASCIIdecodebyte.length ; i++){

            ASCIIdecodebyte[i] = (byte) notInequalArray[i]  ;
        }

        String temp1 = decodeByteArrayToBinaryString(ASCIIdecodebyte);
        System.out.println(temp1);

        String binaryDecode = temp1.substring(0, temp1.length()-(2*equalCount));

        System.out.println(binaryDecode);

        String [] binary8Byte = new String[binaryDecode.length()/8];

        for(int i = 0 ; i < binary8Byte.length; i++){
            binary8Byte[i] = binaryDecode.substring(i*8,(i+1)*8);
        }
        char [] decoded = bit8ArrayToString(binary8Byte);
        System.out.println(decoded);




    }
}
