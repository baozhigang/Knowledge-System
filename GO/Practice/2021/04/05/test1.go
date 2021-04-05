package main

import ("fmt"
		"time"
		"strings"
)

func main() {
	var now time.Time = time.Now()
	var year int = now.Year()
	fmt.Println(year)

	broken := "G# r#cks!"
	replacer := strings.NewReplacer("#", "o")
	fix := replacer.Replace(broken)
	fmt.Println(fix)
}
