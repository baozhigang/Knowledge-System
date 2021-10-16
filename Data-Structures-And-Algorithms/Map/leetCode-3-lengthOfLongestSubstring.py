class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        ans = 0
        d = {}
        for k, t in enumerate(s):
            if t in d:
                left = max(d[t]+1, left)
            d[t] = k
            ans = max(ans, k-left+1)

        return ans
