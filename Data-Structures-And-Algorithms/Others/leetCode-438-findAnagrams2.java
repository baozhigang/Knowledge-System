class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) return res;

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCnt, sCnt)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            sCnt[s.charAt(i) - 'a']++;
            sCnt[s.charAt(i-m) - 'a']--;
            if (Arrays.equals(pCnt, sCnt)) {
                res.add(i-m+1);
            }
        }
        return res;
    }
}