package main

import "fmt"
import "reflect"

func main() {
	var myInt int = 5
	fmt.Println(reflect.TypeOf(myInt))
	fmt.Println(reflect.TypeOf(float64(myInt)))
}
