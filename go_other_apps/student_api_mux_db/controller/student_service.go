package controller

import (
	"fmt"

	"github.com/NiranjanShetty8/Swabhav/tree/master/go_other_apps/student_api_mux_db/repository"
	"github.com/jinzhu/gorm"
	uuid "github.com/satori/go.uuid"
)

type Student struct {
	repository.ModelBase
	Name   string `json:"name"`
	RollNo uint   `json:"rollNo"`
	Age    uint   `json:"age"`
	Email  string `json:"email"`
	IsMale bool   `json:"isMale"`
	Date   string `json:"date"`
}

type StudentService struct {
	DB *gorm.DB
}

var studRepository = repository.NewRepository()

func NewStudentService(db *gorm.DB) *StudentService {
	return &StudentService{
		DB: db,
	}
}

func (ss *StudentService) GetAllStudents() *[]Student {
	var allStudents []Student
	readUOW := repository.NewUnitOfWork(ss.DB, true)
	studRepository.GetAll(readUOW, &allStudents)
	return &allStudents
}

func (ss *StudentService) GetStudentByID(id uuid.UUID) (*[]Student, error) {
	var allStudents []Student
	readUOW := repository.NewUnitOfWork(ss.DB, true)
	studIdERR := studRepository.Get(readUOW, id, &allStudents)
	if studIdERR != nil {
		return nil, studIdERR
	}
	return &allStudents, nil
}

func (ss *StudentService) DeleteStudent(id uuid.UUID) error {
	student := Student{}
	writeUOW := repository.NewUnitOfWork(ss.DB, false)
	studRepository.Get(writeUOW, id, &student)
	deleteERR := studRepository.Delete(writeUOW, id, &student)
	if deleteERR != nil {
		writeUOW.Complete()
		return deleteERR
	}
	writeUOW.Commit()
	return nil
}

func (ss *StudentService) AddStudent(student *Student) uuid.UUID {
	fmt.Println("service:", student)
	student.ID = uuid.NewV4()
	writeUOW := repository.NewUnitOfWork(ss.DB, false)
	addErr := studRepository.Add(writeUOW, student)
	if addErr != nil {
		writeUOW.Complete()
	}
	writeUOW.Commit()
	return student.ID

}

func (ss *StudentService) UpdateStudent(id uuid.UUID, student *Student) error {
	fmt.Println(student)
	writeUOW := repository.NewUnitOfWork(ss.DB, false)
	updateErr := studRepository.Update(writeUOW, student)
	if updateErr != nil {
		writeUOW.Complete()
		return updateErr
	}
	writeUOW.Commit()
	return nil
}

func init() {
}
