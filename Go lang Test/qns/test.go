package main

import "fmt"

func Add(num1, num2 float64) float64 {
	return num1 + num2
}

func Square(num1 float64) float64 {
	return num1 * num1
}

func DoShit(num float64) float64 {
	var sum float64
	// for _, num1 := range num {
	sqr := Square(num)
	sum += sqr
	// }
	return sum
}

type First func(i int) int

type Second func(i int) First

// func SquareSum(x int) Second  {

// }

func main() {
	// fmt.Println(DoShit(5, 10, 5))
	fmt.Println(DoShit(5)(10)(5))

}
