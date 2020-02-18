package main

import "fmt"

func main() {
	//Deadlock
	ch := make(chan string)
	ch <- "Hello"

	fmt.Println(<-ch)
}
