package main

import (
	"fmt"
)

func main() {
	amount := 6
	fmt.Println(amount)
	fmt.Println(&amount)

	amount2 := &amount
	fmt.Println(amount2)
	fmt.Println(*amount2)
}