package main

import (
	"fmt"
)

type Student struct {
	firstName string
	lastName  string
	rollNo    int
}

func main() {
	s1 := Student{firstName: "abc", lastName: "xyz", rollNo: 101}
	fmt.Println(s1)
	s1.modify()
	fmt.Println("After first modify: ", s1)
	s1.modifyRef()
	fmt.Println("After ref modify : ", s1)
}

func (this Student) modify() {
	this.rollNo = 202
}

func (this *Student) modifyRef() {
	this.rollNo = 303

}
