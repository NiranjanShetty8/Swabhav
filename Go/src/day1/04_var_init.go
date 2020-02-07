package main

import (
	"fmt"
)

func main() {
	var (
		name, cgpa, rollNo = "Niranjan", 7.5, 1001
		foo                = "bar"
	)
	fmt.Println(&foo)
	foo = modifyFoo(foo)
	//Address of the string remains the same even if changes are made.
	fmt.Println(&foo)
	fmt.Println(foo)
	fmt.Println("The name is :", name)
	fmt.Println("The cgpa is :", cgpa)
	fmt.Println("The roll no is: ", rollNo)

}

//Pass by value ... Changes when you return and save

func modifyFoo(s string) string {
	s = s + "hello"
	return s
}
