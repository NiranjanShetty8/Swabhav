package main

import (
	"fmt"
	"reflect"
)

func main() {
	case1()
	case2()
}

func case1() {
	mark := 10
	fmt.Println(reflect.TypeOf(mark))
	changeMark(mark)
	fmt.Println("Value remains: ", mark)

}

func changeMark(mark int) {
	mark = 0
}

func case2() {
	score := 100
	changeScore(&score)
	fmt.Println("value changes to :", score)

}

func changeScore(s *int) {
	*s = 0
}
