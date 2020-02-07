package main

import (
	"fmt"
)

func main() {
	var c movable = car{"BMW"}
	c.move()
}

type movable interface {
	move()
}

type car struct {
	name string
}

func (c *car) move() {
	fmt.Printf("Car %s is moving.", c.name)
}
