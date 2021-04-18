package main

import "fmt"

type subscriber struct {
	name   string
	rate   float64
	active bool
}

func printInfo(s subscriber) {
	fmt.Println("name: ", s.name)
	fmt.Println("rate: ", s.rate)
	fmt.Println("active: ", s.active)
}

func defaultSubscriber(name string) subscriber {
	var s subscriber
	s.name = name
	s.rate = 1.23
	s.active = true
	return s
}

func main() {
	subscriber1 := defaultSubscriber("zhangsan")
	subscriber1.rate = 4.99
	printInfo(subscriber1)

	subscriber2 := defaultSubscriber("lisi")
	printInfo(subscriber2)
}
