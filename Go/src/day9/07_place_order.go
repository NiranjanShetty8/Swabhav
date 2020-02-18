package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())
	ch := make(chan int, 1)

	order1 := order{amount: 20}
	order2 := order{amount: 30}
	go placeOrder(&order1, ch)
	fmt.Println("Test")
	fmt.Println("Order Placed with Id", <-ch)
	go placeOrder(&order2, ch)
	fmt.Println("Order Placed with Id", <-ch)
	fmt.Println(order1)
	fmt.Println(order2)

}

func placeOrder(ord *order, ch chan int) {
	// ch := make(chan int)
	time.Sleep(1 * time.Second)
	ord.id = rand.Int()
	// fmt.Println(ord.id)
	ch <- ord.id
}

type order struct {
	amount int
	id     int
}
