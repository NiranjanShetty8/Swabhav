package main 

import (
	"fmt"
	"net/http"
	"ioutil"
)

type page struct {
	size int
	link string
}

func loadPageInfo(url string, ch chan page){
	resp,err := http.Get(url)
	if err != nil {
		fmt.Println(err)
	}
	bs,err := ioutil.
}

func (p *page)printDetails(){

}
func main()  {
	urls := []string{"http://www.google.com",
	"http://gsmktg.azurewebsites.net/api/v1/techlabs/test/students", "http://www.facebook.com"}

	// pag := Page{size: 20, link: "helo"}
	pageChannel := make(chan page);
	for _,url := range urls {
		loadPageInfo(url,pageChannel)

	}

	for i:=0;i<3;i++ {

	}

	
}