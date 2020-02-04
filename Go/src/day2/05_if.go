package main

import (
	"fmt"
)

func main() {
	if cgpa := 6; cgpa >= 8 {
		fmt.Print("Distinction")
	} else if cgpa >= 7 {
		fmt.Print("Not Bad")
	} else {
		fmt.Print("Try harder dabbu")
	}
	// can use cgpa only inside if as it is declared there
	// fmt.Print(cgpa)
}
