package service

import (
	"testing"
	"tic_tac_toe_app/components"
)

func TestPutMarkInPosition(t *testing.T) {
	var (
		newBoard     = components.CreateBoard(3)
		boardService = NewBoardService(newBoard)
	)
	boardService.PutMarkInPosition(player1, 0)
	actualMark := newBoard.Cells[0].GetMark()
	expectedMark := components.XMark

	if actualMark != expectedMark {
		t.Errorf("Expected %v but Actual is %v", expectedMark, actualMark)
	}
}

func TestGetAllMarks(t *testing.T) {
	var (
		newBoard     = components.CreateBoard(3)
		boardService = NewBoardService(newBoard)
	)
	allCells := boardService.GetAllMarks()
	expectedSize := 9
	actualSize := len(allCells)
	if actualSize != expectedSize {
		t.Errorf("Expected %v but Actual is %v", expectedSize, actualSize)
	}
}

func TestCheckIfBoardIsFull(t *testing.T) {
	var (
		newBoard     = components.CreateBoard(3)
		boardService = NewBoardService(newBoard)
	)
	actualBefore := boardService.CheckIfBoardIsFull()
	expectedBefore := false

	if actualBefore != expectedBefore {
		t.Errorf("Expected %v but Actual is %v", expectedBefore, actualBefore)
	}
	for i := uint8(0); i < 9; i++ {
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

func TestBoardPrint(t *testing.T) {
	var (
		newBoard     = components.CreateBoard(3)
		boardService = NewBoardService(newBoard)
	)
	//Empty Board Check
	actualBoard := boardService.PrintBoard()

	expectedBoard := " - - - \n - - - \n - - - \n "

	if actualBoard != expectedBoard {
		t.Errorf("Expected \n%v but Actual is \n%v", expectedBoard, actualBoard)
	}

	for i := uint8(0); i < 9; i++ {
		if i%2 == 0 {
			boardService.PutMarkInPosition(player1, i)
		} else {
			boardService.PutMarkInPosition(player2, i)
		}
	}
	actualBoard = boardService.PrintBoard()

	expectedBoard = " X O X \n O X O \n X O X \n "

	if actualBoard != expectedBoard {
		t.Errorf("Expected \n%v but Actual is \n%v", expectedBoard, actualBoard)
	}
}
