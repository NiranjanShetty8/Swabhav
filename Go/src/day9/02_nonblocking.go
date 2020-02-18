package main

// CONCURRENCY

import (
	"fmt"
	"time"
)

func main() {
	go func() {
		time.Sleep(3 * time.Second)
		fmt.Println("Inside f1 after 3 seconds")
	}()

	go func() {
		fmt.Println("Inside F2")
	}()
	fmt.Println("End of main")
	// fmt.Scanln()
	func() {
		time.Sleep(3 * time.Second)
		fmt.Println("Inside Decoy timer.")
	}()

}
