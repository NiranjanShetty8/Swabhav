package main

import (
	"fmt"
	"reflect"
)

func main() {
	marks := [3]int{10, 20, 30}
	modify(marks)
	fmt.Println(marks)
	fmt.Println(&marks)
	fmt.Println(reflect.TypeOf(&marks))
	modifyPointer(&marks)
	fmt.Println(marks)
	modifyTest(marks)
	fmt.Println("final: ", marks)

}

func modify(marks [3]int) {
	for i := 0; i < 3; i++ {
		marks[i] = 0
	}
}

func modifyPointer(marksPointer *[3]int) {
	for i := 0; i < 3; i++ {
		// marksPointer[i] = 0

	}
	fmt.Println("Hello")
	fmt.Println(marksPointer[0])
	fmt.Println("this", reflect.TypeOf(*marksPointer))
}

func modifyTest(marksPointer [3]int) {
	for i := 0; i < 3; i++ {
		marksPointer[i] = 0

	}
	fmt.Println("Hello")
	fmt.Println(marksPointer[0])
	// fmt.Println("this", reflect.TypeOf(*marksPointer))
}
