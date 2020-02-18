package main

import "fmt"

func main() {
	func() {
		for i := 0; i < 100; i++ {
			fmt.Println("func1 ", i)
		}
	}()

	func() {
		for i := 0; i < 100; i++ {
			fmt.Println("func2 ", i)
		}
	}()

	go func() {
		for i := 0; i < 100; i++ {
			fmt.Println("func3 ", i)
		}
	}()

	fmt.Println("End of main")
	fmt.Scanln()
}
