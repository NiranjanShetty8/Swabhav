package main

import (
	"log"

	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

func main() {
	// db, err := gorm.Open("mysql", "root:root@tcp(localhost:3306)/swabhav?charset=utf8&parseTime=True&loc=Local")
	db, err := gorm.Open("mysql", "root:root@tcp(host.docker.internal:3306)/swabhav?charset=utf8&parseTime=True&loc=Local")
	defer db.Close()
	if err != nil {
		log.Println("Connection Failed to Open")
	} else {
		log.Println("Connection Established")
	}
}
