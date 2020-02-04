package main

import (
	"fmt"
	"strings"
)

func main() {
	// cannot use println
	// println(convertToUpper("swabhav", "techlabs"))
	fmt.Println(convertToUpper("swabhav", "techlabs"))

	state, city := convertToUpper("Maharashtra", "Mumbai")
	fmt.Println(state, city)

	bla, _ := convertToUpper("Maharashtra", "Mumbai")
	fmt.Println(bla)

	_, _ = convertToUpper("mah", "mum")

}

func convertToUpper(firstName, lastName string) (string, string) {
	return strings.ToUpper(firstName), strings.ToUpper(lastName)

}
