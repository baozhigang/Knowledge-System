class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ret = -1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if ((long)m * m <= x) {
                ret = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ret;
    }
}
