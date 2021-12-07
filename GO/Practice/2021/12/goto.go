package main

import (
	"fmt"
)

func main() {
	myfunc()
}

func myfunc() {
	i := 0
HERE:
	fmt.Println(i)

	i++
	if i < 10 {
		goto HERE
	}
}
