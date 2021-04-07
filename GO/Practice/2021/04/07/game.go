package main

import (
	"fmt"
	"bufio"
	"log"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"time"
)

func main() {
	seconds := time.Now().Unix()
	rand.Seed(seconds)
	target := rand.Intn(100) + 1
	fmt.Println("Can you guess, 1 beteen 100")

	reader := bufio.NewReader(os.Stdin)
	success := false
	for guesses := 0; guesses < 10;  guesses ++ {
		fmt.Println("You have ", 10 - guesses, " guesses left ")
		fmt.Println("Make a guess")
		input, err := reader.ReadString('\n')
		if err != nil {
			log.Fatal(err)
		}

		input = strings.TrimSpace(input)
		guess, err := strconv.Atoi(input)
		if err != nil {
			log.Fatal(err)
		}

		if guess < target {
			fmt.Println("LOW")
		} else if guess > target {
			fmt.Println("High")
		} else {
			success = true
			fmt.Println("Good Job")
			break
		}
	}

	if !success {
		fmt.Println("Sorry, It was: ", target)
	}
}