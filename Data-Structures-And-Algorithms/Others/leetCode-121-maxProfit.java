class Solution {
    public int maxProfit(int[] prices) {
        int diff = 0;
        int low = prices[0];
        for (int i=1; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            if (prices[i] - low > diff) {
                diff = prices[i] - low;
            }
        }
        return diff;
    }
}
