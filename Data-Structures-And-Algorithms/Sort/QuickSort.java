public static void quickSort(int[] arr, int low, int high) {
    // 递归设置终止条件，当只有一个元素时
    if (low >= high) {
        return;
    }
    int i, j, tmp, t;
    i = low;
    j = high;
    // 设置基准位
    tmp = arr[low];

    while (i < j) {
        // 先从右边比较，满足条件则向左移动
        while (arr[j] >= tmp && i<j) {
            j--;
        }
        // 从左边比较，满足条件则向右移动
        while (arr[i] <= tmp && i<j) {
            i++;
        }
        // 上面2个while条件都不满足时，交换左右数据
        if (i<j) {
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
    }
    // i==j时，和基准位交换位置
    arr[low] = arr[i];
    arr[i] = tmp;
    quickSort(arr, low, i-1);
    quickSort(arr,i+1, high);
}
