package recursion.easy;


class MinMaxInArray {
    //ques link - https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/

    // function to return minimum element using recursion
    public static int findMinRec(int A[], int ind)
    {
        // if size = 0 means whole array
        // has been traversed
        if(ind >= A.length)
            return A[A.length-1];

        return Math.min(A[ind], findMinRec(A, ind+1));
    }

    public static int findMaxRec(int A[], int ind)
    {
        // if size = 0 means whole array
        // has been traversed
        if(ind >= A.length)
            return A[A.length-1];

        return Math.max(A[ind], findMaxRec(A, ind+1));
    }



    // Driver code
    public static void main(String args[])
    {
        int A[] = {1, 4, 45, 6, 10, -8};
        int n = A.length;

        // Function calling
        System.out.println(findMinRec(A, 0));
        System.out.println(findMaxRec(A, 0));
    }
}


