package components 

import "testing"

func TestCreateBoard(t *testing.T) {
	newBoard := CreateBoard(3)
	for _,cell := range newBoard.Cells {
		if actualMark := cell.GetMark();actualMark != NoMark {
			t.Errorf("Expected %v but Actual is %v", NoMark, cell)
		}
	}
	expectedSize := 9
	actualSize := len(newBoard.Cells)
		if expectedSize != actualSize {
			t.Errorf("Expected %v but Actual is %v", expectedSize, actualSize)
		}
}