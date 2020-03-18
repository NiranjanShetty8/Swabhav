package controller

import (
	"encoding/json"
	"fmt"
	"net/http"
	"strconv"
	"strings"

	"github.com/jinzhu/gorm"

	"github.com/gorilla/mux"
	uuid "github.com/satori/go.uuid"
	// logger "github.com/sirupsen/logrus"
)

type StudentController struct {
	service *StudentService
}

func NewStudentController(db *gorm.DB) *StudentController {
	return &StudentController{
		service: NewStudentService(db),
	}
}

func (sc *StudentController) RegisterRoutes(route *mux.Router) {

	route.HandleFunc("/api/techlabs/students", sc.getAllStudents).Methods("GET")
	route.HandleFunc("/api/techlabs/students/", sc.getAllStudents).Methods("GET")
	route.HandleFunc("/api/techlabs/students/", sc.addStudent).Methods("POST")
	route.HandleFunc("/api/techlabs/students/{ID}", sc.getStudentByID).Methods("GET")
	route.HandleFunc("/api/techlabs/students/{ID}", sc.deleteStudent).Methods("DELETE")
	route.HandleFunc("/api/techlabs/students/{ID}", sc.updateStudent).Methods("PUT")

}

func (sc *StudentController) getStudentByID(w http.ResponseWriter, http *http.Request) {
	id := mux.Vars(http)
	newId, _ := uuid.FromString(id["ID"])
	student, err := sc.service.GetStudentByID(newId)
	if err != nil {
		errMsg := fmt.Sprint(err)
		json.NewEncoder(w).Encode(errMsg)
	} else if len(*student) == 0 {
		json.NewEncoder(w).Encode("Invalid ID")
	} else {
		json.NewEncoder(w).Encode(student)
	}
}

func (sc *StudentController) getAllStudents(w http.ResponseWriter, http *http.Request) {
	fmt.Println("In get all")
	json.NewEncoder(w).Encode(sc.service.GetAllStudents())
}

func (sc *StudentController) deleteStudent(w http.ResponseWriter, http *http.Request) {
	id := mux.Vars(http)
	newID, _ := uuid.FromString(id["ID"])
	if err := sc.service.DeleteStudent(newID); err != nil {
		errMsg := fmt.Sprint(err)
		json.NewEncoder(w).Encode(errMsg)
		return
	}
	json.NewEncoder(w).Encode("Student Deleted")
}

func (sc *StudentController) updateStudent(w http.ResponseWriter, http *http.Request) {
	fmt.Println("Update Student")
	w.Header().Set("Content-Type", "application/json")
	id := mux.Vars(http)
	newID, _ := uuid.FromString(id["ID"])
	student := &Student{}
	if strings.Compare(http.Header["Content-Type"][0], "application/x-www-form-urlencoded") == 0 {
		urlEncodedData(student, http)
	} else {
		addErr := json.NewDecoder(http.Body).Decode(student)
		if addErr != nil {
			writeError(addErr, w)
			return
		}
	}
	if err := sc.service.UpdateStudent(newID, student); err != nil {
		errMsg := fmt.Sprint(err)
		json.NewEncoder(w).Encode(errMsg)
	}
}

func (sc *StudentController) addStudent(w http.ResponseWriter, http *http.Request) {
	fmt.Println("Add Student")
	// w.Header().Set("Content-Type", "application/json")
	student := &Student{}
	if strings.Compare(http.Header["Content-Type"][0], "application/x-www-form-urlencoded") == 0 {
		fmt.Println("URL ENCODED")
		urlEncodedData(student, http)
	} else {
		fmt.Println("JSON")
		addErr := json.NewDecoder(http.Body).Decode(student)
		if addErr != nil {
			writeError(addErr, w)
			return
		}
	}
	genID := sc.service.AddStudent(student)
	json.NewEncoder(w).Encode(genID)
}

func urlEncodedData(student *Student, http *http.Request) {
	http.ParseForm()
	student.Age = convertToUInt(http.FormValue("age"))
	student.RollNo = convertToUInt((http.FormValue("rollNo")))
	student.Name = http.FormValue("name")
	student.Email = http.FormValue("email")
	student.Date = http.FormValue("date")
	student.IsMale = convertToBool(http.FormValue("isMale"))
}

func convertToUInt(s string) uint {
	v, _ := strconv.ParseInt(s, 10, 64)
	return uint(v)
}

func writeError(err error, w http.ResponseWriter) {
	idMsg := "uuid"
	lenMsg := "json"
	idErrMsg := fmt.Sprintln(err)
	cmpMsg := idErrMsg[0:4]
	if strings.EqualFold(idMsg, cmpMsg) {
		w.WriteHeader(400)
		w.Write([]byte("400 - Please remove the ID field. ID will be allocated automatically"))
		return
	} else if strings.EqualFold(lenMsg, cmpMsg) {
		w.WriteHeader(400)
		w.Write([]byte("400 - Values are Inappropirate  or too high to handle."))
		return
	}

	fmt.Println("In error", err)
	w.WriteHeader(500)
	w.Write([]byte("Stop giving random values to random paramters. Everything works fine."))
	return
}

func convertToBool(s string) bool {
	return strings.EqualFold(s, "true")
}
