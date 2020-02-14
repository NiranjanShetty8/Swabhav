package main

import "fmt"

func main() {
	var anything interface {
	}

	anything = 10
	fmt.Printf("%T", anything)

	anything = "hello"
	fmt.Printf("\n%T", anything)

	anything = Student{Name: "Niranjan"}
	fmt.Printf("\n%T", anything)

	displayManyThings(10, 20, "hello", Student{Name: "Jay"})
}

type Student struct {
	Name string
}

func displayManyThings(elements ...interface{}) {
	for _, val := range elements {
		fmt.Println(val)
		if s, ok := val.(Student); ok {
			fmt.Println("Found Student", s.Name)
		}
	}
}
