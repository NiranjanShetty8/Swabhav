package main

import "fmt"

func main() {
	ch := make(chan string)
	go getData(ch)
	fmt.Println(<-ch)
}

func getData(ch chan string) {
	ch <- "hello"
}
