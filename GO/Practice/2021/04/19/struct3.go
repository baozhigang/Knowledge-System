package main

import "fmt"

type myStruct struct {
	myField int
}

func main() {
	var value myStruct
	value.myField = 3
	var pointer *myStruct = &value
	fmt.Println((*pointer).myField)
}
