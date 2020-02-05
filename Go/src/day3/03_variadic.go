package main

import (
	"fmt"
)

func main() {
	sum(10, 20)
	sum(10, 20, 30)
	sum(10, 20, 30, 40, 50)
	max()
	max(60, 70)
}

func sum(a int, b int, c ...int) {
	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(c)
	// fmt.Printf("%T", c)
	for _, val := range c {
		fmt.Println("val is", val)
	}
}

func max(c ...int) {
	fmt.Println("inside")
	for _, val := range c {
		fmt.Println("val is", val)
	}
}
