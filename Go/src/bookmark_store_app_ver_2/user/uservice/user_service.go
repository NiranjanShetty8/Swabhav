package uservice

import (
	umodel "bookmark_store_app_ver_2/user/umodel"
	"fmt"
	"strings"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type UserService struct {
	DB *gorm.DB
}

func NewUserService(db *gorm.DB) *UserService {
	db.AutoMigrate(&umodel.User{})
	return &UserService{
		DB: db,
	}
}

func (uService *UserService) Register(user *umodel.User) error {
	user.Username = strings.ReplaceAll(user.Username, " ", "")
	// user.Password= strings.ReplaceAll(user.Password," ", "")
	if user.Username == "" || user.Password == "" {
		return fmt.Errorf("Username or password cannot be blank")
	}

	encrypted := uService.encryptPassword(user.Password)

	user.Password = encrypted
	res := uService.DB.Save(&user)
	if res.Error != nil {
		return res.Error
	}
	return nil
}

func (uService *UserService) login(user *umodel.User) error {
	currentUser := umodel.User{}
	userDB := uService.DB.Where("username=?", user.Username).First(&currentUser)
	if userDB.Error != nil {
		return fmt.Errorf("User does not exist.")
	}
	currentPassword := uService.encryptPassword(user.Password)
	if currentPassword != user.Password {
		return fmt.Errorf("Invalid Password.")
	}
	//make it return ID
	return nil
}

func (uService *UserService) encryptPassword(pass string) string {
	// sha := sha1.New()
	// sha.Write([]byte(pass))
	// hashed := sha.Sum(nil)
	// encrypted := string(hashed)
	hashed := []byte(pass)
	encrypted := string(hashed)
	return encrypted
}
