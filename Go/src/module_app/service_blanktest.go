package main

import (
	"fmt"
	_ "module_app/service" // Only init method will be invoked of the mentioned package.
)

func main() {
	fmt.Print("In Main")

}

func init() {
	fmt.Println("Inside init of blanktest")
}
