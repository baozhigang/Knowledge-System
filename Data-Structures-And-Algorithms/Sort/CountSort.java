public static void countSort(int[] arr) {
    int[] result = new int[arr.length];
    int[] count = new int[6]; // 数组大小为原数组最大元素大小+1

    for (int i=0; i<arr.length; i++) {
        count[arr[i]]++;
    }

    for (int i = 0, j=0; i < count.length; i++) {
        while (count[i]-- >0) result[j++] = i;
    }
}
