package main

import (
	"fmt"

	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

func main() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}
	c1 := Customer{}
	db.Debug().DropTableIfExists(&c1)
	db.Debug().CreateTable(&c1)
	c2 := Customer{
		Firstname: "Niranjan",
		LastName:  "Shetty",
		Balance:   10000,
	}
	db.Debug().Create(&c2)

}

type Customer struct {
	ID        int
	Firstname string `gorm:"type:varchar(100);"`
	LastName  string
	Balance   float64
}
