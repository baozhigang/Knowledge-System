import java.util.*;

public class Triangle3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
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

        Triangle3 triangle3 = new Triangle3();
        int ret = triangle3.minimumTotal(triangle);
        System.out.println(ret);
    }
}
