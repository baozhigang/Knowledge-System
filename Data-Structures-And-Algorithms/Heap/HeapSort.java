/**
 * 堆排序步骤：
 * 1）将无序序列构建一个堆，升序则大顶堆，降序则小顶堆  
 * 2）将堆顶元素与末尾元素交换，将最大元素沉到数组末尾
 * 3）重新调整结构，使其满足定义，反复执行调整+交换步骤，直到整个序列有序
 * 重点：
 * 要从最后一个非叶子节点开始排序
 */

public static void heapSort(int[] arr) {
    int temp = 0;
    // 循环调用，完成整个大顶堆
    for (int i = arr.length/2 -1; i>=0; i--) {
        adjustHeap(arr, i, arr.length);
    }

    // 交换顶端的值和最末端的值，然后排除最后一个值再次堆化处理，交换
    for (int j = arr.length-1; j>0; j--) {
        temp = arr[j];
        arr[j] = arr[0];
        arr[0] = temp;
        adjustHeap(arr, 0,  j);
    }
}

/**
* 完成以i为父节点的局部大顶堆
*  i对应的非叶子节点
*/
public static void adjustHeap(int[] arr, int i, int length) {
    int temp = arr[i];
    for (int k = 2*i+1; k<length; k = 2*k+1) {
        if (k+1 < length && arr[k] < arr[k+1]) { // 如果左节点小于右节点，则k指向右节点
            k++;
        }
        if (arr[k] > temp) {
            arr[i] = arr[k];  // 如果子节点大于父节点，则赋把子节点的值给到父节点
            i = k;            // i指向k，再循环去处理
        } else {
            break;
        }
    }

    arr[i] = temp;
}
