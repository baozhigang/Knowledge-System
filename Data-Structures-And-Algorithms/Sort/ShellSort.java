/*
 * @Description: 希尔排序
 * @Author: baozhigang
 * @Date: 2020-12-12 17:49:49
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 9, 6, 7, 2, 8, 3, 0};
        shellSort(arr);
        shellSort2(arr);
    }

    /**
     * 交换排序
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >=0 ; j -= gap) {
                    if (arr[j] > arr[j+gap]) {
                        temp    = arr[j];
                        arr[j]  = arr[j+gap];
                        arr[j+gap]= temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }


    /**
     *  移位排序，减少交换次数，效率更高
     */
    public static void shellSort2(int[] arr) {
        int temp = 0;
        for (int gap = arr.length/2; gap >0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j-gap]) {
                    while(j-gap >= 0 && temp < arr[j-gap]) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}