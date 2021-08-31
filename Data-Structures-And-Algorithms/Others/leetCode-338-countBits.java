class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for(int i=0; i<=n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int n) {
        int ret = 0;
        while (n > 0) {
            if ((n&1) != 0) {
                ret++;
            }
            n >>>= 1;
        }
        return ret;
    }
}
