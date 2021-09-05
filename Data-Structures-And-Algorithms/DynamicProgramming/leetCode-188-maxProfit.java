/**
 * 注意边界条件
 * 买卖k次，第21行，买一次和卖一次算是一次
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k == 0 || n == 0) {
            return 0;
        }

        int[][][] dp = new int[n][k+1][2];
        for (int i=0; i<n; i++) {
            for (int j=1; j<=k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }

        return dp[n-1][k][0];
    }
}