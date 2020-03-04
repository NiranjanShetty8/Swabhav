package main

import (
	"context"
	"fmt"
	"log"
	"net/http"
	"os"
	"os/signal"
	"time"

	"github.com/NiranjanShetty8/Swabhav/tree/master/go_other_apps/student_api_mux/controller"
	"github.com/gorilla/mux"
	// logger "github.com/sirupsen/logrus"
)

//Major changes needed
func main() {
	route := mux.NewRouter()
	if route == nil {
		log.Fatal("No router Created")
	}
	log.Info("Router Created")
	controller.RegisterRoutes(route)
	server := &http.Server{
		Handler:      route,
		WriteTimeout: 15 * time.Second,
		ReadTimeout:  15 * time.Second,
		Addr:         "127.0.0.1:8080",
	}
	var wait time.Duration

	go func() {
		log.Fatal(srv.ListenAndServe())
	}()

	ch := make(chan os.Signal, 1)

	signal.Notify(ch, os.Interrupt)

	<-ch

	ctx, cancel := context.WithTimeout(context.Background(), wait)
	defer cancel()
	srv.Shutdown(ctx)
	fmt.Println("Server ShutDown....")
	os.Exit(0)
}
