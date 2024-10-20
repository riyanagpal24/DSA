package recursion.easy;

public class PrintN {

    // ques link - https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1

    static void printToN(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        printToN(n-1);
        System.out.print(" " + n );
    }



    public static void main(String args[]){

       printToN(10);
    }
}
