package main

import (
	"fmt"
	"net/http"
)

func main() {
	// resp, _ := http.Get("http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students")
	resp, _ := http.Get("www.google.com")
	// fmt.Printf("%T", resp)
	fmt.Println(resp)
	// fmt.Println(resp)

	// Manually passing the byte
	// fmt.Println(resp.Body)
	// fmt.Printf("%T", resp.Body)
	// bs := make([]byte, 1*1024)

	// resp.Body.Read(bs)
	// fmt.Print(string(bs))
}
