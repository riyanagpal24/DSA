package recursion.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]){
        int[] arr = {5,4,3,2,1,8,9,7};

        mergeSort(arr,0,arr.length);
        System.out.print(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int start, int end){
        if(end-start==1){
            return;
        }
        int mid = start +(end - start)/2;

        // divide the array into two parts and sort them

        // dividing the array by mid element
        // calling sort on the left
        mergeSort(arr, start, mid);

        // calling sort on the right
        mergeSort(arr,mid,end);

        merge(arr,  start,  mid,  end);

    }

    private static void merge(int[] arr, int start, int mid, int end){
            int[] mix = new int[end-start];

            int i = start;
            int j = mid;
            int k=0;

            while(i<mid && j<end){
                if(arr[i]<arr[j]){
                    mix[k++]=arr[i++];
                }else{
                    mix[k++]=arr[j++];
                }
            }

            while(i<mid){
                mix[k++] = arr[i++];
            }

            while(j<end){
                mix[k++] = arr[j++];
            }

            for(int l=0; l<mix.length; l++){
                arr[start+l] = mix[l];
            }
    }
}
