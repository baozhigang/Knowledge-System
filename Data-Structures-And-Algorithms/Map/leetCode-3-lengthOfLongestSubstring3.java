import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
        String s = "abba";
        System.out.println(ls.lengthOfLongestSubstr(s));
    }

    // 滑动窗口算法
    public int lengthOfLongestSubstr(String s) {
        int l = 0, r = 0, max = 0;
        Set<Character> set = new HashSet<Character>();

        while(r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}
