import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
        String s = "abba";
        System.out.println(ls.lengthOfLongestSubstr(s));
    }

    public int lengthOfLongestSubstr(String s) {
        int left = 0;
        int max = 0;

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                left = Math.max(map.get(character)+1, left);
            }
            map.put(character,i);
            max = Math.max(i-left+1, max);
        }

        return max;
    }
}
