package controller

import (
	"errors"
	"fmt"

	uuid "github.com/satori/go.uuid"
)

var allStudents = make(map[uuid.UUID]Student)

type Student struct {
	Id     uuid.UUID `json:"id"`
	Name   string    `json:"name"`
	RollNo uint      `json:"rollNo"`
	Age    uint      `json:"age"`
	Email  string    `json:"email"`
	Date   string    `json:"date"`
	IsMale bool      `json:"isMale"`
}

type StudentService struct{}

func NewStudentService() *StudentService {
	return &StudentService{}
}

func internalAdd() {
	idGen := uuid.NewV4()
	student1 := Student{
		Id:     idGen,
		Name:   "Niranjan",
		RollNo: 1,
		Age:    30,
		Email:  "shetty.niranjan4@gmail.com",
		Date:   "08-01-1994",
		IsMale: true,
	}
	idGen2 := uuid.NewV4()
	student2 := Student{
		Id:     idGen2,
		Name:   "Jayesh",
		RollNo: 2,
		Age:    32,
		Email:  "jayesh4@gmail.com",
		Date:   "08-02-2019",
		IsMale: true,
	}
	allStudents[student1.Id] = student1
	allStudents[student2.Id] = student2
}
func (ss *StudentService) GetAllStudents() *[]Student {
	var students []Student
	for _, student := range allStudents {
		students = append(students, student)
	}
	return &students
}

func (ss *StudentService) GetStudentByID(id uuid.UUID) ([]*Student, error) {
	if allStudents[id].Name == "" {
		return nil, errors.New("Student does not exist")
	}
	var student []*Student
	stud := allStudents[id]
	student = append(student, &stud)
	return student, nil
}

func (ss *StudentService) DeleteStudent(id uuid.UUID) error {
	if allStudents[id].Name == "" {
		return errors.New("Student does not exist")
	}
	delete(allStudents, id)
	return nil
}

func (ss *StudentService) AddStudent(student *Student) uuid.UUID {
	id := uuid.NewV4()
	student.Id = id
	fmt.Printf("%T is type ", student.IsMale)
	fmt.Println(student.IsMale)
	allStudents[student.Id] = *student
	return id
}

func (ss *StudentService) UpdateStudent(id uuid.UUID, student *Student) error {
	if allStudents[id].Name == "" {
		return errors.New("Student does not exist")
	}
	student.Id = id
	allStudents[id] = *student
	return nil

}

func init() {
	internalAdd()
}
