package main

import (
	"fmt"

	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type Cust struct {
	gorm.Model
	Name string
	// Balance float64
}

func main() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	db.AutoMigrate(&Cust{})
	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}
	customer := Cust{
		Name: "Niranjan",
	}
	tran := db.Begin()
	err1 := tran.Create(&customer).Error
	err2 := tran.Save(&customer).Error

	if err1 != nil || err2 != nil {
		fmt.Println("Error occurred")
		tran.Rollback()
	} else {
		fmt.Println("Commit done.")
		tran.Commit()
	}
}
