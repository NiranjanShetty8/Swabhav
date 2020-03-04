package service

import (
	"testing"
	"tic_tac_toe_app/components"
)

func TestCheckForwardDiagonal(t *testing.T) {
	var (
		newBoard      = components.CreateBoard(3)
		boardService  = NewBoardService(newBoard)
		result        = &Result{}
		resultService = NewResultService(boardService, result)
	)
	boardService.PutMarkInPosition(player1, 0)
	boardService.PutMarkInPosition(player2, 1)
	boardService.PutMarkInPosition(player1, 4)
	actualResult := resultService.checkForwardDiagonal(player1.Mark, 4)
	if actualResult {
		t.Errorf("Expected is false, Actual is %v", actualResult)
	}
	boardService.PutMarkInPosition(player2, 2)
	boardService.PutMarkInPosition(player1, 8)
	actualResult = resultService.checkForwardDiagonal(player1.Mark, 8)
	if !actualResult {
		t.Errorf("Expected is true, Actual is %v", actualResult)
	}
}

func TestCheckResverseDiagonal(t *testing.T) {
	var (
		newBoard      = components.CreateBoard(3)
		boardService  = NewBoardService(newBoard)
		result        = &Result{}
		resultService = NewResultService(boardService, result)
	)
	boardService.PutMarkInPosition(player1, 2)
	boardService.PutMarkInPosition(player2, 1)
	boardService.PutMarkInPosition(player1, 4)
	actualResult := resultService.checkReverseDiagonal(player1.Mark, 4)
	if actualResult {
		t.Errorf("Expected is false, Actual is %v", actualResult)
	}
	boardService.PutMarkInPosition(player2, 0)
	boardService.PutMarkInPosition(player1, 6)
	actualResult = resultService.checkReverseDiagonal(player1.Mark, 6)
	if !actualResult {
		t.Errorf("Expected is true, Actual is %v", actualResult)
	}
}

func TestCheckColumn(t *testing.T) {
	var (
		newBoard      = components.CreateBoard(3)
		boardService  = NewBoardService(newBoard)
		result        = &Result{}
		resultService = NewResultService(boardService, result)
	)
	boardService.PutMarkInPosition(player1, 0)
	boardService.PutMarkInPosition(player2, 1)
	boardService.PutMarkInPosition(player1, 3)
	actualResult := resultService.checkColumn(player1.Mark, 3)
	if actualResult {
		t.Errorf("Expected is false, Actual is %v", actualResult)
	}
	boardService.PutMarkInPosition(player2, 2)
	boardService.PutMarkInPosition(player1, 6)
	actualResult = resultService.checkColumn(player1.Mark, 6)
	if !actualResult {
		t.Errorf("Expected is true, Actual is %v", actualResult)
	}
}

func TestCheckRow(t *testing.T) {
	var (
		newBoard      = components.CreateBoard(3)
		boardService  = NewBoardService(newBoard)
		result        = &Result{}
		resultService = NewResultService(boardService, result)
	)
	boardService.PutMarkInPosition(player1, 0)
	boardService.PutMarkInPosition(player2, 4)
	boardService.PutMarkInPosition(player1, 1)
	actualResult := resultService.checkRow(player1.Mark, 1)
	if actualResult {
		t.Errorf("Expected is false, Actual is %v", actualResult)
	}
	boardService.PutMarkInPosition(player2, 5)
	boardService.PutMarkInPosition(player1, 2)
	actualResult = resultService.checkRow(player1.Mark, 2)
	if !actualResult {
		t.Errorf("Expected is true, Actual is %v", actualResult)
	}
}

func TestDrawResult(t *testing.T) {
	var (
		newBoard      = components.CreateBoard(3)
		boardService  = NewBoardService(newBoard)
		result        = &Result{}
		resultService = NewResultService(boardService, result)
	)
	boardService.PutMarkInPosition(player1, 0)
	boardService.PutMarkInPosition(player2, 1)
	boardService.PutMarkInPosition(player1, 2)
	boardService.PutMarkInPosition(player2, 3)
	boardService.PutMarkInPosition(player1, 4)
	boardService.PutMarkInPosition(player2, 6)
	boardService.PutMarkInPosition(player1, 7)
	boardService.PutMarkInPosition(player2, 8)
	boardService.PutMarkInPosition(player1, 5)

	actualResult := resultService.GetResult(player1.Mark, 5)
	actualDraw := actualResult.Draw
	actualWin := actualResult.Win

	if !actualDraw {
		t.Errorf("Expected is true, Actual is %v", actualDraw)
	}

	if actualWin {
		t.Errorf("Expected is false, Actual is %v", actualWin)
	}
}
func TestWinResultAndProcess(t *testing.T) {
	var (
		newBoard      = components.CreateBoard(3)
		boardService  = NewBoardService(newBoard)
		result        = &Result{}
		resultService = NewResultService(boardService, result)
	)
	boardService.PutMarkInPosition(player1, 0)
	boardService.PutMarkInPosition(player2, 1)
	boardService.PutMarkInPosition(player1, 2)
	boardService.PutMarkInPosition(player2, 3)
	boardService.PutMarkInPosition(player1, 4)
	boardService.PutMarkInPosition(player2, 5)
	actual := resultService.GetResult(player2.Mark, 5)

	if actual.Draw {
		t.Errorf("Expected is false, Actual is %v", actual.Draw)
	}
	if actual.Win {
		t.Errorf("Expected is false, Actual is %v", actual.Win)
	}

	boardService.PutMarkInPosition(player1, 7)
	boardService.PutMarkInPosition(player2, 8)
	boardService.PutMarkInPosition(player1, 6)

	actualResult := resultService.GetResult(player1.Mark, 6)
	actualDraw := actualResult.Draw
	actualWin := actualResult.Win

	if actualDraw {
		t.Errorf("Expected is false, Actual is %v", actualDraw)
	}

	if !actualWin {
		t.Errorf("Expected is true, Actual is %v", actualWin)
	}
}
