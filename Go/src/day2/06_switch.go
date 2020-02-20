package main

import "fmt"

func main() {
	switch cgpa := 8; cgpa {
	case 8, 9, 10:
		fmt.Print("In 8,9,10")
	case 7:
		fmt.Print("In 7")
	case 6:
		fmt.Print("In 6")
	// case "hh":
	// 	fmt.Print("h")
	default:
		fmt.Print("No where")
	}

}
