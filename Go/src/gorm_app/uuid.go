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

func main() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	db.AutoMigrate(&Useruuid{})

	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}

	// user2 := Useruuid{
	// 	ID: uuid.Must(uuid.NewV4()).String(),
	// }
	// db.Create(
	// 	&Useruuid{
	// 		ID: uuid.Must(uuid.NewV4()).String(),
	// 	})
	// db.Save(&user2)

	var userIds []Useruuid
	db.Find(&userIds)
	userId := Useruuid{}
	db.Where("id=?", userIds[2].ID).Find(&userId)

	fmt.Println(userId)

}
