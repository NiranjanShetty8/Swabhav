package service

import (
	"testing"
	"tic_tac_toe_app/components"
	"tic_tac_toe_app/player"
)

var (
	newBoard     = components.CreateBoard(3)
	player1      = player.NewPlayer("Niranjan")
	player2      = player.NewPlayer("Ram")
	boardService = NewBoardService(newBoard)
)

func TestPutMarkInPosition(t *testing.T) {
	boardService.PutMarkInPosition(player1, 0)
	actualMark := newBoard.Cells[0].GetMark()
	expectedMark := components.XMark

	if actualMark != expectedMark {
		t.Errorf("Expected %v but Actual is %v", expectedMark, actualMark)
	}
}

func TestGetAllMarks(t *testing.T) {
	allCells := boardService.GetAllMarks()
	expectedSize := 9
	actualSize := len(allCells)
	if actualSize != expectedSize {
		t.Errorf("Expected %v but Actual is %v", expectedSize, actualSize)
	}
}

func TestCheckIfBoardIsFull(t *testing.T) {
	actualBefore := boardService.CheckIfBoardIsFull()
	expectedBefore := false

	if actualBefore != expectedBefore {
		t.Errorf("Expected %v but Actual is %v", expectedBefore, actualBefore)
	}
	for i := 0; i < 9; i++ {
		if i%2 == 0 {
			boardService.PutMarkInPosition(player1, i)
		} else {
			boardService.PutMarkInPosition(player2, i)
		}
	}
	actualAfter := boardService.CheckIfBoardIsFull()
	expectedAfter := true

	if actualAfter != expectedAfter {
		t.Errorf("Expected %v but Actual is %v", expectedAfter, actualAfter)
	}
}
