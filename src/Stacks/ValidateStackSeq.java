package Stacks;

import java.util.Stack;

/**
 * leetcode - https://leetcode.com/problems/validate-stack-sequences/description/
 */

public class ValidateStackSeq {

    public static void main(String args[]){

        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};
        System.out.print(validateStackSequences(pushed,popped));

    }

        public static boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> sample = new Stack<>();
            int i=0;
            int j=0;
            while(i<pushed.length){
                if(!sample.isEmpty() && popped[j] == sample.peek()){
                    sample.pop();
                    j++;
                }else{
                    sample.push(pushed[i]);
                    i++;
                }

            }

            while(j < popped.length){
                if(sample.pop() == popped[j]){
                    j++;
                }else{
                    return false;
                }
            }

            return true;
        }

}
