package main

import (
	"fmt"
)

func main() {
	race([]movable{
		&car{"BMW"}, &truck{"MAHINDRA"}, &bike{"PULSAR"},
	})

}

func race(vehicles []movable) {
	fmt.Println("Race started")
	for _, v := range vehicles {
		fmt.Println()
		v.move()
	}
}

type movable interface {
	move()
}

type car struct {
	name string
}

type truck struct {
	name string
}

type bike struct {
	name string
}

func (c *car) move() {
	fmt.Printf("Car %s is moving.", c.name)
}

func (b *bike) move() {
	fmt.Printf("Bike %s is moving.", b.name)
}

func (t *truck) move() {
	fmt.Printf("Truck %s is moving.", t.name)
}
