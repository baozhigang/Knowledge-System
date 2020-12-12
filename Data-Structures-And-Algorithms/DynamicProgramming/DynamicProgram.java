/**
 * 对一个整数数组，求不相邻的数相加的最大值
 * 分别用递归和动态规划求解：
 * 递归的代码更简洁，但是时间复杂度为O(n2)， 
 * 动态规划是把前面计算的结果存储在内存中（数组），避免了重复计算，
 * 时间复杂度是O(n)，执行效率大大提高。
 */

public class DynamicProgram {
    public static void main(String[] args) {
        int[] arr = {1,2,4,1,7,8,3};
        int dp = dp_opt(arr);
        System.out.println(dp);
        System.out.println("=============");
        int rec = rec_opt(arr, arr.length-1);
        System.out.println(rec);
    }

    // 递归
    public static int rec_opt(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int a = rec_opt(arr, i-2) + arr[i];
            int b = rec_opt(arr, i-1);
            return Math.max(a, b);
        }
    }

    // 动态规划
    public static int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i=2; i<arr.length; i++) {
            int a = opt[i-2] + arr[i];
            int b = opt[i-1];
            opt[i] = Math.max(a, b);
        }
        return opt[arr.length-1];
    }
}