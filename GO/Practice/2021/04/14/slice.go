package main

import (
	"fmt"
)

func main() {
	myArr := [5]string{"a", "b", "c", "d", "e"}
	i, j := 1, 4
	slice := myArr[i:j]
	fmt.Println(slice)
}
