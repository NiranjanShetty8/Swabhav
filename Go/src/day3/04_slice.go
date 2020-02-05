package main

import (
	"fmt"
)

func main() {
	// case1()
	case2()
}

func case1() {
	slice := make([]int, 3, 4)
	slice[0] = 10
	slice[1] = 20
	slice[2] = 30
	// fmt.Printf("value of capacity %v\n", cap(slice))
	// fmt.Printf("value of size %v\n", len(slice))
	// fmt.Printf("Value of address of 0th element: %v\n", &slice[0])
	slice = append(slice, 40, 50, 60)
	// fmt.Printf("value of capacity %v\n", cap(slice))
	// fmt.Printf("value of size %v\n", len(slice))
	// fmt.Printf("Value of address of 0th element: %v\n", &slice[0])
	slice = append(slice, 70)
	fmt.Printf("value of capacity %v\n", cap(slice))
	fmt.Printf("value of size %v\n", len(slice))
	fmt.Printf("Value of address of 0th element: %v\n", &slice[0])

	pointerToSlice := slice

	fmt.Printf("value of capacity %v\n", cap(pointerToSlice))
	fmt.Printf("value of size %v\n", len(pointerToSlice))
	fmt.Printf("Value of address of 0th element: %v\n", &pointerToSlice[0])

	pointerToSlice = append(slice, 80, 90, 100)
	fmt.Printf("value of capacity %v\n", cap(pointerToSlice))
	fmt.Printf("value of size %v\n", len(pointerToSlice))
	fmt.Printf("Value of address of 0th element: %v\n", &pointerToSlice[0])
}

func case2() {
	slice := []int{10, 20}
	slicePointer := slice
	// Will change the address of Array
	slice = append(slice, 30, 40, 50)
	slice[0] = 0
	fmt.Println(slice[0])

	// still points to the previous address
	fmt.Println(slicePointer[0])
}
