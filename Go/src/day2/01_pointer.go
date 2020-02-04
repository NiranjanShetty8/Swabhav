package main

import (
	"fmt"
	"reflect"
)

func main() {
	// case1()
	case2()

}

func case1() {
	name := "Swabhav"
	fmt.Println(reflect.TypeOf(name))
	fmt.Println(reflect.TypeOf(&name))
	fmt.Println(&name)
	pointerToName := &name
	fmt.Println(pointerToName)
	fmt.Println(reflect.TypeOf(pointerToName))
	fmt.Println(&pointerToName)
	fmt.Println(*pointerToName)
}

func case2() {
	mark := 10
	pointerToMark := &mark
	pointerToPointer := &pointerToMark
	fmt.Println(*pointerToMark)
	fmt.Println(*pointerToPointer)
	fmt.Println(&pointerToPointer)
	fmt.Println(*pointerToPointer == pointerToMark)
	fmt.Println(**pointerToPointer == mark)
	fmt.Println(pointerToPointer == &pointerToMark)
}
