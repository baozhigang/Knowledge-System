import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
        String s = "abba";
        System.out.println(ls.lengthOfLongestSubstr(s));
    }

    public int lengthOfLongestSubstr(String s) {
        int n = s.length();
        if (s == "" || n <= 0) {
            return 0;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        int result = 1;

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0),0);

        for (int i = 1; i < n; i++) {
            Character character = s.charAt(i);
            if (!map.containsKey(character)) {
                arr[i] = arr[i-1] + 1;
                map.put(character,i);
            } else {
                // 如果map中存在，前面值加1和下标差值两者比较的最小值，这里是关键
                arr[i] = Math.min(i-map.get(character), arr[i-1]+1);
                map.replace(character,i);
            }
            if (arr[i] > result) {
                result = arr[i];
            }
        }

        return result;
    }
}
