

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            int j = i;
            dp[i + 1] = 1;
            while (j > 0) {
                if (nums[i] > nums[j - 1]) {
                    dp[i + 1] = Math.max(dp[j ] + 1, dp[i + 1]);
                }
                j--;
            }

            dp[i + 1] = Math.max(1 + dp[j], dp[i + 1]);
        }
        return dp[n];


    }
}