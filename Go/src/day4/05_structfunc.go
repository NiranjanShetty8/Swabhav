package main

import (
	"fmt"
)

type Student struct {
	rollNo    int
	firstName string
	lastName  string
}

func main() {
	s := Student{rollNo: 101,
		firstName: "Niranjan",
		lastName:  "Shetty",
	}
	fmt.Println(&s.rollNo)
	modify(s)
	fmt.Println("After 1st modify: ", s)
	modifyRef(&s)
	fmt.Println("After ref modify", s)
	fmt.Println(&s.lastName)
}

//Pass by value
func modify(s Student) {
	fmt.Println("Memory location is :", &s.rollNo)
	(*(&s)).rollNo = 102
	s.firstName = "Abc"
	s.lastName = "xyz"
	fmt.Println(s)
}

//Pass by reference
func modifyRef(s *Student) {
	s.rollNo = 102
	s.firstName = "Abc"
	(*s).lastName = "xyz"
	fmt.Println(s)
}
