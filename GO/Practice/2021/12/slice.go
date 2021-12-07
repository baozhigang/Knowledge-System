package main

import (
	"fmt"
)

func main() {
	slice1 := []int{1, 2, 3, 4, 5}
	slice2 := []int{5, 4, 3}

	// copy(slice2, slice1)
	copy(slice1, slice2)
	for _, v := range slice1 {
		fmt.Println(v)
	}
}
