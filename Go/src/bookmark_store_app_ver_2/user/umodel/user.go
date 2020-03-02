package umodel

import (
	"bookmark_store_app/bookmark/model"

	"github.com/jinzhu/gorm"
)

type User struct {
	gorm.Model
	Username  string `gorm:"unique;not null"`
	Password  string `gorm:"not null;type:varchar(255)"`
	Bookmarks []model.Bookmark
}
