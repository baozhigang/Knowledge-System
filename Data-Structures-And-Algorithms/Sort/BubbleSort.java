/**
 * 为什么插入排序要比冒泡排序效率高？
 * 插入排序相比冒泡排序元素交换的次数是一样的，不过每一次元素交换时，插入排序只需要一次复制操作，
 * 而冒泡排序需要三次赋值操作，赋值操作上花费时间是插入排序的三倍。
 */

// 插入排序：
public static void insertSort(int[] arr) {
    // 空数组 或 只有一个元素的数组，则什么都不做。
    if (arr == null || arr.length == 0) return;
    // 外层循环的 i 代表有序区的最后一个元素。
    for (int i = 0; i < arr.length - 1; i++) {
        // 待插入的元素暂存到value.
        int value = arr[i + 1];
        int j = i;
        // j < 0 时退出循环，说明 j 是最小的元素的索引值。
        // 或者 arr[j] <= value 时退出循环，说明 j 是比value小的元素的索引值。
        for (; j >= 0 && arr[j] > value; j--) {
            // 把元素往后挪。
            arr[j + 1] = arr[j];
        }
        // 把待插入元素，放到正确位置。
        arr[j + 1] = value;
    }
}

// 冒泡排序：
public static void BubbleSort(int[] arr) {
    int temp;
    for(int i=0;i<arr.length-1;i++){//冒泡趟数
        for(int j=0;j<arr.length-i-1;j++){
            if(arr[j+1]<arr[j]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
