import java.util.*;

public class Triangle1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    public int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(2);
        triangle.add(item);

        ArrayList<Integer> item2 = new ArrayList<Integer>();
        item2.add(3);
        item2.add(4);
        triangle.add(item2);

        ArrayList<Integer> item3 = new ArrayList<Integer>();
        item3.add(6);
        item3.add(5);
        item3.add(7);
        triangle.add(item3);

        ArrayList<Integer> item4 = new ArrayList<Integer>();
        item4.add(4);
        item4.add(1);
        item4.add(8);
        item4.add(3);
        triangle.add(item4);

        System.out.println(triangle);

        Triangle1 triangle1 = new Triangle1();
        int ret = triangle1.minimumTotal(triangle);
        System.out.println(ret);
    }
}


