package main

import (
	"fmt"
	"time"
)

func main() {
	fmt.Println("Inside Main")
	func() {
		time.Sleep(3 * time.Second)
		fmt.Println("Func1 after 3 seconds")
	}()

	func() {
		fmt.Println("Inside function f2")
	}()
	fmt.Println("End of Main")
}
