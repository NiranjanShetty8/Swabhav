package main

import (
	"fmt"

	"module_app/greeting"
	"module_app/greeting/hindi"
)

func main() {
	fmt.Println("test")
	fmt.Println(greeting.Hello())
	fmt.Println(hindi.Hello())
}
