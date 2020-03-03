package controller

import (
	"fmt"
	"net/http"

	"github.com/gorilla/mux"
	// logger "github.com/sirupsen/logrus"
)

func RegisterRoutes(route *mux.Router) {

	route.HandleFunc("/", GetAllStudents).Methods("GET")
	route.HandleFunc("/", AddStudent).Methods("ADD")
	route.HandleFunc("/{ID}", GetStudentByID).Methods("GET")
	route.HandleFunc("/{ID}", DeleteStudent).Methods("DELETE")
	route.HandleFunc("/{ID}", UpdateStudent).Methods("POST")

}

func GetStudentByID(w http.ResponseWriter, http *http.Request) {
	fmt.Println("Get student By ID")
}

func GetAllStudents(w http.ResponseWriter, http *http.Request) {
	fmt.Println("Get All Students")
}

func DeleteStudent(w http.ResponseWriter, http *http.Request) {
	fmt.Println("Delete Students")
}

func UpdateStudent(w http.ResponseWriter, http *http.Request) {
	fmt.Println("Update Student")
}

func AddStudent(w http.ResponseWriter, http *http.Request) {
	fmt.Println("Add Student")
}
