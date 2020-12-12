/**
 * 桶排序思路：
 *
 * 1.找出待排序数组中的最大值max、最小值min
 * 2.我们使用 动态数组ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为(max-min)/arr.length + 1
 * 3.遍历数组 arr，计算每个元素 arr[i] 放的桶（根据商相等取得相近元素放入一个桶中）
 * 4.每个桶各自排序
 * 5.遍历桶数组，把排序好的元素放进输出数组
 */

 public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 9};
        bucketSort(arr);
    }

    public static void bucketSort(int[] arr) {
        // 找出最大值和最小值
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        // 创建桶的初始值
        int buckedNum = (max - min)/arr.length + 1;
        ArrayList<ArrayList<Integer>> buckedArr = new ArrayList<>(buckedNum);
        for (int i = 0; i < buckedNum; i++) {
            buckedArr.add(new ArrayList<>());
        }

        // 数组元素放入不同的桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / arr.length;
            buckedArr.get(num).add(arr[i]);
        }

        // 每个桶内元素自排序后，依次放入到新数组中
        int index = 0;
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < buckedNum; i++) {
            Collections.sort(buckedArr.get(i));

            for (int j = 0; j < buckedArr.get(i).size(); j++) {
                sortedArr[index++] = buckedArr.get(i).get(j);
            }
        }

        System.out.println(Arrays.toString(sortedArr));
    }
}
