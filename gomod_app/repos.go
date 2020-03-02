package main

import (
	"fmt"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	// uuid "github.com/satori/go.uuid"
)

type Useruuid struct {
	ID string `gorm:"type:varchar(36)"`
	// Balance float64
}
type UniOfWork struct {
	DB *gor
}
type Respository interface {
	Get()
}

func main() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	db.AutoMigrate(&Useruuid{})

	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}
}
