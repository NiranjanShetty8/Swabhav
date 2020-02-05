package main

import (
	"fmt"
)

func main() {
	marks := [3]int{10, 20, 30}
	fmt.Println(len(marks))
	fmt.Println(marks)

	for index, val := range marks {
		fmt.Println(index, val)
	}

	marksCopy := marks
	marksCopy[0] = 0
	fmt.Println(marks)
	fmt.Println(marksCopy)
}
