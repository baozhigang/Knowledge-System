package main

import (
	"fmt"
)

func main() {
	fmt.Println()
}

func twoSum(nums []int, target int) []int {
	table := map[int]int{}
	for i, x := range nums {
		if p, ok := table[target-x]; ok {
			return []int{p, i}
		}
		table[x] = i
	}
	return nil
}
