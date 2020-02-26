package main

import (
	"fmt"

	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type Employee struct {
	gorm.Model
	Name   string
	Salary float64
}

func main() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}

	e := Employee{}
	db.CreateTable(&e)

	employees := []Employee{
		{Name: "Niranjan", Salary: 10000},
		{Name: "Raju", Salary: 10000},
		{Name: "Prakash", Salary: 10000},
		{Name: "Mohit", Salary: 10000},
	}

	for _, emp := range employees {
		db.Create(&emp)
	}
	fmt.Println("Table created & employees added")

	lastEmployee := Employee{}
	test1 := db.Last(&lastEmployee)
	test2 := db.Delete(&lastEmployee)
	fmt.Println("test1 is: ", test1)
	fmt.Println("test1 is: ", test2)
	fmt.Println(lastEmployee.DeletedAt)

}

// Output :
// Table created & employees added
// test1 is:  &{{{0 0} 0 0 0 0} 0xc00015a660 <nil> 1 0xc0000a63c0 false 0 {0xc0000e7e50} 0xc000186dc0 {{0 0} {{map[gorm:order_by_primary_key:0xc000174150] false}} map[] 0} 0xc000147e10 <nil> 0xc0001848a0 false <nil>}
// test1 is:  &{{{0 0} 0 0 0 0} 0xc00015a660 <nil> 1 0xc0000a63c0 false 0 {0xc0000e7e50} 0xc000187760 {{0 0} {{map[gorm:started_transaction0xc0001742100xc0001788c0:0xc000174218] false}} map[] 0} 0xc000147e10 <nil> 0xc000184c60 false <nil>}
// <nil>
