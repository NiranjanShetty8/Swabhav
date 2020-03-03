package controller 

import (
	"fmt"
	"time"
	uuid"github.com/satori/go.uuid"
	// "github.com/NiranjanShetty8/Swabhav/tree/master/go_other_apps/student_api_mux/uuid"
)

var allStudents = make(map[string]Student)

type Student struct {
	Id 	   uuid.UUID
	RollNo uint
	Age	   uint8
	Email  string
	Date   time.Time
	IsMale bool

}

func test()  {
	fmt.Println("HEllo")
}