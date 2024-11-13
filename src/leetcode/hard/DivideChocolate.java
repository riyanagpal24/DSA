package leetcode.hard;

public class DivideChocolate {

    public static void main(String[] args) {
        int[] sweetness = {1,2,2,1,2,2,1,2,2};
        System.out.println(findMinMaxSweetness(sweetness,2));
    }


    private static int findMinMaxSweetness(int[] arr, int k){
        if(k+1 == arr.length){
            return 1;
        }
        int min = arr[0];
        int max = 0;
        for(int num: arr){
            max += num;
        }


        while(min<max){
            // adding on so in case of odd mid it rounds up to upper bound always
            int mid = min + 1+ (max-min)/2;
            int count = countPieces(arr, mid);
            if(count>k){
                min = mid;
            }else{
                max = mid-1;
            }
        }

        return min;
    }

    private static int countPieces(int[] arr, int target){
        int sum = 0;
        int count = 0;
        for(int num: arr){
            if(sum+num>=target){
                sum = 0;
                ++count;
            }
            else{
                sum += num;
            }
        }
        return count;
    }
}
