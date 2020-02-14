package main

import "fmt"

type Name struct {
	firstName string
	lastName  string
}

type Customer struct {
	Name
	Balance float64
}

type Student struct {
	Name
	cgpa float64
}

func main() {
	c1 := Customer{Name{firstName: "Niranjan",
		lastName: "Shetty"}, 10000,
	}

	s1 := Student{Name: Name{
		"niru", "shetty",
	}, cgpa: 7.5}
	fmt.Println(c1)
	fmt.Println(s1)
}

// name1 := Name{
// 	"Niranjan",
// 	"shetty",
// }
