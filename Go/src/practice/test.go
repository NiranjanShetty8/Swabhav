package main

import (
	"fmt"
	"strings"
)

func main() {
	pass := "Hel lo"
	hashed := []byte(pass)
	fmt.Println(hashed)
	for i, h := range hashed {
		hashed[i] = h * 12
	}
	encrypted := string(hashed)
	fmt.Println(encrypted)

	result := strings.ReplaceAll(pass, " ", "")
	fmt.Println(result)
}
