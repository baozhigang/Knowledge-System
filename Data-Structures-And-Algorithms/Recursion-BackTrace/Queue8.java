public class Queue8 {
    int max = 8;
    static int judgeCount = 0;
    static int count = 0;
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queue8 q8 = new Queue8();
        q8.check(0);
        System.out.printf("算法有%d种", count);
        System.out.println();
        System.out.println("判断次数：" + judgeCount);
    }

    // 放置皇后
    public void check(int n) {
        if (n == max) { // 放完了
            print();
            count++;
            return;
        }
        // 循环放置到每一列
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) { // 不冲突则递归放置下一个皇后
                check(n+1);
            }
        }
    }

    // 判断是否冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 在同一列或者行数差等于列数差，则为冲突
            if (arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
