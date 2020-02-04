package main

import (
	"fmt"
	"time"
)

func main() {
	// case1()
	case2()
}

func case1() {
	for {
		fmt.Println(time.Now())
	}
}

func case2() {
	for i := 0; i < 5; i++ {
		fmt.Println(time.Now())
	}
}
