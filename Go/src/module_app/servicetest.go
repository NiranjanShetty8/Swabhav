package main

import (
	"fmt"
	"module_app/service"
)

func main() {
	fmt.Print("In main ")
	fmt.Println(service.PORT, service.URL, service.CLIENT)
}

func init() {
	fmt.Print("In Init of service Test")
}
