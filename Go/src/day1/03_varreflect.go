package main

import(
	"fmt"
	"reflect"
)

var(
	 name string
	 cgpa float64
	 rollNo int64
	 foo string
)

func main()  {
	fmt.Println("Type of name is ", reflect.TypeOf(name), "Value is : " ,name)
	fmt.Println("Type of cgpa is ", reflect.TypeOf(cgpa), "Value is: ", cgpa)
	fmt.Println("Type of roll no is : ", reflect.TypeOf(rollNo), "Value is : ", rollNo)
}