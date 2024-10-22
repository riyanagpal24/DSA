package recursion.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSeqWithDuplicates {

    /**
     * 1. when you find a duplicate element, only add the element in the previously created subset
     * 2. because of above point, duplicates have to be adjacent. - so array needs to be sorted.
     */

    public static List<List<Integer>> subsetIterativeForDuplicates(int[] arr){
        //iterative implementation to find subset in an array
        Arrays.sort(arr);

        // this is the final list
        ArrayList<List<Integer>> outer= new ArrayList<>();

        // initialise the list with an empty list
        outer.add(new ArrayList<>());
        int start;
        int end = 0;

        for(int j=0; j<arr.length; j++){
            // initialising it with zero by default
            start = 0;
            int size = outer.size();


            // check if current element is duplicate
            // update start to the value where the last element started inserting from
            if(j>0 && arr[j]==arr[j-1]){
                start = end +1;
            }
            // end - the index of last element in the outer list
            // before this elements starts the insertion
            end = size-1;

            // since the elements needs to be added in all existing list of answers
            // loop runs for the size of outer
            for(int i =start; i<size; i++){
                // creating a copy of outer list on i
                List<Integer> internal  =  new ArrayList<>(outer.get(i));
                internal.add(arr[j]);
                outer.add(internal);
            }
        }

        return outer;
    }


    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,2};
        List<List<Integer>> ans = subsetIterativeForDuplicates(arr);
        for(List<Integer> list :  ans){
            System.out.println(list);
        }

    }
}
