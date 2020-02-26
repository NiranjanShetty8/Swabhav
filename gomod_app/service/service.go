package service

import (
	"fmt"

	"github.com/NiranjanShetty8/Swabhav/tree/master/gomod_app/model"
)

type DataService struct {
}

func (*DataService) ProcessData(m *model.Student) {
	fmt.Println("Processing data for " + m.Name)
}
func NewDataService() *DataService {
	return &DataService{}
}
