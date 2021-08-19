import java.util.*;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0)-1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram ia = new IsAnagram();
        System.out.println(ia.isAnagram("abcddb", "dbcadb"));
    }
}
