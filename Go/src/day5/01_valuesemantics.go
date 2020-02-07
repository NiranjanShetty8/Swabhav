package main

import (
	"fmt"
)

func main() {
	var p1 printable = customer{"abc", 101}
	// fmt.Println(&p1.id)
	p1.print()
	var p2 printable = &customer{"xyz", 202}
	p2.print()

}

type printable interface {
	print()
}

type customer struct {
	name string
	id   int
}

func (c customer) print() {
	fmt.Printf("ID is %d and name is %s \n", c.id, c.name)
}
