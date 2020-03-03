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

func TestCheckForwardDiagonal(t *testing.T) {

}
