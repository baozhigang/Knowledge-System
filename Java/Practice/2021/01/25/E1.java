import java.util.*;

public class E1 {
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = new HashSet<>();
        guys.add("Tom");
        guys.add("John");
        guys.add("Jame");

        Set<String> animals = new HashSet<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Horse");

        Set<String> ret = union(guys, animals);
        System.out.println(ret);
    }
}
