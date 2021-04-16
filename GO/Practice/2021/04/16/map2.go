package main

import (
	"fmt"
)

func main() {
	var ok bool
	counter := map[string]int{"a": 3, "b": 0}
	_, ok = counter["a"]
	fmt.Println(ok)
	_, ok = counter["b"]
	fmt.Println(ok)
	_, ok = counter["c"]
	fmt.Println(ok)
}
