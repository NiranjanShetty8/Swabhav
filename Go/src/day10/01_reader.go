package main

import (
	"fmt"
	"net/http"
)

func main() {
	resp, _ := http.Get("http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students")
	// fmt.Printf("%T", resp)
	// fmt.Printf("%T", err)

	// Manually passing the byte
	fmt.Printf("%T", resp.Body)
	bs := make([]byte, 1*1024)

	resp.Body.Read(bs)
	fmt.Print(string(bs))
}
