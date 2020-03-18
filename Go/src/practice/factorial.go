package main

import "fmt"

func main() {
	fmt.Println(factorial(4))
}

// func factorial(i int) int {
// 	if i == 0 {
// 		return 1
// 	}
// 	return i * factorial(i-1)
// }

func factorial(i int) int {
	var result int = 1
	if i < 0 {
		fmt.Errorf("No")
	} else {
		for j := i; j > 0; j-- {
			result *= j
		}
	}
	return result
}
