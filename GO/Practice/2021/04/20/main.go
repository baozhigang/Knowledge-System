package main

import (
	"fmt"
	"magazine"
)

func main() {
	subscriber := magazine.Subscriber{Name: "zhangsan"}
	subscriber.Street = "a new street"
	subscriber.City = "Omaha"
	fmt.Println("street:", subscriber.Address.Street)
	fmt.Println("city:", subscriber.Address.City)

	employee := magazine.Employee{Name: "lisi"}
	employee.Address.Street = "two new street"
	fmt.Println("street:", employee.Address.Street)
}
