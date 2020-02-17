package main

import "fmt"

func main() {
	f1()
	fmt.Println("End of Main")
}

func f1() {
	defer func() {
		panicDetails := recover()
		fmt.Println("In defer")
		fmt.Println("this: ", panicDetails)
	}()
	panic("Get me out of here")
	fmt.Println("End of f1")
}
