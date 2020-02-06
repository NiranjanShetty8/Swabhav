package main

import (
	"fmt"
)

func main() {
	ports := map[int]string{1: "string", 2: "integer"}
	fmt.Println(ports)
	// fmt.Println(&(ports[1]))  CANNOT FIND ADDRESS OF A MAP KEY AS IT IS DYNAMICALLY ALLOCATED
	modify(ports)
	fmt.Println(ports)

}

//Pass by reference
func modify(m map[int]string) {
	fmt.Println(&m)
	m[2] = "changed"
	m[3] = "changed2"
}
