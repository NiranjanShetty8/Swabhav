package main

import (
	"fmt"
	"math"
)

func DeciToBinary(num string) int {
	result := 0
	j := 0
	for i := len(num) - 1; i >= 0; i-- {
		power := math.Pow(2, float64(i))
		// fmt.Println(power)
		result += int(power) * (int(num[j]) - 48)
		// fmt.Println(result, string(num[j])
		j++
	}

	return result
}

func main() {
	fmt.Println(DeciToBinary("1010"))
}
