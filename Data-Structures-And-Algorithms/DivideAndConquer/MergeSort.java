public class MergeSort {
    public static void main(String[] args) {
        int[] a = {8, 45, 43, 67, 23, 5, 3, 88, 55};
        System.out.println("排序前" + Arrays.toString(a));
        int[] ret = sort(a, 0, a.length-1);
        System.out.println("排序后" + Arrays.toString(ret));
    }

    public static int[] sort(int[] a, int low, int high) {
        int mid = (low + high)/2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid+1, high);
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i<=mid && j<=high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i<=mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j<=high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖原数组
        for (int x = 0; x < temp.length; x++) {
            a[x+low] = temp[x];
        }
    }
}