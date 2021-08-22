package main

import (
	"fmt"
)

func main() {
	arr := []int{20, 13, 11, 48, 9, 25, 50, 1, 14, 100, 40, 25}
	ret := quickSort(arr)
	fmt.Println(ret)
}
func quickSort(arr []int) []int {
	if len(arr) < 2 {
		return arr
	}
	base := arr[0]
	left := []int{}
	right := []int{}
	for i := 1; i < len(arr); i++ {
		if arr[i] < base {
			left = append(left, arr[i])
		} else {
			right = append(right, arr[i])
		}
	}
	left = quickSort(left)
	right = quickSort(right)

	return append(append(left, base), right...)
}
