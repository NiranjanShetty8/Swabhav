package main

import (
	"fmt"
	"reflect"
)

type Student struct {
	rollNo    int
	firstName string
	lastName  string
}

func main() {
	s1 := Student{rollNo: 101,
		firstName: "Niranjan",
		lastName:  "Shetty",
	}
	fmt.Println(s1)
	s2 := s1
	s2.rollNo = 102
	fmt.Println(&s2)
	fmt.Println(&s1)
	fmt.Printf("Type is %T\n", s1)
	fmt.Println(reflect.TypeOf(s1))
	strucPointerModify(s1)
}

func strucPointerModify(s Student) {
	fmt.Println(s.firstName, s.lastName, s.rollNo)

}
