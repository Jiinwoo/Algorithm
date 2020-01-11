import java.util.Scanner;
import java.util.Stack;

public class StackCalcurator {

    public static String postFix(String statement){
        String result = new String();
        char [] charArr = statement.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i <charArr.length ; i++){
            switch (charArr[i]){
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    while(!stack.empty()){
                        if(stack.peek()=='(' || stack.peek() == ')'){
                            stack.pop();
                            break;
                        }else{
                            result += stack.pop();
                        }
                    }
                    break;
                case '+':
                case '-':
                    if(stack.empty()){
                        stack.push(charArr[i]);
                    }else if(stack.peek() == '(' || stack.peek()==')'){
                        stack.push(charArr[i]);
                    }else{
                        result += stack.pop();
                        stack.push(charArr[i]);
                    }
                    break;
                case '*':
                case '/':
                    if(stack.empty()){
                        stack.push(charArr[i]);
                    }else if(stack.peek() == '+' || stack.peek() == '-'||stack.peek() == '(' || stack.peek()==')'){
                        stack.push(charArr[i]);
                    }else{
                        result += stack.pop();
                        stack.push(charArr[i]);
                    }
                    break;
                default :
                    result += charArr[i];
                    break;
            }
        }
        while(!stack.empty()){
                result += stack.pop();
        }

        System.out.println(result);
        return result;
    }

    public static int stackCalculator(String postFix){
        Stack<Integer> stack = new Stack<>();
        System.out.println(postFix);
        char [] charArr = postFix.toCharArray();
        for(int i = 0 ; i < charArr.length ; i++){
            if(charArr[i] == '+'){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1+num2);
            }else if(charArr[i] == '-'){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            }else if(charArr[i] == '*'){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1*num2);
            }else if(charArr[i] == '/'){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            }else{
                stack.push(Integer.parseInt(String.valueOf(charArr[i])));
            }

        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("식을 입력해주세요");
        Scanner sc = new Scanner(System.in);
        String statement = sc.next();
        String postStatement = postFix(statement);
        int Calculated = stackCalculator(postStatement);
        System.out.println(Calculated);
    }
}
