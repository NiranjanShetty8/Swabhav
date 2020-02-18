package main

import "fmt"

func main() {
	ch := make(chan string, 1)
	ch <- "hello"
	fmt.Println(<-ch)
	ch <- "test"
	fmt.Println(<-ch)

	//Dead lock again as the size specified is 1
	ch <- "2test1"
	ch <- "2test2"

}
