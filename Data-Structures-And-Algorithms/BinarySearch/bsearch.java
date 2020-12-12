/**
 * 循环实现 
 * 注意：1.low<=high，而不是 low<high  
 *      2.low和high更新 low=mid+1，high=mid-1 如果写成 low=mid 或者 high=mid，就可能会发生死循环
 */ 
public static int bsearch(int[] arr, int n, int value) {
    int low = 0;
    int high = n-1;

    while (low <= high) {
        int mid = low + (high-low)/2;

        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}


// 递归实现
public static int bsearch(int[] arr, int low, int high, int value) {
    if (low > high) return -1;

    int mid = low + (high-low)/2;
    if (arr[mid] == value) {
        return mid;
    } else if (arr[mid] > value) {
        return bsearch(arr, low, mid-1, value);
    } else {
        return bsearch(arr, mid+1, high, value);
    }
}
