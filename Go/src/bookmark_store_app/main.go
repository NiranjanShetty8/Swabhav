package main

import (
	"bookmark_store_app/bookmark/model"
	"bookmark_store_app/bookmark/service"
	"fmt"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

func main() {
	startApp()
}
func startApp() {
	db, err := gorm.Open("mysql", "root:root@tcp(127.0.0.1:4040)/swabhav?charset=utf8&parseTime=True")
	defer db.Close()
	if err != nil {
		fmt.Print(err)
	}
	bookmark := model.Bookmark{}
	bookmarkService := service.NewBookmarkService(db)

	fmt.Println("\nEnter a choice from 1-5 respectively\n1)Add Bookmark \n2)Get Bookmark by ID \n3)Get all Bookmarks\n4)Export all Bookmarks to file\n5)Exit")
	var choice int
	fmt.Scanln(&choice)

	switch choice {
	case 1:
		addBookmark(bookmark, bookmarkService)
	case 2:
		getBookmarkByID(bookmarkService)
	case 3:
		getAllBookmarks(bookmarkService)
	case 4:
		exportBookmarks(bookmarkService)
	case 5:
		fmt.Println("Good-Bye!")
		break
	default:
		fmt.Println("Please Enter a choice from 1-5")
		startApp()
	}
}

func addBookmark(bookmark model.Bookmark, bookmarkService *service.BookmarkService) {
	fmt.Println("Enter the URL of the bookmark:")
	fmt.Scanln(&bookmark.URL)
	fmt.Println("Enter the Description")
	fmt.Scanln(&bookmark.Description)
	err := bookmarkService.AddBookmark(&bookmark)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Bookmark Added Successfully.")
	}
	startApp()
}

func getBookmarkByID(bookmarkService *service.BookmarkService) {
	var id uint
	fmt.Println("Enter the ID of the bookmark you wish to get:")
	fmt.Scanln(&id)
	bookmark, err := bookmarkService.GetBookmarkByID(id)
	if err != nil {
		fmt.Println(err)
		startApp()
	}
	fmt.Printf("ID is : %d\nDescription is : %s\nURL is : %s\n", bookmark.ID, bookmark.Description, bookmark.URL)
	startApp()
}

func getAllBookmarks(bookmarkService *service.BookmarkService) {
	result, err := bookmarkService.GetAllBookmarks()
	if err != nil {
		fmt.Println(err)
		startApp()
	}
	for _, bookmark := range *result {
		fmt.Printf("ID is : %d\nDescription is : %s\nURL is : %s\n", bookmark.ID, bookmark.Description, bookmark.URL)
	}
	startApp()
}

func exportBookmarks(bookmarkService *service.BookmarkService) {
	var fileName string
	fmt.Println("A file will be created with all of your bookmarks.\nSpecify it's name:")
	fmt.Scanln(&fileName)
	err := bookmarkService.ExportBookmarks(fileName)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("File has been created & bookmarks have been written into it.")
	}
}
