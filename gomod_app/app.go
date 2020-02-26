package main

import (
	"github.com/NiranjanShetty8/Swabhav/tree/master/gomod_app/model"
	"github.com/NiranjanShetty8/Swabhav/tree/master/gomod_app/service"
)

func main() {
	dataserv := service.NewDataService()
	dataserv.ProcessData(&model.Student{ID: 101, Name: "Niranjan"})
}
