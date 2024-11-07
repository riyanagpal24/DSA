package google;

import java.util.ArrayDeque;
import java.util.Deque;

public class longestAbsDiff {

    public static void main(String[] args) {
        int[] arr= {8,2,4,7};
        int res = longestSubarray(arr,4);
        System.out.println(res);
    }

    public static int longestSubarray(int[] arr, int l) {

        int i = 0; int j = 0;
        int ret = 0;
        Deque<Integer> q1 =  new ArrayDeque<>(); //incre
        Deque<Integer> q2 =  new ArrayDeque<>(); //decre

        for (; j< arr.length; j++) {

            // keep queue in asc order
            while (!q1.isEmpty() && arr[q1.peekLast()] > arr[j])
                q1.pollLast();

            q1.offerLast(j);

            // keep queue in des order
            while (!q2.isEmpty() && arr[q2.peekLast()] < arr[j])
                q2.pollLast();

            q2.offerLast(j);


            while(arr[q2.peekFirst()] - arr[q1.peekFirst()] > l) {

                // move i to right to adjust the window when the condition is KO
                // if arr[i] is index of max or min value  of queues, need to remove in queue before move i

                if(q2.peekFirst() == i) q2.pollFirst();
                if(q1.peekFirst() == i) q1.pollFirst();

                i++;
            }

            ret = Math.max(ret,  j-i+1);
        }
        return ret;
    }
}
