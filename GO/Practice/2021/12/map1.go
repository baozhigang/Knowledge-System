package main

import (
	"fmt"
)

type PersonInfo struct {
	ID      string
	Name    string
	Address string
}

func main() {
	personDB := make(map[string]PersonInfo)
	personDB["12345"] = PersonInfo{"130534", "zhangsan", "changping"}
	// delete(personDB, "12345")

	person, ok := personDB["12345"]
	if ok {
		fmt.Println("yes", person.ID, person.Name, person.Address)
	} else {
		fmt.Print("no")
	}
}
