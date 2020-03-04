package main

import (
	"context"
	"fmt"
	"log"
	"net/http"
	"os"
	"os/signal"
	"studentAPI_mux_app/controller"
	"time"

	"github.com/gorilla/handlers"
	"github.com/gorilla/mux"
	// logger "github.com/sirupsen/logrus"
)

func main() {
	route := mux.NewRouter()
	if route == nil {
		log.Fatal("No router Created")
	}
	fmt.Println("Router Created")
	controller.RegisterRoutes(route)
	headers := handlers.AllowedHeaders([]string{"Content-Type"})
	methods := handlers.AllowedMethods([]string{"POST", "PUT", "GET", "DELETE"})
	origin := handlers.AllowedOrigins([]string{"*"})
	srv := &http.Server{
		Handler: handlers.CORS(headers, methods, origin)(route),
		// Handler:      route,
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
