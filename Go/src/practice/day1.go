package main

import (
	"fmt"
	"reflect"
)

func main() {
	var name string = "Mickey"
	var rollNo int64

	var (
		address, companyName string
		id                   int64
	)

	fmt.Println(reflect.TypeOf(rollNo))

	fmt.Println("this", name)
	fmt.Println(rollNo == 0)
	fmt.Println(address, companyName == "", id == 0)

	rollNo = 30
	address = "Kurla"
	companyName = "Swabhav"
	id = 101

	hobby := "gaming"

	fmt.Print(name)
	fmt.Print(rollNo)
	fmt.Print(address, companyName, id)
	fmt.Print(hobby)

}
