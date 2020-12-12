/**
 * 插入排序思路：
 * 1）把n个待排序的元素看成一个有序列表和一个无序列表
 * 2）开始时有序列表只有1个元素，无序列表有n-1个元素
 * 3）排序时每次从无序表中取出第一个元素，依次与有序表中的元素进行比较，并插入到适当的位置 
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {13, 3, 303, 105};
        InsertSort(arr);
    }

    public static void InsertSort(int[] arr) {
        int insertValue = 0;
        int inserIndex  = 0;

        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            inserIndex = i-1;

            while (inserIndex >= 0 && insertValue < arr[inserIndex]) {
                arr[inserIndex+1] = arr[inserIndex];
                inserIndex --;
            }

            if (inserIndex+1 != i) {
                arr[inserIndex+1] = insertValue;
            }

            System.out.println(Arrays.toString(arr));
        }
    }
}
