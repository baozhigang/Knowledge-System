package main

import (
	"fmt"
)

func main() {
	severalInts(1)
	severalInts(1, 2, 3)
	mix(1, true, "a", "b", "c")
}

func severalInts(numbers ...int) {
	fmt.Println(numbers)
}

func mix(num int, flag bool, strings ...string) {
	fmt.Println(num, flag, strings)
}
