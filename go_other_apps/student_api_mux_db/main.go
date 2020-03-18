package main

import (
	"context"
	"fmt"
	"log"
	"net/http"
	"os"
	"os/signal"
	"time"

	"github.com/NiranjanShetty8/Swabhav/tree/master/go_other_apps/student_api_mux_db/controller"
	"github.com/gorilla/handlers"
	"github.com/gorilla/mux"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	// logger "github.com/sirupsen/logrus"
)

func main() {
	// db, err := gorm.Open("mysql", "root:root@tcp(host.docker.internal:4040)/swabhav?charset=utf8&parseTime=True")
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	db.AutoMigrate(&controller.Student{})

	if err != nil {
		fmt.Println("In error")
		fmt.Print(err)
	}
	routerInit(db)
}

func routerInit(db *gorm.DB) {
	route := mux.NewRouter()
	if route == nil {
		log.Fatal("No router Created")
	}
	fmt.Println("Router Created")
	studController := controller.NewStudentController(db)
	studController.RegisterRoutes(route)
	headers := handlers.AllowedHeaders([]string{"Content-Type"})
	methods := handlers.AllowedMethods([]string{"POST", "PUT", "GET", "DELETE"})
	origin := handlers.AllowedOrigins([]string{"*"})
	srv := &http.Server{
		Handler:      handlers.CORS(headers, methods, origin)(route),
		WriteTimeout: 15 * time.Second,
		ReadTimeout:  15 * time.Second,
		Addr:         ":8080",
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
	fmt.Println("Closing DB")
	db.Close()
	fmt.Println("Server ShutDown....")
	os.Exit(0)
}
