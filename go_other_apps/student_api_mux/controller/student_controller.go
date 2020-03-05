package controller

import (
	"encoding/json"
	"fmt"
	"net/http"
	"strconv"
	"strings"

	"github.com/gorilla/mux"
	uuid "github.com/satori/go.uuid"
	// logger "github.com/sirupsen/logrus"
)

var service = NewStudentService()

func RegisterRoutes(route *mux.Router) {

	route.HandleFunc("/api/techlabs/students", GetAllStudents).Methods("GET")
	route.HandleFunc("/api/techlabs/students/", GetAllStudents).Methods("GET")
	route.HandleFunc("/api/techlabs/students/", AddStudent).Methods("POST")
	route.HandleFunc("/api/techlabs/students/{ID}", GetStudentByID).Methods("GET")
	route.HandleFunc("/api/techlabs/students/{ID}", DeleteStudent).Methods("DELETE")
	route.HandleFunc("/api/techlabs/students/{ID}", UpdateStudent).Methods("PUT")

}

func GetStudentByID(w http.ResponseWriter, http *http.Request) {
	id := mux.Vars(http)
	newId, _ := uuid.FromString(id["ID"])
	student, err := service.GetStudentByID(newId)
	if err != nil {
		errMsg := fmt.Sprint(err)
		json.NewEncoder(w).Encode(errMsg)
	} else {
		json.NewEncoder(w).Encode(student)
	}
}

func GetAllStudents(w http.ResponseWriter, http *http.Request) {
	// w.Write([]byte(fmt.Sprintln()))
	json.NewEncoder(w).Encode(service.GetAllStudents())
}

func DeleteStudent(w http.ResponseWriter, http *http.Request) {
	id := mux.Vars(http)
	newID, _ := uuid.FromString(id["ID"])
	if err := service.DeleteStudent(newID); err != nil {
		errMsg := fmt.Sprint(err)
		json.NewEncoder(w).Encode(errMsg)
		return
	}
	json.NewEncoder(w).Encode("Student Deleted")
}

func UpdateStudent(w http.ResponseWriter, http *http.Request) {
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
			return
		}
	}
	if err := service.UpdateStudent(newID, student); err != nil {
		errMsg := fmt.Sprint(err)
		json.NewEncoder(w).Encode(errMsg)
	}
}

func AddStudent(w http.ResponseWriter, http *http.Request) {
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
			return
		}
	}
	fmt.Println(student)
	genID := service.AddStudent(student)
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

func convertToBool(s string) bool {
	return strings.EqualFold(s, "true")
}
