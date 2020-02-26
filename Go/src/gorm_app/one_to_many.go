package main

import (
	"fmt"

	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type Customer struct {
	gorm.Model
	Name     string
	Location string
	Orders   []Order
}

type Order struct {
	gorm.Model
	Date       string
	Amount     float64
	CustomerId uint
}

func main() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}
	customerBucket := Customer{}
	// db.AutoMigrate(&Customer{}, &Order{})
	// db.Model(&Order{}).
	// 	AddForeignKey("customer_id", "Customers(id)", "CASCADE", "CASCADE")

	db.Preload("Orders").Where("id=3").First(&customerBucket)
	// db.Save(&Customer{
	// 	Name:     "Vijay",
	// 	Location: "Andheri",
	// 	Orders: []Order{{
	// 		Date:   "12-11-2019",
	// 		Amount: 1000,
	// 	}, {
	// 		Date:   "12-12-2019",
	// 		Amount: 1000,
	// 	}, {
	// 		Date:   "12-01-2020",
	// 		Amount: 1000,
	// 	}},
	// })

	fmt.Println(customerBucket.Name)
	for _, ord := range customerBucket.Orders {
		fmt.Println(ord.Date, ord.Amount)
	}

}
