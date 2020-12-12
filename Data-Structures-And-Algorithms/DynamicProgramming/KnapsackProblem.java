/**
 * 0-1背包问题算法的主要思想：
 * 利用动态规划来解决，每次遍历到的第i个物品，利用w[i]和val[i]来确定是否需要将该物品放入背包中。
 * 即对于给定的n个物品，设val[i]、w[i]分别为第i个物品的价值和重量，C为背包的容量，再令v[i][j]
 * 表示在前i个物品中能够装入容量为j的背包中的最大价值。
 * 计算公式：
 * 1）v[i][0]=v[0][i]=0; // 表示表格的第一行和第一列都是0
 * 2）当w[i]>j时，v[i][j]=v[i-1][j] // 当准备加入新增的商品的容量大于当前背包的容量时，就直接使用上一个单元格的装入策略
 * 3）当j>=w[i]时，v[i][j]=max{v[i-1][j], val[i]+v[i-1][j-w[i]]} // 当准备加入的新增商品容量小于等于当前背包剩余容量时
     在两者之间取最大值。v[i-1][j-w[i]] 装入i-1个商品时背包剩余容量的最大值。
 */

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};    // 物品的重量
        int[] val = {1500, 3000, 2000};   // 物品的价值
        int m = 4;              // 背包的重量
        KnapsackProblem kp = new KnapsackProblem();
        kp.knapsack(w, val, m);
    }

    /**
     * @param w 物品的重量
     * @param val 物品的价值
     * @param m 背包的重量
     * @return void
     */
    private void knapsack(int[] w, int[] val, int m) {
        // 物品的个数
        int n = val.length;
        // v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];
        // 定义一个二维数组记录放入商品的情况
        int[][] path = new int[n+1][m+1];

        // 初始化第一行和第一列
        for(int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for(int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        // 根据前面的公式来动态规划处理
        for(int i=1; i<v.length; i++) {
            for(int j=1; j<v[0].length; j++) {
                if (w[i-1] > j) {
                    v[i][j] = v[i-1][j];
                } else {
                    if (v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]) {
                        v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        printArr(v);
        System.out.println("==================");

        // 商品放入情况
        int i = path.length - 1;    // 行的最大下标
        int j = path[0].length - 1; // 列的最大下标
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n", i);
                j -= w[i-1];
            }
            i--;
        }
    }

    private void printArr(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
