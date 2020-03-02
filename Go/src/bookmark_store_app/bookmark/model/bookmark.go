package model

import "github.com/jinzhu/gorm"

type Bookmark struct {
	gorm.Model
	Description string `gorm:type:"varchar(50)"`
	URL         string `gorm:"unique;not null;type:"varchar(150)"`
}
