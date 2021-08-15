package main

import (
	"fmt"
	"sort"
)

func main() {
	nums := []int{-1, 0, 1, 2, -1, -4}
	fmt.Println(threeSum(nums))
}

func threeSum(nums []int) [][]int {
	n := len(nums)
	sort.Ints(nums)
	ans := make([][]int, 0)

	// c对应的指针初始值指向数组的最右端
	third := n - 1

	// 枚举a
	for first := 0; first < n; first++ {
		// 需要和上一次枚举的数不同
		if first > 0 && nums[first] == nums[first-1] {
			continue
		}
		target := -1 * nums[first]

		// 枚举b
		for second := first + 1; second < n; second++ {
			// 要和上次枚举的数不相同
			if second > first+1 && nums[second] == nums[second-1] {
				continue
			}
			// 保证b指针在c指针左侧
			for second < third && nums[second]+nums[third] > target {
				third--
			}
			// 如果指针重合，随着b继续增加，就不会再满足a+b+c=0,且b<c了，退出b的循环，继续循环a
			if second == third {
				break
			}
			if nums[second]+nums[third] == target {
				ans = append(ans, []int{nums[first], nums[second], nums[third]})
			}
		}
	}
	return ans
}
