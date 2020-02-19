package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
)

func main() {
	resp, _ := http.Get("http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students")
	fmt.Printf("%T", resp)
	fmt.Printf("%T", resp.Body)
	bs, _ := ioutil.ReadAll(resp.Body)

	fmt.Println()
	fmt.Println(len(bs))
	fmt.Println(string(bs))

	defer resp.Body.Close()
	fmt.Println("End of Main")
}
