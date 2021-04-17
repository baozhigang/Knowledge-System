package main

import (
	"fmt"
)

func main() {
	fmt.Printf("%#v\n", myStruct)
}

var myStruct struct {
	number float64
	word   string
	toggle bool
}
