package components

import (
	"testing"
)

func TestNewCellIsEmpty(t *testing.T) {
	newCell := NewCell()

	expected := NoMark

	actual := newCell.GetMark()

	if expected != actual {
		t.Errorf("Expected %v but Actual is %v", expected, actual)
	}
}

func TestMarkIsSet(t *testing.T) {

	//Check if it Returns X mark.
	newCell := NewCell()

	expectedX := XMark
	newCell.SetMark(XMark)
	actualX := newCell.GetMark()

	if expectedX != actualX {
		t.Errorf("Expected %v but Actual is %v", expectedX, actualX)
	}

	//Check if it Returns An Error
	actualErr := newCell.SetMark(OMark)

	if actualErr == nil {
		t.Errorf("Expected %s but Actual is %v", ErrorMsg, actualErr)
	}

	cell := NewCell()

	expectedO := OMark
	cell.SetMark(OMark)
	actualO := cell.GetMark()

	if expectedO != actualO {
		t.Errorf("Expected %v but Actual is %v", expectedO, actualO)
	}
}
