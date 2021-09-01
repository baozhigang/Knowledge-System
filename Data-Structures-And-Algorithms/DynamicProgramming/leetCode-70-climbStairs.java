class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int big = 2;
        int small = 1;
        int ans = 0;
        for (int i=3; i<=n; i++) {
            ans = big + small;
            small = big;
            big = ans;
        }
        return ans;
    }
}