import java.util.*;

public class Test {
    public static void main(String[] args) {

    }

    static List<Integer> inArrayAsList(int[] a) {
        Objects.requireNonNull(a);
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i];
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;
                return oldVal;
            }

            @Override
            public int size() {
                return a.length;
            }
        }
    }
}
