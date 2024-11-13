package recursion.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity -> O(N * 2^N)
 * O(N) -> time taken to traverse N elements in the array
 * at each level the number of subsets increase to power of 2
 * so -> 2^N
 * and since this implementation is looped -> O(N * 2^N)
 * now -----
 * space complexity -> O(2^N *N)
 *  2^N -> total number of subsets, N-> size of subsets
 */
public class Subset {

    public static void main(String args[]){
        int[] arr = new int[]{1,2,2};
        List<List<Integer>> ans = subsetIterative(arr);
        for(List<Integer> list :  ans){
            System.out.println(list);
        }

    }

    public static List<List<Integer>> subsetIterative(int[] arr){
        //iterative implementation to find subset in an array

        // this is the final list
        ArrayList<List<Integer>> outer= new ArrayList<>();

        // initialise the list with an empty list
        outer.add(new ArrayList<>());



        /** traversing for each element in the array
         *  there are two possibilities for each element
         * 1. the element will be rejected
         * 2. the element will be accepted.
         * for eg. for 1
         * if rejected the ans - []
         * if accepted - [] +1= [1]
         * since [] already exists, only accepted case needs to be added
         * similarly for 2
         * existing cases are [], [1]
         *  if rejected -> it remains same
         *  if accepted -> [2], [1,2]
         *  so only accepted cases need to be added in the outer list
         */
        for(int nums:arr){
            int size = outer.size();
            // since the elements needs to be added in all existing list of answers
            // loop runs for the size of outer
           for(int i =0; i<size; i++){
               // creating a copy of outer list on i
               /**
                * for eg create a copy of [], [1]
                * add 2 in both for accepted case and add it to outer
                */
              List<Integer> internal =  new ArrayList<>(outer.get(i));
              internal.add(nums);
              outer.add(internal);
           }
        }

        return outer;
    }




}
