package main

import (
	"fmt"

	_ "github.com/go-sql-driver/mysql"
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type User struct {
	gorm.Model
	Name     string
	Passport Passport
}

type Passport struct {
	gorm.Model
	Address string
	UserId  uint
}

func main() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}

	// db.AutoMigrate(&User{}, &Passport{})
	// db.Model(&Passport{}).AddForeignKey("user_id", "Users(id)", "CASCADE", "CASCADE")
	// db.Model(&Passport{}).AddForeignKey("user_id", "Users(id)", "RESTRICT", "RESTRICT")
	fmt.Println("done")

	// db.Save(&User{
	// 	Name: "Test",
	// 	Passport: Passport{
	// 		Address: "Test",
	// 	},
	// })
	userBucket := User{}
	// passBucket := Passport{}

	// db.Set("gorm:auto_preload", true).Find(&userBucket)
	db.Preload("Passport").Find(&userBucket)

	db.First(&userBucket, 2)
	fmt.Println(userBucket.Name, userBucket.Passport.Address)

	// db.First(&passBucket, 2)
	// fmt.Println(passBucket.Address)
	// lastUser := User{}
	// db.Last(&lastUser)
	// db.Delete(&lastUser)

	// firstPassport := Passport{}
	// db.First(&firstPassport)
	// db.Delete(&firstPassport)
}
