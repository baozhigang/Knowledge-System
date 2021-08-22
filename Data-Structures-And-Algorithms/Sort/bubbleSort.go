package main

import (
	"fmt"
)

func main() {
	arr := []int{20, 13, 11, 48, 9, 25, 50, 1, 14, 100, 40, 25}
	ret := bubbleSort(arr)
	fmt.Println(ret)
}

/**
 * 冒泡法：两个for循环完成排序
 * 外循环：循环1次，可以把最大的数移动到最末尾，循环2次，可以把第二大的数放到末尾第二位置，
 *         因此有多少个数，就循环比较多少次（减1次）
 * 内循环：两个数比较后位置对调，然后在与后面的数比较对调
 *         对调多少次，比如最大的数100需要对调多少次移动到最后，总数减去当时外循环的位置
 */
func bubbleSort(arr []int) []int {
	if len(arr) < 2 {
		return arr
	}

	var flag bool
	n := len(arr)
	for i := 0; i < n-1; i++ {
		for j := 0; j < n-1-i; j++ {
			if arr[j] > arr[j+1] {
				temp := arr[j]
				arr[j] = arr[j+1]
				arr[j+1] = temp
				flag = true
			}
		}
		if !flag {
			break
		} else {
			flag = false
		}
	}
	return arr
}
