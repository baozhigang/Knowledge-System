/**
 *  思路：
 * 1）选择排序有数组大小-1轮排序
 * 2）每一轮排序，又是一个循环，循环的规则：
 * 2.1）先假定当前数是最小数
 * 2.2）然后和后面的每个数进行比较，如果有更小的数，则重新确定最小数，并得到下标
 * 2.3）当遍历到数组的最后，就得到本轮最小数和下标
 * 2.4）交换
 
 * 代码：
 * 先写出最简单的第一次循环结果
 * 然后第二次、第三次，寻找规律
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5, 9, 1, 6};

        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int minindex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minindex = j;
                }
            }
            if (arr[i] > min) {
                arr[minindex]   = arr[i];
                arr[i]          = min;
            }

            System.out.println(Arrays.toString(arr));
        }

    }
}
