package google.easy;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] op = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(op));
    }

    public static int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("C")){
                stack.pop();
            }
            else if(operations[i].equals("D")){
                Integer num = Integer.parseInt(stack.peek());
                stack.push( String.valueOf(num*2));
            }
            else if(operations[i].equals("+")){
                Integer num = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.peek());
                stack.push( String.valueOf(num));
                Integer sum = num + num2;
                stack.push( String.valueOf(sum));
            }else{
                stack.push(operations[i]);
            }
        }

        Integer sum =0;
        while(!stack.empty()){
            sum += Integer.parseInt(stack.pop());
        }
        return sum;
    }
}
