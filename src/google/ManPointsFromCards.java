package google;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 */
public class ManPointsFromCards {

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        System.out.println(maxScore(cardPoints,3));
    }

        public static int maxScore(int[] cardPoints, int k) {
            int sum = 0, n = cardPoints.length;
            for (int i = n - k; i < n; i++) {
                sum += cardPoints[i];
            }
            int ans = sum;
            for (int i = 0; i < k; i++) {
                sum += cardPoints[i] - cardPoints[n - k + i];
                ans = Math.max(ans, sum);
            }
            return ans;
        }

}
