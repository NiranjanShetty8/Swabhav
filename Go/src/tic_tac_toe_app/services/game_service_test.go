package service

import (
	"testing"
	"tic_tac_toe_app/components"
	"tic_tac_toe_app/player"
)

var (
	newBoard      = components.CreateBoard(3)
	player1       = player.NewPlayer("Niranjan")
	player2       = player.NewPlayer("Ram")
	players       = [2]*player.Player{player1, player2}
	boardService  = NewBoardService(newBoard)
	result        = &Result{}
	resultService = NewResultService(boardService, result)
	gameService   = NewGameService(players, boardService, resultService)
)

func TestSwitchPlayer(t *testing.T) {
	actualPlayer := gameService.switchCurrentPlayer()
	if actualPlayer != player1 {
		t.Errorf("Expected player is %v, actual player is %v", player1.Name, actualPlayer.Name)
	}
	actualPlayer = gameService.switchCurrentPlayer()
	if actualPlayer != player2 {
		t.Errorf("Expected player is %v, actual player is %v", player2.Name, actualPlayer.Name)
	}
}

func TestGameResult(t *testing.T) {
	gameService.Play(0)
	gameService.Play(1)
	gameService.Play(2)
	gameService.Play(3)
	gameService.Play(5)
	gameService.Play(4)
	actual := gameService.Play(7)

	if actual.Draw {
		t.Errorf("Expected is false, Actual is %v", actual.Draw)
	}
	if actual.Win {
		t.Errorf("Expected is false, Actual is %v", actual.Win)
	}
	XMark := boardService.Board.Cells[7].GetMark()
	OMark := boardService.Board.Cells[4].GetMark()
	NoMark := boardService.Board.Cells[6].GetMark()

	if XMark != player1.Mark {
		t.Errorf("Expected is %v, Actual is %v", player1.Mark, XMark)
	}
	if OMark != player2.Mark {
		t.Errorf("Expected is %v, Actual is %v", player2.Mark, OMark)
	}
	if NoMark != components.NoMark {
		t.Errorf("Expected is %v, Actual is %v", components.OMark, NoMark)
	}

	gameService.Play(6)
	actual = gameService.Play(8)

	if actual.Draw {
		t.Errorf("Expected is false, Actual is %v", actual.Draw)
	}
	if !actual.Win {
		t.Errorf("Expected is true, Actual is %v", actual.Win)
	}
}

func TestGameDrawResult(t *testing.T) {
	gameService.Play(0)
	gameService.Play(1)
	gameService.Play(2)
	gameService.Play(3)
	gameService.Play(4)
	gameService.Play(6)
	gameService.Play(5)
	gameService.Play(8)
	actual := gameService.Play(7)

	if !actual.Draw {
		t.Errorf("Expected is true, Actual is %v", actual.Draw)
	}
	if actual.Win {
		t.Errorf("Expected is false, Actual is %v", actual.Win)
	}
}
