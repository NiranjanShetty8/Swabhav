package main

import (
	"fmt"
	"net/http"
	"time"

	"github.com/gorilla/mux"
)

func getGreetings() string {
	t := time.Now()
	h, _, _ := t.Clock()
	// fmt.Println(h)
	if h < 6 && h > 21 {
		return "Good Night"
	} else if h < 12 {
		return "Good Morning"
	} else if h < 18 {
		return "Good Afternoon"
	} else {
		return "Good Evening"
	}
}

func IndexHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("index of mux app"))
}
func WelcomeMsgHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte(fmt.Sprintf("Welcome, to mux app: %s", getGreetings())))
}
func WelecomeHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte(fmt.Sprintf("Welcome %s, %s",
		r.URL.Query()["user"][0], getGreetings())))
}

func main() {
	r := mux.NewRouter()
	r.HandleFunc("/", IndexHandler)
	r.Path("/welcome").Queries("user", "{user}").HandlerFunc(WelecomeHandler)
	r.HandleFunc("/welcome", WelcomeMsgHandler)

	server := &http.Server{
		Handler:      r,
		Addr:         "127.0.0.1:8080",
		WriteTimeout: 10 * time.Second,
		ReadTimeout:  10 * time.Second,
	}
	server.ListenAndServe()
}
