package main

import "fmt"

type First func(int) int
type Second func(int) First

func squareSum(x int) Second {
	fmt.Println(x)
	return func(y int) First {
		fmt.Println(y)
		return func(z int) int {
			fmt.Println("this", z)
			return x*x + y*y + z*z
		}
	}
}

func main() {
	// 5*5 + 6*6 + 7*7
	fmt.Println(squareSum(5))
}
