import java.util.*;

public class Generate {
    public List<String> ga(int n) {
        List<String> result = new ArrayList<>();
        gb("", result, n, n);
        return result;
    }

    public void gb(String sublist, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sublist);
            return;
        }
        if (left > 0) {
            gb(sublist + "(", result, left-1, right);
        }
        if (right > left) {
            gb(sublist + ")", result, left, right-1);
        }
    }

    public static void main(String[] args) {
        Generate g = new Generate();
        System.out.println(g.ga(3));
    }
}
