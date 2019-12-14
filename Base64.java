import java.util.Arrays;
import java.util.Scanner;

public class Base64 {
    private final static char [] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    static Scanner scan;
    static String encoded;
    static String decoded;

    static String encode(byte[] args){
        String result = new String("") ;
        int temp  = 0 ;
        int padding = 0;
        int paddingEquelCount = 0;
        int paddingCount = args.length % 3;
        if(paddingCount != 0 ){
            if(paddingCount == 1){

            }
        }
        for(int i = 0 ; i < args.length ; i++){
            if(i%3==0){
                temp = 0xfe;
                temp =  (temp & args[i]);
                result += CHARS[temp >> 2];
                padding = (args[i] & 0x03) <<4;
                if(i == args.length-1){
                    result+= CHARS[padding];
                    result += "==";
                }
            }else if(i%3==1){
                padding += (args[i] & 0xf0) >> 4;
                result += CHARS[padding];
                padding = (args[i] &0x0f) << 2;
                if(i==args.length-1){
                    System.out.println(padding);
                    result += CHARS[padding];
                    result += "=";
                }
            }else{
                padding += (args[i] & 0xe0) >> 6;
                result += CHARS[padding];
                padding =0;
                padding += (args[i] & 0x3f);
                result += CHARS[padding];
            }

        }
        return result;
    }

    public static String decode(byte[] args ){
        String result = new String("");
        int temp = 0;
        int padding = 0;
        int baseArgs =0;
        for(int i = 0 ; i < args.length ; i++){
            if((char)args[i] == '='){
                break;
            }
            baseArgs = new String(CHARS).indexOf((char)args[i]);

            System.out.println(baseArgs);
            if (i % 4 == 0) {
                padding = baseArgs << 2;
            }else if(i%4 ==1){
                temp =((0x30 & baseArgs)>>4) + padding;
                result += (char)temp;
                padding =(baseArgs & 0x0f) << 4;
            }else if (i % 4 == 2) {
                temp = ((baseArgs & 0x3c) >> 2) + padding;
                result +=  (char)temp;
                padding = (baseArgs & 0x03) << 6;
            }else if(i%4 ==3){
                temp = baseArgs + padding;
                result +=  (char)temp;
            }

        }
        return result;
    }
    public static void  main (String [] args){

        scan = new Scanner(System.in);
        int temp = 0;
        System.out.println("문자열 입력 : ");
        String string = scan.nextLine();
        encoded = encode(string.getBytes());
        System.out.println(encoded);
        decoded = decode(encoded.getBytes());
        System.out.println(decoded);




    }
}
