package main

import (
	"fmt"
)

func main() {
	intSlice := []int{1, 2, 3}
	severalInts(intSlice...)
	stringSlice := []string{"a", "b", "c"}
	mix(1, true, stringSlice...)
}

func severalInts(numbers ...int) {
	fmt.Println(numbers)
}

func mix(num int, flag bool, strings ...string) {
	fmt.Println(num, flag, strings)
}
