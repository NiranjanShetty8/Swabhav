package player

import (
	"testing"
	"tic_tac_toe_app/components"
)

func TestNewPlayerNameAndMark(t *testing.T) {
	newPlayer1 := NewPlayer("Niranjan")
	actualMarkOf1 := newPlayer1.Mark
	actualNameOf1 := newPlayer1.Name
	expectedMarkOf1 := components.XMark
	expectedNameOf1 := "Niranjan"

	if expectedMarkOf1 != actualMarkOf1 {
		t.Errorf("Expected %v but Actual is %v", expectedMarkOf1, actualMarkOf1)
	}

	if expectedNameOf1 != actualNameOf1 {
		t.Errorf("Expected %v but Actual is %v", expectedNameOf1, actualNameOf1)
	}
	newPlayer2 := NewPlayer("Ram")
	actualMarkOf2 := newPlayer2.Mark
	actualNameOf2 := newPlayer2.Name
	expectedMarkOf2 := components.OMark
	expectedNameOf2 := "Ram"

	if expectedMarkOf2 != actualMarkOf2 {
		t.Errorf("Expected %v but Actual is %v", expectedMarkOf2, actualMarkOf2)
	}
	if expectedNameOf2 != actualNameOf2 {
		t.Errorf("Expected %v but Actual is %v", expectedNameOf2, actualNameOf2)
	}

}
