package recursion.easy;

public class SortedArray {

    // to check if the array is sorted or not
    // duplicate values are allowed

    /**
     *  brute force approach
     *  linear search
     *  arr[i] <= arr[i+1]
     *  i++
     */

    /**
     *  through recursion
     *  1 2 3 4 5
     *  arr[i]<= arr[i+1] && rec(arr,i+1)
     */

    public static boolean isArraySorted(int[] arr, int ind){
        if(ind == arr.length-1) return true;
        return arr[ind]<=arr[ind+1] && isArraySorted(arr,  ind + 1);
    }

    public static void main(String args[]){
        int[] arr = {20,20,45,89,89,90};

        boolean isSorted = isArraySorted(arr, 0);
        System.out.print(isSorted);

    }
}
