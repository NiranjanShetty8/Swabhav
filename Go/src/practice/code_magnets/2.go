package main

import (
	"fmt"
	"log"
	"os"
)

func main() {
	fileInfo, err := os.Stat("my.txt")
	if err != nil {
		log.Fatal("this", err)
	}
	fmt.Println(fileInfo.Size())
}
