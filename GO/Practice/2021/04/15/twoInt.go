package main

import (
	"fmt"
)

func main() {
	severalInts(1)
	severalInts(1, 2, 3)
}

func severalInts(numbers ...int) {
	fmt.Println(numbers)
}
