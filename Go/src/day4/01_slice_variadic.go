package main

import "fmt"

func main() {
	nos := []int{10, 20, 30, 40, 50}
	// sum(nos...)
	fmt.Println(sum(nos...))
	marks := []int{60, 70, 80}
	nos = append(nos, marks...)
	fmt.Println(nos)
}

func sum(c ...int) int {
	fmt.Println(c)
	value := 0
	for _, val := range c {
		value = value + val
	}
	return value
}
