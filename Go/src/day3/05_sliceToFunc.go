package main

import "fmt"

func main() {
	slice := []int{10, 20, 30, 40, 50, 60, 70, 80, 90}

	fmt.Println("before Modification ")
	fmt.Println(cap(slice))
	fmt.Println(&slice[0])
	slice = append(slice, 90, 100)
	fmt.Println("After Modification")
	fmt.Println(cap(slice))
	fmt.Println(&slice[0])
	slice = append(slice, 110, 120, 130, 140, 150, 160, 170)
	fmt.Println(&slice[0])
	// fmt.Println(*0xc00000a300)
	modify(slice)
	fmt.Println("After modify Function")
	fmt.Println(slice)
	// modify2(&slice)
	number := 20
	fmt.Println(&number)
	numberPointer := &number
	fmt.Println(numberPointer)
	modifyPtr(slice, numberPointer)
	fmt.Println("After experiment: ", slice)
}

func modify(slice []int) {
	fmt.Println("this", &slice[0])
	for i := range slice {
		slice[i] = 0
	}
}

func modifyPtr(slice []int, number *int) {
	for i := range slice {
		slice[i] = *number
	}
	fmt.Println("this is ", &slice[0])
	fmt.Println("this is ", &slice[1])
}
