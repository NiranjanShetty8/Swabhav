package service

import (
	"bookmark_store_app/bookmark/model"
	"fmt"
	"net/http"
	"os"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type BookmarkService struct {
	DB *gorm.DB
}

func NewBookmarkService(db *gorm.DB) *BookmarkService {
	db.AutoMigrate(&model.Bookmark{})
	return &BookmarkService{
		DB: db,
	}
}

func (bms *BookmarkService) AddBookmark(bookmark *model.Bookmark) error {
	result := model.Bookmark{}
	bms.DB.Where("URL=?", bookmark.URL).First(&result)
	if _, err := http.Get(bookmark.URL); err != nil {
		fmt.Println(result.URL)
		return fmt.Errorf("Please enter a valid URL")
	}
	res := bms.DB.Save(bookmark)
	if res.Error != nil {
		return res.Error
	}
	return nil
}

func (bms *BookmarkService) GetBookmarkByID(id uint) (*model.Bookmark, error) {
	result := model.Bookmark{}
	bms.DB.Where("id=?", id).First(&result)
	if result.URL == "" {
		return &model.Bookmark{}, fmt.Errorf("Bookmark not found")
	}
	return &result, nil

}

func (bms *BookmarkService) GetAllBookmarks() (*[]model.Bookmark, error) {
	var result []model.Bookmark
	bms.DB.Find(&result)
	if len(result) == 0 {
		return &result, fmt.Errorf("No bookmarks Present")
	}
	return &result, nil

}

func (bms *BookmarkService) ExportBookmarks(fName string) error {
	allBookmarks, err := bms.GetAllBookmarks()
	if err != nil {
		return fmt.Errorf("No bookmarks Present")
	}
	f, err := os.Create(fName + ".html")
	defer func() error {
		if err := f.Close(); err != nil {
			return err
		}
		return nil
	}()
	if err != nil {
		return fmt.Errorf("File could no be created because of ", err)
	}
	for _, bookmark := range *allBookmarks {
		htmlTag := bms.CreateTag(&bookmark)
		_, err := f.WriteString(htmlTag)
		if err != nil {
			return fmt.Errorf("File could no be written because of ", err)
		}
	}
	return nil
}

func (bms *BookmarkService) CreateTag(bookmark *model.Bookmark) string {
	return fmt.Sprintf("<a href=\"%s\">%s</a><br/>\n", bookmark.URL, bookmark.Description)
}
