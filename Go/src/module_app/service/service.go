package service

import "fmt"

var (
	PORT = 8080
	URL  = "http://abc.com"
)

const (
	CLIENT = "CyberInc"
)

func init() {
	fmt.Println("Inside init of service")
	fmt.Println(PORT, URL, CLIENT)
}
