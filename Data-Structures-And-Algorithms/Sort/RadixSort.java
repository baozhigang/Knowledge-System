public static void RadixSort(int[] arr) {
    // 求最大元素的长度
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    int maxLength = (max + "").length();

    // 设置10个桶
    int[][] bucket = new int[10][arr.length];
    // 用来记录每个桶中放入元素的个数
    int[] bucketElementCount = new int[10];

    // 从个位数，到十位数，至更高位数依次 开始循环比较
    for (int i = 0, n=1; i < maxLength; i++, n *= 10) {
        // 放入桶中
        for (int j = 0; j < arr.length; j++) {
            int digitOfElement = arr[j] / n % 10;
            bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
            bucketElementCount[digitOfElement]++;
        }

        // 按顺序放回到原数组
        int index = 0;
        for (int k = 0; k < bucketElementCount.length; k++) {
            if (bucketElementCount[k] > 0) {
                for (int l = 0; l < bucketElementCount[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            // 每次循环使用后要回复初始值
            bucketElementCount[k] = 0;
        }

    }
    System.out.println(Arrays.toString(arr));

}