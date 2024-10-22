package recursion.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String args[]){
        int[] arr = {1,2,4,9,54,32,22,4};

        quickSort(arr,0,arr.length-1);
        System.out.print(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int high){
        if(low>=high) return;

        // track of the indices
        int s = low;
        int e = high;
        int mid =  (s + e)/2;

        int pivot = arr[mid];

        while(s<e){
            // no shifting -  elements smaller than pivot on the left
            while(arr[s] < pivot){
                s++;
            }
            // no shifting -  elements greater than pivot on the right
            while(arr[e] > pivot){
                e--;
            }
            if(s<e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }

        // after while is complete arr[mid] is at it's sorted position
        // now we need to sort the left to mid and right to mid
        quickSort(arr,low,mid-1);
        quickSort(arr,mid+1,high);

    }
}
