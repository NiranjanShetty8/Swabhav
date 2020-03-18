package main

import (
	"fmt"
)

func main() {
	a := []int{1, 2, 3}
	fmt.Println(plusOne(a))
}

func plusOne(digits []int) []int {
	var resultArray []int
	number := toInt(digits)
	numberCopy := number
	fmt.Println(number)
	multiple := 1
	noOfDigits := 0
	for {
		if numberCopy == 0 {
			break
		}
		numberCopy /= 10
		noOfDigits++
	}
	fmt.Print(noOfDigits)

	for i := 0; i < noOfDigits-1; i++ {
		multiple *= 10
	}
	fmt.Print(multiple)

	for {
		if multiple == 0 {
			break
		}
		resultArray = append(resultArray, number/multiple)
		number = number % multiple
		multiple /= 10
	}

	return resultArray
}

func toInt(digits []int) int {
	i := 1
	result := 0
	for j := len(digits) - 1; j >= 0; j-- {
		result += digits[j] * i
		i *= 10
	}
	return result + 1
}
