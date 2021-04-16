package main

import "fmt"

func main() {
	fmt.Println(inRange(1, 100, -10, 3.2, 50, 103.5))
}

func inRange(min float64, max float64, numbers ...float64) []float64 {
	var result []float64
	for _, number := range numbers {
		if number >= min && number <= max {
			result = append(result, number)
		}
	}

	return result
}
