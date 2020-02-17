package main

import "fmt"

func main() {
	defer func() {
		fmt.Println("Inside f defer")
	}()

	defer f2()

	fmt.Println("End of main")
}

func f2() {
	fmt.Println("Inside f2")
}
