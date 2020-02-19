package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
)

type Page struct {
	size int
	link string
}

func main() {
	urls := []string{"http://www.google.com",
		"http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students", "http://www.facebook.com"}
	pageChannel := make(chan Page)

	for _, url := range urls {
		go loadPageInfo(url, &pageChannel)
	}
	for i := 0; i < 3; i++ {
		channel := <-pageChannel
		channel.printInfo()
	}
}

func loadPageInfo(url string, ch chan *Page) {
	resp, _ := http.Get(url)
	bs, _ := ioutil.ReadAll(resp.Body)
	ch <- Page{size: len(bs), link: url}
}

func (pg *Page) printInfo() {
	fmt.Println(pg.size, pg.link)
}
