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
	Customers := []Customer{
		{
			Firstname: "Niranjan",
			LastName:  "Shetty",
			Balance:   10000,
		}, {
			Firstname: "Ratnesh",
			LastName:  "Dubey",
			Balance:   10000,
		}, {
			Firstname: "Onkar",
			LastName:  "Pandey",
			Balance:   10000,
		}, {
			Firstname: "Raju",
			LastName:  "Trivedi",
			Balance:   10000,
		}, {
			Firstname: "Sanjay",
			LastName:  "Yadav",
			Balance:   8000,
		},
	}

	// fmt.Println(Customers)
	for _, cust := range Customers {
		db.Create(&cust)
	}

	firstCustomer := Customer{}
	db.First(&firstCustomer)
	fmt.Println(firstCustomer)

	lastCustomer := Customer{}
	db.Last(&lastCustomer)
	fmt.Println(lastCustomer)
	lastCustomer.Balance += 2000
	db.Save(&lastCustomer)

	customerBucket := []Customer{}
	db.Find(&customerBucket)
	fmt.Println(customerBucket)

}

type Customer struct {
	ID        int
	Firstname string `gorm:"type:varchar(100);"`
	LastName  string `gorm:"type:varchar(100);"`
	Balance   float64
}
