package main

import "fmt"

func main() {
	f1()
	fmt.Println("End of main")
}

func f1() {
	defer func() {
		fmt.Println("Inside f1 defer")
	}()
	fmt.Println("Inside f1")
	f2()

}

func f2() {
	defer func() {

		fmt.Println("Inside f2")
	}()
}
