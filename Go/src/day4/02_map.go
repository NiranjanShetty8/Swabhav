package main

import (
	"fmt"
)

func main() {
	ports := make(map[int]string)
	ports[80] = "http"
	ports[23] = "telnet"
	ports[443] = "https"
	ports[23] = "changed"

	for ind, val := range ports {
		fmt.Println(ind, " ", val)
	}
	delete(ports, 24)
	fmt.Println(ports)
}
